/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.spellsource.tables.pojos;


import com.hiddenswitch.framework.schema.spellsource.tables.interfaces.IMatchmakingQueues;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.time.OffsetDateTime;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MatchmakingQueues implements VertxPojo, IMatchmakingQueues {

    private static final long serialVersionUID = 1L;

    private String         id;
    private String         name;
    private Boolean        botOpponent;
    private Boolean        privateLobby;
    private Boolean        startsAutomatically;
    private Long           stillConnectedTimeout;
    private Long           emptyLobbyTimeout;
    private Long           awaitingLobbyTimeout;
    private Boolean        once;
    private Boolean        automaticallyClose;
    private Integer        lobbySize;
    private OffsetDateTime queueCreatedAt;

    public MatchmakingQueues() {}

    public MatchmakingQueues(IMatchmakingQueues value) {
        this.id = value.getId();
        this.name = value.getName();
        this.botOpponent = value.getBotOpponent();
        this.privateLobby = value.getPrivateLobby();
        this.startsAutomatically = value.getStartsAutomatically();
        this.stillConnectedTimeout = value.getStillConnectedTimeout();
        this.emptyLobbyTimeout = value.getEmptyLobbyTimeout();
        this.awaitingLobbyTimeout = value.getAwaitingLobbyTimeout();
        this.once = value.getOnce();
        this.automaticallyClose = value.getAutomaticallyClose();
        this.lobbySize = value.getLobbySize();
        this.queueCreatedAt = value.getQueueCreatedAt();
    }

    public MatchmakingQueues(
        String         id,
        String         name,
        Boolean        botOpponent,
        Boolean        privateLobby,
        Boolean        startsAutomatically,
        Long           stillConnectedTimeout,
        Long           emptyLobbyTimeout,
        Long           awaitingLobbyTimeout,
        Boolean        once,
        Boolean        automaticallyClose,
        Integer        lobbySize,
        OffsetDateTime queueCreatedAt
    ) {
        this.id = id;
        this.name = name;
        this.botOpponent = botOpponent;
        this.privateLobby = privateLobby;
        this.startsAutomatically = startsAutomatically;
        this.stillConnectedTimeout = stillConnectedTimeout;
        this.emptyLobbyTimeout = emptyLobbyTimeout;
        this.awaitingLobbyTimeout = awaitingLobbyTimeout;
        this.once = once;
        this.automaticallyClose = automaticallyClose;
        this.lobbySize = lobbySize;
        this.queueCreatedAt = queueCreatedAt;
    }

        public MatchmakingQueues(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>spellsource.matchmaking_queues.id</code>.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Setter for <code>spellsource.matchmaking_queues.id</code>.
     */
    @Override
    public MatchmakingQueues setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>spellsource.matchmaking_queues.name</code>.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>spellsource.matchmaking_queues.name</code>.
     */
    @Override
    public MatchmakingQueues setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>spellsource.matchmaking_queues.bot_opponent</code>.
     */
    @Override
    public Boolean getBotOpponent() {
        return this.botOpponent;
    }

    /**
     * Setter for <code>spellsource.matchmaking_queues.bot_opponent</code>.
     */
    @Override
    public MatchmakingQueues setBotOpponent(Boolean botOpponent) {
        this.botOpponent = botOpponent;
        return this;
    }

    /**
     * Getter for <code>spellsource.matchmaking_queues.private_lobby</code>.
     */
    @Override
    public Boolean getPrivateLobby() {
        return this.privateLobby;
    }

    /**
     * Setter for <code>spellsource.matchmaking_queues.private_lobby</code>.
     */
    @Override
    public MatchmakingQueues setPrivateLobby(Boolean privateLobby) {
        this.privateLobby = privateLobby;
        return this;
    }

    /**
     * Getter for
     * <code>spellsource.matchmaking_queues.starts_automatically</code>.
     */
    @Override
    public Boolean getStartsAutomatically() {
        return this.startsAutomatically;
    }

    /**
     * Setter for
     * <code>spellsource.matchmaking_queues.starts_automatically</code>.
     */
    @Override
    public MatchmakingQueues setStartsAutomatically(Boolean startsAutomatically) {
        this.startsAutomatically = startsAutomatically;
        return this;
    }

    /**
     * Getter for
     * <code>spellsource.matchmaking_queues.still_connected_timeout</code>.
     */
    @Override
    public Long getStillConnectedTimeout() {
        return this.stillConnectedTimeout;
    }

    /**
     * Setter for
     * <code>spellsource.matchmaking_queues.still_connected_timeout</code>.
     */
    @Override
    public MatchmakingQueues setStillConnectedTimeout(Long stillConnectedTimeout) {
        this.stillConnectedTimeout = stillConnectedTimeout;
        return this;
    }

    /**
     * Getter for
     * <code>spellsource.matchmaking_queues.empty_lobby_timeout</code>.
     */
    @Override
    public Long getEmptyLobbyTimeout() {
        return this.emptyLobbyTimeout;
    }

    /**
     * Setter for
     * <code>spellsource.matchmaking_queues.empty_lobby_timeout</code>.
     */
    @Override
    public MatchmakingQueues setEmptyLobbyTimeout(Long emptyLobbyTimeout) {
        this.emptyLobbyTimeout = emptyLobbyTimeout;
        return this;
    }

    /**
     * Getter for
     * <code>spellsource.matchmaking_queues.awaiting_lobby_timeout</code>.
     */
    @Override
    public Long getAwaitingLobbyTimeout() {
        return this.awaitingLobbyTimeout;
    }

    /**
     * Setter for
     * <code>spellsource.matchmaking_queues.awaiting_lobby_timeout</code>.
     */
    @Override
    public MatchmakingQueues setAwaitingLobbyTimeout(Long awaitingLobbyTimeout) {
        this.awaitingLobbyTimeout = awaitingLobbyTimeout;
        return this;
    }

    /**
     * Getter for <code>spellsource.matchmaking_queues.once</code>.
     */
    @Override
    public Boolean getOnce() {
        return this.once;
    }

    /**
     * Setter for <code>spellsource.matchmaking_queues.once</code>.
     */
    @Override
    public MatchmakingQueues setOnce(Boolean once) {
        this.once = once;
        return this;
    }

    /**
     * Getter for
     * <code>spellsource.matchmaking_queues.automatically_close</code>.
     */
    @Override
    public Boolean getAutomaticallyClose() {
        return this.automaticallyClose;
    }

    /**
     * Setter for
     * <code>spellsource.matchmaking_queues.automatically_close</code>.
     */
    @Override
    public MatchmakingQueues setAutomaticallyClose(Boolean automaticallyClose) {
        this.automaticallyClose = automaticallyClose;
        return this;
    }

    /**
     * Getter for <code>spellsource.matchmaking_queues.lobby_size</code>.
     */
    @Override
    public Integer getLobbySize() {
        return this.lobbySize;
    }

    /**
     * Setter for <code>spellsource.matchmaking_queues.lobby_size</code>.
     */
    @Override
    public MatchmakingQueues setLobbySize(Integer lobbySize) {
        this.lobbySize = lobbySize;
        return this;
    }

    /**
     * Getter for <code>spellsource.matchmaking_queues.queue_created_at</code>.
     */
    @Override
    public OffsetDateTime getQueueCreatedAt() {
        return this.queueCreatedAt;
    }

    /**
     * Setter for <code>spellsource.matchmaking_queues.queue_created_at</code>.
     */
    @Override
    public MatchmakingQueues setQueueCreatedAt(OffsetDateTime queueCreatedAt) {
        this.queueCreatedAt = queueCreatedAt;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MatchmakingQueues (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(botOpponent);
        sb.append(", ").append(privateLobby);
        sb.append(", ").append(startsAutomatically);
        sb.append(", ").append(stillConnectedTimeout);
        sb.append(", ").append(emptyLobbyTimeout);
        sb.append(", ").append(awaitingLobbyTimeout);
        sb.append(", ").append(once);
        sb.append(", ").append(automaticallyClose);
        sb.append(", ").append(lobbySize);
        sb.append(", ").append(queueCreatedAt);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IMatchmakingQueues from) {
        setId(from.getId());
        setName(from.getName());
        setBotOpponent(from.getBotOpponent());
        setPrivateLobby(from.getPrivateLobby());
        setStartsAutomatically(from.getStartsAutomatically());
        setStillConnectedTimeout(from.getStillConnectedTimeout());
        setEmptyLobbyTimeout(from.getEmptyLobbyTimeout());
        setAwaitingLobbyTimeout(from.getAwaitingLobbyTimeout());
        setOnce(from.getOnce());
        setAutomaticallyClose(from.getAutomaticallyClose());
        setLobbySize(from.getLobbySize());
        setQueueCreatedAt(from.getQueueCreatedAt());
    }

    @Override
    public <E extends IMatchmakingQueues> E into(E into) {
        into.from(this);
        return into;
    }
}
