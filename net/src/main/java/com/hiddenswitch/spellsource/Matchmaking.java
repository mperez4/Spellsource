package com.hiddenswitch.spellsource;

import com.github.fromage.quasi.fibers.Fiber;
import com.github.fromage.quasi.fibers.SuspendExecution;
import com.github.fromage.quasi.fibers.Suspendable;
import com.github.fromage.quasi.strands.SuspendableAction1;
import com.github.fromage.quasi.strands.concurrent.CountDownLatch;
import com.github.fromage.quasi.strands.concurrent.CyclicBarrier;
import com.hiddenswitch.spellsource.client.models.*;
import com.hiddenswitch.spellsource.concurrent.*;
import com.hiddenswitch.spellsource.impl.DeckId;
import com.hiddenswitch.spellsource.impl.GameId;
import com.hiddenswitch.spellsource.impl.UserId;
import com.hiddenswitch.spellsource.impl.util.UserRecord;
import com.hiddenswitch.spellsource.models.*;
import com.hiddenswitch.spellsource.util.*;
import io.vertx.core.*;
import io.vertx.core.streams.WriteStream;
import net.demilich.metastone.game.cards.desc.CardDesc;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static com.hiddenswitch.spellsource.util.Sync.invoke;
import static com.hiddenswitch.spellsource.util.Sync.suspendableHandler;
import static io.vertx.ext.sync.Sync.awaitEvent;
import static io.vertx.ext.sync.Sync.awaitResult;
import static io.vertx.ext.sync.Sync.getContextScheduler;

/**
 * The matchmaking service is the primary entry point into ranked games for clients.
 */
public interface Matchmaking extends Verticle {
	Logger LOGGER = LoggerFactory.getLogger(Matchmaking.class);

	/**
	 * Gets information about the current match the user is in. This is used for reconnecting.
	 *
	 * @param request The user's ID.
	 * @return The current match information. This may be a queue entry, the match, or nothing (but not null) if the user
	 * 		is not in a match.
	 * @throws SuspendExecution
	 * @throws InterruptedException
	 */
	static CurrentMatchResponse getCurrentMatch(CurrentMatchRequest request) throws SuspendExecution, InterruptedException {
		GameId gameId = Games.getUsersInGames().get(new UserId(request.getUserId()));
		if (gameId != null) {
			return CurrentMatchResponse.response(gameId.toString());
		} else {
			return CurrentMatchResponse.response(null);
		}
	}

	/**
	 * Enqueues the user with the specified request.
	 *
	 * @param request The matchmaking request
	 * @return {@code true} if the user had successfully enqueued.
	 */
	@Suspendable
	static boolean enqueue(MatchmakingRequest request) throws SuspendExecution, NullPointerException, IllegalStateException {
		SuspendableLock lock = null;
		LOGGER.trace("enqueue {}: Enqueueing {}", request.getUserId(), request);
		boolean succeeded = false;
		try {
			lock = Connection.methodLock(request.getUserId());
			// Check if the user is already in a game
			UserId userId = new UserId(request.getUserId());
			if (Games.getUsersInGames().containsKey(userId)) {
				throw new IllegalStateException("User is already in a game");
			}

			SuspendableMap<UserId, String> currentQueue = getUsersInQueues();
			boolean alreadyQueued = currentQueue.putIfAbsent(userId, request.getQueueId()) != null;
			if (alreadyQueued) {
				throw new IllegalStateException("User is already enqueued in a different queue.");
			}

			SuspendableQueue<MatchmakingQueueEntry> queue = SuspendableQueue.get(request.getQueueId());
			if (!queue.offer(new MatchmakingQueueEntry()
					.setCommand(MatchmakingQueueEntry.Command.ENQUEUE)
					.setUserId(request.getUserId())
					.setRequest(request), succeeded)) {
				throw new NullPointerException(String.format("queueId=%s not found", request.getQueueId()));
			}
			LOGGER.trace("enqueue {}: Successfully enqueued", request.getUserId());
			succeeded = true;
		} finally {
			if (lock != null) {
				lock.release();
			}
		}
		return succeeded;
	}

	/**
	 * Records which queue a user is currently occupying.
	 *
	 * @return
	 */
	@NotNull
	@Suspendable
	static SuspendableMap<UserId, String> getUsersInQueues() {
		return SuspendableMap.getOrCreate("Matchmaking::currentQueue");
	}

	@Suspendable
	static void dequeue(UserId userId) throws SuspendExecution {
		SuspendableLock lock = Connection.methodLock(userId.toString());
		try {
			SuspendableMap<UserId, String> currentQueue = getUsersInQueues();
			String queueId = currentQueue.remove(userId);
			if (queueId != null) {
				SuspendableQueue<MatchmakingQueueEntry> queue = SuspendableQueue.get(queueId);
				queue.offer(new MatchmakingQueueEntry()
						.setCommand(MatchmakingQueueEntry.Command.CANCEL)
						.setUserId(userId.toString()), false);
				LOGGER.trace("dequeue {}: Successfully dequeued", userId);
			} else {
				LOGGER.trace("dequeue {}: User was not enqueued", userId);
			}
		} finally {
			lock.release();
		}
	}

	@Suspendable
	static Closeable startDefaultQueues() throws SuspendExecution {
		Closeable constructed = startMatchmaker("constructed", new MatchmakingQueueConfiguration()
				.setBotOpponent(false)
				.setLobbySize(2)
				.setName("Constructed")
				.setOnce(false)
				.setPrivateLobby(false)
				.setRanked(true)
				.setRules(new CardDesc[0])
				.setStillConnectedTimeout(1000L)
				.setStartsAutomatically(true));

		Closeable quickPlay = startMatchmaker("quickPlay", new MatchmakingQueueConfiguration()
				.setBotOpponent(true)
				.setLobbySize(1)
				.setName("Quick Play")
				.setOnce(false)
				.setPrivateLobby(false)
				.setRanked(false)
				.setRules(new CardDesc[0])
				.setStillConnectedTimeout(4000L)
				.setStartsAutomatically(true));

		return (completionHandler -> constructed.close(v1 -> quickPlay.close(completionHandler)));
	}

	@Suspendable
	static Closeable startMatchmaker(String queueId, MatchmakingQueueConfiguration queueConfiguration) throws SuspendExecution {
		CountDownLatch awaitReady = new CountDownLatch(1);
		Fiber<Void> fiber = getContextScheduler().newFiber(() -> {
			// There should only be one matchmaker per queue per cluster. The lock here will make this invocation
			SuspendableLock lock = null;
			SuspendableQueue<MatchmakingQueueEntry> queue = null;
			try {
				lock = SuspendableLock.lock("Matchmaking::queues[" + queueId + "]");
				queue = SuspendableQueue.get(queueId);
				SuspendableMap<UserId, String> userToQueue = getUsersInQueues();

				List<MatchmakingRequest> thisMatchRequests = new ArrayList<>();

				// Dequeue requests
				do {
					LOGGER.trace("startMatchmaker {}: Awaiting {} users", queueId, queueConfiguration.getLobbySize());
					awaitReady.countDown();

					while (thisMatchRequests.size() < queueConfiguration.getLobbySize()) {
						MatchmakingQueueEntry request;
						if (queueConfiguration.getEmptyLobbyTimeout() > 0L && thisMatchRequests.isEmpty()) {
							request = queue.poll(queueConfiguration.getEmptyLobbyTimeout());
						} else if (queueConfiguration.getAwaitingLobbyTimeout() > 0L && !thisMatchRequests.isEmpty()) {
							request = queue.poll(queueConfiguration.getAwaitingLobbyTimeout());
						} else {
							request = queue.take();
						}

						if (request == null) {
							// The request timed out.
							// Remove any awaiting users, then break
							for (MatchmakingRequest existingRequest : thisMatchRequests) {
								userToQueue.remove(new UserId(existingRequest.getUserId()));
								WriteStream<Envelope> connection = Connection.writeStream(existingRequest.getUserId());
								if (connection != null) {
									// Notify the user they were dequeued
									connection.write(new Envelope().result(new EnvelopeResult().dequeue(new DefaultMethodResponse())));
								}
							}
							// queue.destroy() is dealt with outside of here
							break;
						}

						switch (request.getCommand()) {
							case ENQUEUE:
								thisMatchRequests.add(request.getRequest());
								LOGGER.trace("startMatchmaker {}: Queued {}", queueId, request.getUserId());
								break;
							case CANCEL:
								thisMatchRequests.removeIf(existingReq -> existingReq.getUserId().equals(request.getUserId()));
								userToQueue.remove(new UserId(request.getUserId()));
								LOGGER.trace("startMatchmaker {}: Dequeued {}", queueId, request.getUserId());
								break;
						}
					}

					GameId gameId = GameId.create();

					// Is this a bot game?
					if (queueConfiguration.isBotOpponent()) {
						// Actually creating the game can happen without joining
						// Create a bot game.
						MatchmakingRequest user = thisMatchRequests.get(0);
						SuspendableLock botLock = SuspendableLock.lock(Bots.TAKING_BOT_LOCK_NAME);

						try {
							// TODO: Move this lock into pollBotId
							// The player has been waiting too long. Match to an AI.
							// Retrieve a bot and use it to play against the opponent
							UserRecord bot = Accounts.get(Bots.pollBotId());

							DeckId botDeckId = user.getBotDeckId() == null
									? new DeckId(Bots.getRandomDeck(bot))
									: new DeckId(user.getBotDeckId());

							Games.createGame(ConfigurationRequest.botMatch(
									gameId,
									new UserId(user.getUserId()),
									new UserId(bot.getId()),
									new DeckId(user.getDeckId()),
									botDeckId));
						} finally {
							botLock.release();
						}

						WriteStream<Envelope> connection = Connection.writeStream(user.getUserId());

						if (connection != null) {
							connection.write(gameReadyMessage());
						}

						userToQueue.remove(new UserId(user.getUserId()));

						thisMatchRequests.clear();
						continue;
					}

					// Create a game for every pair
					if (thisMatchRequests.size() % 2 != 0) {
						throw new AssertionError("thisMatchRequests.size()");
					}

//					if (queueConfiguration.isStartsAutomatically())
					LOGGER.trace("startMatchmaker {}: Creating game", queueId);
					for (int i = 0; i < thisMatchRequests.size(); i += 2) {
						MatchmakingRequest user1 = thisMatchRequests.get(i);
						MatchmakingRequest user2 = thisMatchRequests.get(i + 1);

						// This is a standard two player competitive match
						ConfigurationRequest request =
								ConfigurationRequest.versusMatch(gameId,
										new UserId(user1.getUserId()),
										new DeckId(user1.getDeckId()),
										new UserId(user2.getUserId()),
										new DeckId(user2.getDeckId()));
						Games.createGame(request);

						LOGGER.trace("startMatchmaker {}: Created game for {} and {}", queueId, user1.getUserId(), user2.getUserId());

						for (WriteStream innerConnection : new WriteStream[]{Connection.writeStream(user1.getUserId()), Connection.writeStream(user2.getUserId())}) {
							@SuppressWarnings("unchecked")
							WriteStream<Envelope> connection = (WriteStream<Envelope>) innerConnection;
							if (connection != null) {
								connection.write(gameReadyMessage());
							}
						}

						userToQueue.remove(new UserId(user1.getUserId()));
						userToQueue.remove(new UserId(user2.getUserId()));
					}

					thisMatchRequests.clear();
				} while (/*Queues that run once are typically private games*/!queueConfiguration.isOnce());
			} catch (VertxException | InterruptedException ex) {
				// Cancelled
			} finally {
				if (lock != null) {
					lock.release();
				}

				// Private lobby locks should be destroyed once they reach here
				if (lock != null && queueConfiguration.isPrivateLobby()) {
					lock.destroy();
				}

				if (queue != null) {
					queue.destroy();
				}
			}
			return null;
		});

		// We don't join on the fiber (we don't wait until the queue has actually started), we return immediately.
		fiber.start();

		AtomicReference<Fiber<Void>> thisFiber = new AtomicReference<>(fiber);
		if (queueConfiguration.isJoin()) {
			try {
				awaitReady.await();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		return completionHandler -> {
			// Don't interrupt twice if something else makes this fiber end early.
			if (thisFiber.get().isAlive() && thisFiber.get().isInterrupted()) {
				thisFiber.get().interrupt();
			}

			completionHandler.handle(Future.succeededFuture());
		};
	}

	/**
	 * Returns the message that indicates that a game is ready to play.
	 *
	 * @return
	 */
	static Envelope gameReadyMessage() {
		return new Envelope()
				.result(new EnvelopeResult()
						.enqueue(new MatchmakingQueuePutResponse()
								.unityConnection(new MatchmakingQueuePutResponseUnityConnection().firstMessage(new ClientToServerMessage()
										.messageType(MessageType.FIRST_MESSAGE)
										.firstMessage(new ClientToServerMessageFirstMessage())))));
	}

	static void handleConnections() {
		Connection.connected(connection -> {
			// If the user disconnects, dequeue them immediately.
			connection.endHandler(suspendableHandler((SuspendableAction1<Void>) v -> {
				dequeue(new UserId(connection.userId()));
			}));

			connection.handler(suspendableHandler((SuspendableAction1<Envelope>) msg -> {
				EnvelopeMethod method = msg.getMethod();

				if (method != null) {
					if (method.getEnqueue() != null) {
						LOGGER.trace("handleConnections enqueue {}: Dequeuing", connection.userId());
						// Always dequeue the user first, silently succeeds regardless if they're currently enqueued.
						dequeue(new UserId(connection.userId()));
						LOGGER.trace("handleConnections enqueue {}: Enqueuing", connection.userId());
						enqueue(new MatchmakingRequest()
								.withUserId(connection.userId())
								.setQueueId(method.getEnqueue().getQueueId())
								.withDeckId(method.getEnqueue().getDeckId())
								.withBotDeckId(method.getEnqueue().getBotDeckId()));
						LOGGER.trace("handleConnections enqueue {}: Enqueued", connection.userId());
					}

					if (method.getDequeue() != null) {
						dequeue(new UserId(connection.userId()));

						connection.write(new Envelope()
								.result(new EnvelopeResult()
										.dequeue(new DefaultMethodResponse())));
					}
				}
			}));
		});
	}
}
