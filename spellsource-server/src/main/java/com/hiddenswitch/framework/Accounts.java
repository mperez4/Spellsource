package com.hiddenswitch.framework;

import com.avast.grpc.jwt.server.JwtServerInterceptor;
import com.avast.grpc.jwt.server.JwtTokenParser;
import com.github.benmanes.caffeine.cache.AsyncCacheLoader;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.hiddenswitch.framework.impl.WeakVertxMap;
import com.hiddenswitch.framework.rpc.Hiddenswitch.*;
import com.hiddenswitch.framework.rpc.Hiddenswitch.ClientConfiguration.AccountsConfiguration;
import com.hiddenswitch.framework.rpc.Hiddenswitch.UserEntity.Builder;
import com.hiddenswitch.framework.rpc.VertxAccountsGrpc.AccountsVertxImplBase;
import com.hiddenswitch.framework.rpc.VertxUnauthenticatedGrpc.UnauthenticatedVertxImplBase;
import com.hiddenswitch.framework.rpc.VertxUnauthenticatedGrpc.UnauthenticatedVertxStub;
import com.hiddenswitch.framework.schema.keycloak.tables.daos.UserEntityDao;
import com.hiddenswitch.framework.schema.keycloak.tables.pojos.UserEntity;
import com.lambdaworks.crypto.SCryptUtil;
import io.grpc.*;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.Shareable;
import io.vertx.ext.auth.impl.jose.JWT;
import io.vertx.ext.web.client.WebClient;
import org.apache.commons.validator.routines.EmailValidator;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jetbrains.annotations.NotNull;
import org.keycloak.TokenVerifier;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.common.VerificationException;
import org.keycloak.common.enums.SslRequired;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.models.utils.ModelToRepresentation;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.idm.*;

import javax.ws.rs.NotFoundException;
import java.net.URI;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * Implements the account services from {@link AccountsVertxImplBase} against Keycloak, the open source Java identity
 * management application.
 * <p>
 * In the server, a {@link Keycloak} instance is used to create and manage user accounts.
 * <p>
 * The client creates an account with {@link UnauthenticatedVertxStub#createAccount(CreateAccountRequest)}. The access
 * token returned by the reply, {@link LoginOrCreateReply#getAccessTokenResponse()}'s
 * {@link AccessTokenResponse#getToken()}
 * <p>
 * Keycloak manages the migration of the {@link com.hiddenswitch.framework.schema.keycloak.Keycloak} SQL schema. The
 * {@link com.hiddenswitch.framework.schema.keycloak.tables.UserEntity} table's
 * {@link com.hiddenswitch.framework.schema.keycloak.tables.UserEntity#ID} field is the user ID used throughout the
 * application.
 */
public class Accounts {
	protected static final String KEYCLOAK_LOGIN_PATH = "/realms/hiddenswitch/protocol/openid-connect/token";
	protected static final String KEYCLOAK_FORGOT_PASSWORD_PATH = "/realms/hiddenswitch/login-actions/reset-credentials";
	private static final String RSA = "RSA";
	private static final WeakVertxMap<Keycloak> keycloakReference = new WeakVertxMap<>(Accounts::keycloakConstructor);
	private static final WeakVertxMap<PublicKeyJwtServerInterceptor> interceptor = new WeakVertxMap<>(Accounts::authorizationInterceptorConstructor);
	private static final AsyncLoadingCache<String, PublicKey> keys = Caffeine.newBuilder()
			.buildAsync((key, executor) -> get().toCompletionStage().thenCompose(realm -> {
				var keys = realm.keys().getKeyMetadata().getKeys();
				var keyBase64 = keys.stream().filter(x -> x.getKid().equals(key)).findFirst();
				if (keyBase64.isEmpty()) {
					final var inKey = key;
					return CompletableFuture.failedFuture(new NoSuchElementException("could not find key") {
						public final String key = inKey;
						public final String[] existingKeys = keys.stream().map(KeysMetadataRepresentation.KeyMetadataRepresentation::getKid).toArray(String[]::new);
					});
				}
				var keyBytes = Base64.getDecoder().decode(keyBase64.get().getPublicKey());
				var encodedKeySpec = new X509EncodedKeySpec(keyBytes);
				try {
					var factory = KeyFactory.getInstance(RSA);
					return CompletableFuture.completedFuture(factory.generatePublic(encodedKeySpec));
				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
					return CompletableFuture.failedFuture(new RuntimeException(e));
				}
			}).toCompletableFuture());

	/**
	 * Helps cache the JWT public key.
	 */
	private interface PublicKeyStorage {
		PublicKey get();

		void set(PublicKey publicKey);
	}

	private static class VertxPublicKeyStorage implements PublicKeyStorage {

		private static class ShareablePublicKey implements Shareable {
			private final PublicKey value;

			public ShareablePublicKey(PublicKey value) {
				this.value = value;
			}

			public PublicKey getValue() {
				return value;
			}
		}

		private final Vertx vertx;

		public VertxPublicKeyStorage(Vertx vertx) {
			this.vertx = vertx;
		}

		@Override
		public PublicKey get() {
			var res = ((ShareablePublicKey) vertx.sharedData().getLocalMap("Accounts:VertxPublicKeyStorage").get("publicKey"));
			return res == null ? null : res.getValue();
		}

		@Override
		public void set(PublicKey publicKey) {
			vertx.sharedData().getLocalMap("Accounts:VertxPublicKeyStorage").put("publicKey", new ShareablePublicKey(publicKey));
		}
	}

	private static class AtomicReferencePublicKeyStorage implements PublicKeyStorage {

		private static final AtomicReference<PublicKey> publicKey = new AtomicReference<>();

		@Override
		public PublicKey get() {
			return publicKey.get();
		}

		@Override
		public void set(PublicKey publicKey) {
			AtomicReferencePublicKeyStorage.publicKey.set(publicKey);
		}
	}

	private static PublicKeyJwtServerInterceptor authorizationInterceptorConstructor(Vertx vertx) {
		return new PublicKeyJwtServerInterceptor(accessToken -> {
			var kid = getKid(accessToken);
			if (kid == null) {
				final String inToken = accessToken;
				return CompletableFuture.failedFuture(new IllegalArgumentException("access token could not be parsed for kid") {
					public final String accessToken = inToken;
				});
			}

			return keys.get(kid)
					.thenCompose(publicKey -> verify(accessToken, publicKey));
		});
	}

	private static String getKid(String accessToken) {
		try {
			JsonObject parsed = JWT.parse(accessToken);
			return parsed.getJsonObject("header").getString("kid");
		} catch (Throwable t) {
			return null;
		}
	}

	/**
	 * Verifies that a Java Web Token was signed by the supplied public key.
	 * <p>
	 * Uses Keycloak's model of an access token, {@link AccessToken}.
	 *
	 * @param jwt The token
	 * @param pk  the public key
	 * @return The decoded {@link AccessToken}
	 */
	@NotNull
	public static CompletableFuture<AccessToken> verify(String jwt, PublicKey pk) {
		Objects.requireNonNull(pk, "public key is null");
		var verified = TokenVerifier.create(jwt, AccessToken.class);
		verified.publicKey(pk);
		try {
			verified.verify();
			return CompletableFuture.completedFuture(verified.getToken());
		} catch (VerificationException e) {
			return CompletableFuture.failedFuture(e);
		}
	}

	private static class PublicKeyJwtServerInterceptor extends JwtServerInterceptor<AccessToken> {
		public PublicKeyJwtServerInterceptor(JwtTokenParser<AccessToken> tokenParser) {
			super(tokenParser);
		}
	}

	/**
	 * A GRPC {@link ServerInterceptor} that authorizes requests.
	 *
	 * @return an interceptor
	 */
	public static Future<ServerInterceptor> authorizationInterceptor() {
		return Future.succeededFuture(interceptor.get());
	}

	/**
	 * Gets the user associated with the GRPC context currently being executed.
	 * <p>
	 * This must be called first in the GRPC method implementation body:
	 * <pre>
	 *   {@code
	 *    Future<Empty> grpcMethodOverride(Empty request) {
	 *      var userRequest = Accounts.user();
	 *      userRequest
	 *        .compose(user -> ...)
	 *        .onComplete(request);
	 *    }
	 *   }
	 * </pre>
	 * <p>
	 * Since vertx code is typically async, the GRPC context's data is only valid in the first scope of the GRPC server
	 * implementation.
	 *
	 * @return A {@link UserEntity} SQL model of a user record
	 * @see #userId() when the user ID will suffice
	 */
	public static Future<UserEntity> user() {
		// are we in a grpc context?
		var interceptor = Accounts.interceptor.get();
		if (interceptor != null) {
			var accessTokenContextKey = interceptor.AccessTokenContextKey;
			if (accessTokenContextKey != null) {
				var accessToken = accessTokenContextKey.get();
				if (accessToken == null) {
					return Future.succeededFuture();
				} else {
					return (new UserEntityDao(Environment.jooqAkaDaoConfiguration(), Environment.sqlPoolAkaDaoDelegate())).findOneById(accessToken.getSubject());
				}
			}
		}

		// For now we do not support getting the context any other way
		return Future.failedFuture("no context");
	}

	/**
	 * Retrieves the user ID in a GRPC context.
	 * <p>
	 * This must be called first in the GRPC method implementation body:
	 * <pre>
	 *   {@code
	 *    Future<Empty> grpcMethodOverride(Empty request) {
	 *      var userRequest = Accounts.user();
	 *      userRequest
	 *        .compose(user -> ...)
	 *        .onComplete(request);
	 *    }
	 *   }
	 * </pre>
	 * <p>
	 * Since vertx code is typically async, the GRPC context's data is only valid in the first scope of the GRPC server
	 * implementation.
	 *
	 * @return a user ID, or {@code null} if no token was retrieved
	 */
	public static String userId() {
		var interceptor = Accounts.interceptor.get();
		if (interceptor != null) {
			var accessTokenContextKey = interceptor.AccessTokenContextKey;
			if (accessTokenContextKey != null) {
				var accessToken = accessTokenContextKey.get();
				if (accessToken == null) {
					return null;
				} else {
					return accessToken.getSubject();
				}
			}
		}
		return null;
	}

	/**
	 * Creates a {@link UnauthenticatedVertxImplBase} implementation that handles account creation and logins over GRPC.
	 * <p>
	 * Eventually, the client will be ported to use native OAuth2 account creation provided by Keycloak.
	 *
	 * @return a {@link BindableService} for a {@link io.vertx.grpc.VertxServerBuilder#addService(BindableService)} call.
	 */
	public static Future<BindableService> unauthenticatedService() {
		var context = Vertx.currentContext();
		Objects.requireNonNull(context, "context");

		var webClient = WebClient.create(context.owner());

		return Future.succeededFuture(new UnauthenticatedVertxImplBase() {

			private LoginOrCreateReply handleAccessTokenUserEntityTuple(Object[] tuple) {
				var accessTokenResponse = (org.keycloak.representations.AccessTokenResponse) tuple[0];
				var userEntity = (UserEntity) tuple[1];
				return LoginOrCreateReply.newBuilder()
						.setUserEntity(toProto(userEntity))
						.setAccessTokenResponse(AccessTokenResponse.newBuilder().setToken(accessTokenResponse.getToken()).build()).build();
			}

			@Override
			public Future<LoginOrCreateReply> createAccount(CreateAccountRequest request) {
				if (!EmailValidator.getInstance().isValid(request.getEmail())) {
					return Future.failedFuture(Status.INVALID_ARGUMENT.withDescription("The e-mail address isn't valid.").asRuntimeException());
				}
				if (request.getUsername().length() <= 4) {
					return Future.failedFuture(Status.INVALID_ARGUMENT.withDescription("The username must be at least 4 characters.").asRuntimeException());
				}
				if (request.getPassword().length() <= 4) {
					return Future.failedFuture(Status.INVALID_ARGUMENT.withDescription("The password must be at least 4 characters.").asRuntimeException());
				}

				return get()
						.compose(realm -> Environment.executeBlocking(() -> realm.users().search(request.getUsername(), true)))
						.compose(existingUsers -> {
							if (!existingUsers.isEmpty()) {
								return Future.failedFuture(Status.INVALID_ARGUMENT.withDescription("This username already exists.").asRuntimeException());
							}

							return createUser(request.getEmail(), request.getUsername(), request.getPassword())
									.recover(t -> Future.failedFuture(Status.INVALID_ARGUMENT.withDescription("The username, e-mail or password are invalid. Please check them and try again.").asRuntimeException()));
						})
						.compose(userEntity -> {
							// Login here
							var client = new Client(context.owner(), webClient);
							return client.login(request.getEmail(), request.getPassword()).map(accessTokenResponse -> new Object[]{accessTokenResponse, userEntity});
						})
						.map(this::handleAccessTokenUserEntityTuple)
						.recover(Environment.onGrpcFailure());
			}

			@Override
			public Future<LoginOrCreateReply> login(LoginRequest request) {
				var client = new Client(context.owner(), webClient);
				return client.login(request.getUsernameOrEmail(), request.getPassword())
						.onComplete(v -> client.closeFut())
						.compose(accessTokenResponse -> {
							var token = TokenVerifier.create(accessTokenResponse.getToken(), AccessToken.class);
							try {
								var userId = token.getToken().getSubject();
								var userEntityRes = (new UserEntityDao(Environment.jooqAkaDaoConfiguration(), Environment.sqlPoolAkaDaoDelegate()))
										.findOneById(userId);
								return userEntityRes.map(userEntity -> new Object[]{accessTokenResponse, userEntity});
							} catch (VerificationException e) {
								return Future.failedFuture(e);
							}
						})
						.map(this::handleAccessTokenUserEntityTuple)
						.recover(t -> Future.failedFuture(Status.INVALID_ARGUMENT.withDescription("The username, email or password are invalid.").asRuntimeException()));
			}

			@Override
			public Future<BoolValue> verifyToken(AccessTokenResponse request) {
				var context = Vertx.currentContext();
				var kid = getKid(request.getToken());
				if (kid == null) {
					return Future.succeededFuture(BoolValue.of(false));
				}
				return Future.fromCompletionStage(keys.get(kid))
						.compose(pk -> Future.fromCompletionStage(verify(request.getToken(), pk).minimalCompletionStage(), context))
						.map(BoolValue.of(true))
						.otherwise(BoolValue.of(false))
						.recover(Environment.onGrpcFailure());
			}

			@Override
			public Future<ClientConfiguration> getConfiguration(Empty request) {
				var config = Environment.getConfiguration();
				var authUrl = config.getKeycloak().getPublicAuthUrl();
				return Future.succeededFuture(ClientConfiguration.newBuilder()
						.setAccounts(AccountsConfiguration.newBuilder()
								.setKeycloakResetPasswordUrl(URI.create(authUrl + KEYCLOAK_FORGOT_PASSWORD_PATH).normalize().toString())
								.setKeycloakAccountManagementUrl(URI.create(authUrl + KEYCLOAK_LOGIN_PATH).normalize().toString())
								.build())
						.build());
			}
		});
	}

	/**
	 * Creates a {@link AccountsVertxImplBase} instance that handles account services for users that have logged in.
	 *
	 * @return a service for {@link io.vertx.grpc.VertxServerBuilder#addService(ServerServiceDefinition)}
	 */
	public static Future<ServerServiceDefinition> authenticatedService() {
		// Does not require vertx blocking service because it makes no blocking calls
		return Future.succeededFuture(new AccountsVertxImplBase() {

					@Override
					public Future<LoginOrCreateReply> changePassword(ChangePasswordRequest request) {
						var userId = Accounts.userId();
						// for now we don't invalidate and refresh the old token
						var token = Accounts.token();
						if (token == null) {
							return Future.failedFuture("must log in with old password first");
						}
						return get()
								.compose(realm -> Environment.executeBlocking(() -> {
									realm.users().get(userId).resetPassword(getPasswordCredential(request.getNewPassword()));
									return Future.succeededFuture();
								}))
								.compose(v -> (new UserEntityDao(Environment.jooqAkaDaoConfiguration(), Environment.sqlPoolAkaDaoDelegate()).findOneById(userId)))
								.map(userEntity -> LoginOrCreateReply.newBuilder()
										.setUserEntity(toProto(userEntity))
										.setAccessTokenResponse(AccessTokenResponse.newBuilder()
												.setToken(token)
												.build()).build())
								.recover(Environment.onGrpcFailure());
					}

					@Override
					public Future<GetAccountsReply> getAccount(Empty request) {
						return user()
								.compose(thisUser -> {
									if (thisUser == null) {
										return Future.failedFuture("must log in");
									}

									return Future.succeededFuture(GetAccountsReply.newBuilder().addUserEntities(
											com.hiddenswitch.framework.rpc.Hiddenswitch.UserEntity.newBuilder()
													.setUsername(thisUser.getUsername())
													.setEmail(thisUser.getEmail())
													.setId(thisUser.getId())
													.build()
									).build());
								})
								.recover(Environment.onGrpcFailure());
					}

					@Override
					public Future<GetAccountsReply> getAccounts(GetAccountsRequest request) {
						return user()
								.compose(thisUser -> {
									if (thisUser == null) {
										return Future.failedFuture("must log in");
									}

									// TODO: Join with friends
									return (new UserEntityDao(Environment.jooqAkaDaoConfiguration(), Environment.sqlPoolAkaDaoDelegate()))
											.findManyByIds(request.getIdsList())
											.map(users ->
													GetAccountsReply.newBuilder()
															.addAllUserEntities(users.stream().map(ue -> {
																var build = com.hiddenswitch.framework.rpc.Hiddenswitch.UserEntity.newBuilder()
																		.setUsername(ue.getUsername())
																		.setId(ue.getId());

																if (ue.getId().equals(thisUser.getId())) {
																	build.setEmail(ue.getEmail());
																}
																return build.build();
															}).collect(Collectors.toList())).build());
								})
								.recover(Environment.onGrpcFailure());
					}
				})
				.compose(Accounts::requiresAuthorization);
	}

	private static Builder toProto(UserEntity userEntity) {
		return com.hiddenswitch.framework.rpc.Hiddenswitch.UserEntity.newBuilder()
				.setEmail(userEntity.getEmail())
				.setUsername(userEntity.getUsername())
				.setId(userEntity.getId());
	}

	private static String token() {
		// from JwtServerInterceptor
		return (String) Context.key("AccessToken").get();
	}

	public static Future<ServerServiceDefinition> requiresAuthorization(BindableService service) {
		return Accounts.authorizationInterceptor()
				.compose(interceptor -> Future.succeededFuture(ServerInterceptors.intercept(service, interceptor)));
	}

	public static Future<ServerServiceDefinition> requiresAuthorization(ServerServiceDefinition service) {
		return Accounts.authorizationInterceptor()
				.compose(interceptor -> Future.succeededFuture(ServerInterceptors.intercept(service, interceptor)));
	}

	public static Future<Keycloak> admin() {
		return Future.succeededFuture(keycloakReference.get());
	}

	public static Future<RealmResource> get() {
		return Environment.executeBlocking(() -> {
					var realmId = Environment.getConfiguration().getKeycloak().getRealmId();
					return keycloakReference.get().realm(realmId);
				})
				.onFailure(Environment.onFailure());
	}

	private static AtomicInteger v = new AtomicInteger();

	public static Future<UserEntity> createUser(String email, String username, String password) {
		return get()
				.compose(realm -> {
					var user = new UserRepresentation();
					user.setEmail(email);
					user.setUsername(username);
					user.setEnabled(true);
					var credential = new CredentialRepresentation();
					credential.setType(CredentialRepresentation.PASSWORD);
					credential.setValue(password);
					credential.setTemporary(false);
					user.setCredentials(Collections.singletonList(credential));

					// TODO: Not sure yet how to get the ID of the user you just created
					return Environment.executeBlocking(() -> {
						var response = realm.users().create(user);
						if (response.getStatus() >= 400) {
							throw new RuntimeException();
						}
						return response;
					}).map(response -> {
						var parts = response.getLocation().getPath().split("/");
						var id = parts[parts.length - 1];
						user.setId(id);
						return user;
					});
				})
				.compose(userRepresentation -> {
					var users = new UserEntityDao(Environment.jooqAkaDaoConfiguration(), Environment.sqlPoolAkaDaoDelegate());
					return users.findOneById(userRepresentation.getId());
				})
				.compose(userEntity -> {
					if (userEntity == null) {
						return Future.failedFuture(new ArrayIndexOutOfBoundsException("invalid user creation result"));
					}
					return Future.succeededFuture(userEntity);
				});
	}

	public static Future<UserEntity> createUserWithHashed(String email, String username, String scryptHashedPassword) {
		return get()
				.compose(realm -> {
					var credentialModel = PasswordCredentialModel.createFromValues("scrypt", new byte[0], 1, scryptHashedPassword);
					var credential = ModelToRepresentation.toRepresentation(credentialModel);
					credential.setTemporary(false);
					var user = new UserRepresentation();
					user.setEmail(email);
					user.setUsername(username);
					user.setEnabled(true);
					user.setCredentials(Collections.singletonList(credential));
					return Environment.executeBlocking(() -> {
						var response = realm.users().create(user);
						if (response.getStatus() >= 400) {
							throw new RuntimeException("A user with the specified e-mail or username already exists.");
						}
						return response;
					}).map(response -> {
						var parts = response.getLocation().getPath().split("/");
						var id = parts[parts.length - 1];
						user.setId(id);
						return user;
					}).map(UserRepresentation::getId);
				})
				.compose(userId -> {
					var users = new UserEntityDao(Environment.jooqAkaDaoConfiguration(), Environment.sqlPoolAkaDaoDelegate());
					return users.findOneById(userId);
				})
				.compose(res -> res == null ? Future.failedFuture("invalid user ID") : Future.succeededFuture(res))
				.onFailure(Environment.onFailure());
	}

	@NotNull
	private static CredentialRepresentation getPasswordCredential(String password) {
		var credentialModel = PasswordCredentialModel.createFromValues("scrypt", new byte[0], 1, SCryptUtil.scrypt(password, 2048, 8, 1));
		var credential = ModelToRepresentation.toRepresentation(credentialModel);
		credential.setTemporary(false);
		return credential;
	}

	private static Keycloak keycloakConstructor(Vertx vertx) {
		var client = (ResteasyClientBuilder) ResteasyClientBuilder.newBuilder();
		/* TODO: Use a regular blocking client for now, until this is updated for 4.0
		if (vertx != null) {
			var engine = new VertxClientHttpEngine(vertx);
			client.httpEngine(engine);
		}*/
		var config = Environment.getConfiguration();
		return KeycloakBuilder.builder()
				.serverUrl(config.getKeycloak().getAuthUrl())
				.realm("master")
				.username(config.getKeycloak().getAdminUsername())
				.password(config.getKeycloak().getAdminPassword())
				.clientId("admin-cli")
				.grantType("password")
				.resteasyClient(client.build())
				.build();
	}

	public static Future<UserResource> disableUser(String userId) {
		return Accounts.get()
				.compose(realm -> Environment.executeBlocking(() -> {
					var userRepresentation = new UserRepresentation();
					userRepresentation.setEnabled(false);
					realm.users().get(userId).disableCredentialType(Collections.singletonList(CredentialRepresentation.PASSWORD));
					var userResource = realm.users().get(userId);
					userResource.update(userRepresentation);
					return userResource;
				}))
				.onFailure(Environment.onFailure());
	}

	public static Future<RealmResource> createRealmIfAbsent() {
		return Environment.executeBlocking(() -> {
					var configuration = Environment.getConfiguration();
					var keycloak = keycloakReference.get();
					var existing = Optional.<RealmRepresentation>empty();
					var realmId = configuration.getKeycloak().getRealmId();
					try {
						existing = keycloak.realms().findAll().stream().filter(realm -> realm.getRealm().equals(realmId)).findFirst();
					} catch (NotFoundException ignored) {
					}

					if (existing.isPresent()) {
						return keycloak.realm(realmId);
					}

					// Create a default
					var realmRepresentation = new RealmRepresentation();
					realmRepresentation.setRealm(realmId);
					realmRepresentation.setDisplayName(configuration.getKeycloak().getRealmDisplayName());
					realmRepresentation.setSslRequired(SslRequired.EXTERNAL.toString());
					realmRepresentation.setEnabled(true);
					// use scrypt provider
					realmRepresentation.setPasswordPolicy("hashAlgorithm(scrypt)");
					realmRepresentation.setRegistrationAllowed(true);
					realmRepresentation.setResetPasswordAllowed(true);
					realmRepresentation.setResetCredentialsFlow("reset credentials");
					realmRepresentation.setRegistrationFlow("registration");
					realmRepresentation.setRememberMe(true);
					realmRepresentation.setLoginWithEmailAllowed(true);

					keycloak.realms().create(realmRepresentation);

					var realm = keycloak.realms().realm(realmId);
					var flows = realm.flows().getFlows()
							.stream().collect(toMap(AuthenticationFlowRepresentation::getAlias, AuthenticationFlowRepresentation::getId));
					var client = new ClientRepresentation();
					client.setClientId(configuration.getKeycloak().getClientId());
					client.setDirectAccessGrantsEnabled(true);

					// Should now be confidential
					client.setClientAuthenticatorType("client-secret");
					client.setServiceAccountsEnabled(false);
					client.setStandardFlowEnabled(true);
					client.setSecret(configuration.getKeycloak().getClientSecret());
					client.setRedirectUris(Collections.singletonList("/oauth2callback"));
					client.setAuthenticationFlowBindingOverrides(ImmutableMap.of(
							"direct_grant", flows.get("direct grant"),
							"browser", flows.get("browser")
					));

					client.setWebOrigins(Collections.singletonList("+"));
					realm.clients().create(client);
					return realm;
				})
				.onFailure(Environment.onFailure());
	}

	public synchronized static String keycloakAuthUrl() {
		return Environment.getConfiguration().getKeycloak().getAuthUrl();
	}
}
