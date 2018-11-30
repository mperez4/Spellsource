package com.hiddenswitch.spellsource;

import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.Suspendable;
import co.paralleluniverse.strands.Strand;
import co.paralleluniverse.strands.SuspendableAction1;
import com.hiddenswitch.spellsource.client.models.Envelope;
import com.hiddenswitch.spellsource.impl.ConnectionImpl;
import com.hiddenswitch.spellsource.impl.EnvelopeMessageCodec;
import com.hiddenswitch.spellsource.impl.UserId;
import com.hiddenswitch.spellsource.concurrent.SuspendableLock;
import com.hiddenswitch.spellsource.concurrent.SuspendableMap;
import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.shareddata.AsyncMap;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

import static com.hiddenswitch.spellsource.util.Sync.suspendableHandler;
import static io.vertx.ext.sync.Sync.awaitResult;

/**
 * Manages the real time data connection users get when they connect to the Spellsource server.
 * <p>
 * To set up a behaviour that uses the real time connect, use {@link Connection#connected(Handler)}, which passes you a
 * new connection to a unique user. For <b>example</b>, this code from the {@link Presence} package notifies users of
 * their presence.
 * <pre>
 *   {@code
 *     Connection.connected(Sync.suspendableHandler(connection -> {
 * 	  		final UserId key = new UserId(connection.userId());
 * 	  		connection.endHandler(Sync.suspendableHandler(ignored -> {
 * 	  			setPresence(key, PresenceEnum.OFFLINE);
 * 	  		}));
 *
 * 	  		// Once the user is connected, set their status to online
 * 	  		setPresence(key, PresenceEnum.ONLINE);
 * 	   }));
 * 	   ...
 * 	   static void setPresence(String userId) {
 * 	   	final UserId key = new UserId(userId);
 * 	   	Connection.writeStream(userId, res -> {
 * 	   		if (res.failed() || res.result() == null) {
 * 	   			setPresence(key, PresenceEnum.OFFLINE);
 * 	   		} else {
 * 	   			setPresence(key, PresenceEnum.ONLINE);
 * 	   		}
 * 	   	});
 * 	   }
 *   }
 * </pre>
 * Observe the use of the {@link Connection#writeStream(UserId)}, which allows any code anywhere to send a message to a
 * connected client. The {@link #write(Envelope)} method can also be used in the {@code connected} handler.
 */
public interface Connection extends ReadStream<Envelope>, WriteStream<Envelope>, Closeable {
	Logger LOGGER = LoggerFactory.getLogger(Connection.class);

	@Suspendable
	static SuspendableMap<UserId, String> getConnections() {
		return SuspendableMap.getOrCreate("Connection::connections");
	}

	static void getConnections(Handler<AsyncResult<AsyncMap<UserId, String>>> handler) {
		SuspendableMap.getOrCreate("Connection::connections", handler);
	}

	/**
	 * Retrieves a valid reference to write to a connection from anywhere, as long as the event bus on the other node is
	 * shared/clustered with this one.
	 *
	 * @param userId The user ID whose connection should be retrieved
	 * @return A connection object.
	 */
	@Suspendable
	static WriteStream<Envelope> writeStream(String userId) {
		SuspendableMap<UserId, String> connections = getConnections();
		String handlerId = connections.get(new UserId(userId));
		if (handlerId == null) {
			return null;
		}

		return Vertx.currentContext().owner().eventBus().publisher(handlerId);
	}

	static WriteStream<Envelope> writeStream(UserId userId) throws SuspendExecution {
		return writeStream(userId.toString());
	}

	static void writeStream(String userId, Handler<AsyncResult<WriteStream<Envelope>>> handler) {
		getConnections(r1 -> {
			if (r1.failed()) {
				handler.handle(Future.failedFuture(r1.cause()));
			} else {
				r1.result().get(new UserId(userId), r2 -> {
					if (r2.failed()) {
						handler.handle(Future.failedFuture(r2.cause()));
					} else {
						String handlerId = r2.result();
						if (handlerId != null) {
							handler.handle(Future.succeededFuture(Vertx.currentContext().owner().eventBus().publisher(handlerId)));
						} else {
							handler.handle(Future.succeededFuture());
						}
					}
				});
			}
		});
	}

	/**
	 * Creates a connection object for the specified user, marking this verticle as responsible for managing this user's
	 * connection on the cluster.
	 *
	 * @param userId
	 * @return
	 * @throws SuspendExecution
	 */
	static Connection create(String userId) throws SuspendExecution {
		SuspendableMap<UserId, String> connections = getConnections();
		String eventBusAddress = "Connection::clusteredConsumer[" + userId + "]-[" + RandomStringUtils.randomAlphanumeric(16) + "]";
		ConnectionImpl connection = new ConnectionImpl(userId, eventBusAddress);
		connections.put(new UserId(userId), eventBusAddress);
		return connection;
	}

	/**
	 * Closes the connection, if the user has one.
	 *
	 * @param userId
	 * @param handler
	 */
	static void close(String userId, Handler<AsyncResult<Void>> handler) {
		getConnections(v1 -> {
			v1.result().get(new UserId(userId), v2 -> {
				Vertx.currentContext().owner().eventBus().send(v2.result() + "::closer", Buffer.buffer("close"), res -> {
					if (res.failed()) {
						handler.handle(Future.failedFuture(res.cause()));
						return;
					}

					handler.handle(Future.succeededFuture());
				});
			});
		});
	}

	/**
	 * Creates a handler for the verticle's {@link io.vertx.ext.web.Router} that upgrades the web socket and manages the
	 * messaging over the cluster for the user.
	 *
	 * @return
	 */
	static Handler<RoutingContext> handler() {
		return suspendableHandler(Connection::connected);
	}

	static void connected(Handler<Connection> handler) {
		getHandlers().add(handler);
	}

	static Deque<Handler<Connection>> getHandlers() {
		Vertx vertx = Vertx.currentContext().owner();
		final Context context = vertx.getOrCreateContext();
		Deque<Handler<Connection>> handlers = context.get("Connection::handlers");

		if (handlers == null) {
			handlers = new ConcurrentLinkedDeque<>();
			context.put("Connection::handlers", handlers);
		}
		return handlers;
	}

	/**
	 * Obtains the unique lock for the user to prevent the user from calling more than one method at a time.
	 *
	 * @param userId
	 * @return
	 */
	@Suspendable
	static SuspendableLock methodLock(String userId) {
		return SuspendableLock.lock("Connection::method-ordering-lock[" + userId + "]");
	}

	/**
	 * A method that handles a routing context. For internal use only.
	 *
	 * @param routingContext
	 * @throws SuspendExecution
	 */
	@Suspendable
	static void connected(RoutingContext routingContext) throws SuspendExecution {
		if (routingContext.failed()) {
			routingContext.next();
			return;
		}

		registerCodecs();

		String userId = Accounts.userId(routingContext);

		if (userId == null) {
			routingContext.fail(403);
			return;
		}

		SuspendableLock lock;
		ServerWebSocket socket;

		/*
		try {
			LOGGER.debug("connection {}: Awaiting lock", userId);
			lock.set(SuspendableLock.lock("Connection::realtime[" + userId + "]", 2800));
		} catch (VertxException timeout) {
			if (timeout.getCause() instanceof TimeoutException) {
				LOGGER.debug("connection {}: Disconnecting other session", userId);
				try {
					// close and try again
					Void res = awaitResult(h -> Connection.close(userId, h));
					lock.set(SuspendableLock.lock("Connection::realtime[" + userId + "]", 4500));
				} catch (Throwable any) {
					routingContext.fail(418);
					return;
				}
			}
		} catch (Throwable any) {
			LOGGER.error("connected {}: {}", userId, any.getMessage());
			routingContext.fail(418);
			return;
		}

		*/

		// By the time we try to upgrade the socket, the request might have been closed anyway
		try {
			LOGGER.debug("connection {}: Awaiting lock", userId);
			lock = SuspendableLock.lock("Connection::realtime[" + userId + "]", 2800);
			LOGGER.debug("connection {}: Upgrading socket", userId);
			socket = routingContext.request().upgrade();
		} catch (Throwable any) {
			LOGGER.error("connected {}: {}", userId, any.getMessage());
			routingContext.fail(403);
			return;
		}

		LOGGER.debug("connection {}: Socket upgraded", userId);

		Deque<Handler<Connection>> handlers = getHandlers();
		Connection connection = create(userId);

		LOGGER.debug("connection {}: Connection created", userId);
		try {
			Void ready = awaitResult(h -> connection.setSocket(socket, h));
			// The lock gets released when the user disconnects
			connection.endHandler(suspendableHandler(v -> {
				lock.release();
				LOGGER.debug("connection {}: Lock released", userId);
			}));
			// All handlers should run simultaneously
			for (Handler<Connection> handler : handlers) {
				Vertx.currentContext().runOnContext(v -> handler.handle(connection));
			}
			connection.exceptionHandler(ex -> {
				LOGGER.error("connection exceptionHandler {}: {}", userId, ex.getMessage(), ex);
			});
			LOGGER.debug("connection {}: Connection ready", userId);
			// Sleep for safety, since it appears there are issues with event bus registrations right now
			Strand.sleep(2800);
			// Send an envelope to indicate that the connection is ready.
			connection.write(new Envelope());
		} catch (Throwable any) {
			LOGGER.error("connected {}: {}", userId, any.getMessage(), any);
			// This closes the socket and cleans up its handlers
			connection.close(Future.future());
		}
	}

	/**
	 * Registers the serialization codecs for messaging a client from another member of the cluster. For internal use
	 * only.
	 */
	static void registerCodecs() {
		try {
			Vertx.currentContext().owner().eventBus().registerDefaultCodec(Envelope.class, new EnvelopeMessageCodec());
		} catch (IllegalStateException alreadyRegistered) {
			// Ignored
		}
	}

	/**
	 * Registers the given socket to the user. For internal use only.
	 *
	 * @param socket
	 * @param readyHandler
	 */
	void setSocket(ServerWebSocket socket, Handler<AsyncResult<Void>> readyHandler);

	@Override
	default Connection exceptionHandler(Handler<Throwable> handler) {
		return null;
	}

	/**
	 * Sends a message to the client.
	 *
	 * @param data The message to send.
	 * @return This connection
	 */
	@Override
	default Connection write(Envelope data) {
		return null;
	}

	@Override
	default void end() {
	}

	@Override
	default Connection setWriteQueueMaxSize(int maxSize) {
		return null;
	}

	@Override
	default boolean writeQueueFull() {
		return false;
	}

	@Override
	default Connection drainHandler(Handler<Void> handler) {
		return null;
	}

	@Override
	default Connection handler(Handler<Envelope> handler) {
		return null;
	}

	@Override
	default Connection pause() {
		return null;
	}

	@Override
	default Connection resume() {
		return null;
	}

	@Override
	default Connection endHandler(Handler<Void> endHandler) {
		return null;
	}

	/**
	 * Gets the user ID of this connection.
	 * <p>
	 * Only authorized users can have connections.
	 *
	 * @return The user ID.
	 */
	@NotNull
	String userId();

	Connection removeHandler(Handler<Envelope> handler);
}
