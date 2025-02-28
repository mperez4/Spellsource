/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.spellsource.tables.pojos;


import com.hiddenswitch.framework.schema.spellsource.enums.GameUserVictoryEnum;
import com.hiddenswitch.framework.schema.spellsource.tables.interfaces.IGameUsers;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GameUsers implements VertxPojo, IGameUsers {

    private static final long serialVersionUID = 1L;

    private Short               playerIndex;
    private Long                gameId;
    private String              userId;
    private String              deckId;
    private GameUserVictoryEnum victoryStatus;

    public GameUsers() {}

    public GameUsers(IGameUsers value) {
        this.playerIndex = value.getPlayerIndex();
        this.gameId = value.getGameId();
        this.userId = value.getUserId();
        this.deckId = value.getDeckId();
        this.victoryStatus = value.getVictoryStatus();
    }

    public GameUsers(
        Short               playerIndex,
        Long                gameId,
        String              userId,
        String              deckId,
        GameUserVictoryEnum victoryStatus
    ) {
        this.playerIndex = playerIndex;
        this.gameId = gameId;
        this.userId = userId;
        this.deckId = deckId;
        this.victoryStatus = victoryStatus;
    }

        public GameUsers(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>spellsource.game_users.player_index</code>.
     */
    @Override
    public Short getPlayerIndex() {
        return this.playerIndex;
    }

    /**
     * Setter for <code>spellsource.game_users.player_index</code>.
     */
    @Override
    public GameUsers setPlayerIndex(Short playerIndex) {
        this.playerIndex = playerIndex;
        return this;
    }

    /**
     * Getter for <code>spellsource.game_users.game_id</code>.
     */
    @Override
    public Long getGameId() {
        return this.gameId;
    }

    /**
     * Setter for <code>spellsource.game_users.game_id</code>.
     */
    @Override
    public GameUsers setGameId(Long gameId) {
        this.gameId = gameId;
        return this;
    }

    /**
     * Getter for <code>spellsource.game_users.user_id</code>.
     */
    @Override
    public String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>spellsource.game_users.user_id</code>.
     */
    @Override
    public GameUsers setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Getter for <code>spellsource.game_users.deck_id</code>.
     */
    @Override
    public String getDeckId() {
        return this.deckId;
    }

    /**
     * Setter for <code>spellsource.game_users.deck_id</code>.
     */
    @Override
    public GameUsers setDeckId(String deckId) {
        this.deckId = deckId;
        return this;
    }

    /**
     * Getter for <code>spellsource.game_users.victory_status</code>.
     */
    @Override
    public GameUserVictoryEnum getVictoryStatus() {
        return this.victoryStatus;
    }

    /**
     * Setter for <code>spellsource.game_users.victory_status</code>.
     */
    @Override
    public GameUsers setVictoryStatus(GameUserVictoryEnum victoryStatus) {
        this.victoryStatus = victoryStatus;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GameUsers (");

        sb.append(playerIndex);
        sb.append(", ").append(gameId);
        sb.append(", ").append(userId);
        sb.append(", ").append(deckId);
        sb.append(", ").append(victoryStatus);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IGameUsers from) {
        setPlayerIndex(from.getPlayerIndex());
        setGameId(from.getGameId());
        setUserId(from.getUserId());
        setDeckId(from.getDeckId());
        setVictoryStatus(from.getVictoryStatus());
    }

    @Override
    public <E extends IGameUsers> E into(E into) {
        into.from(this);
        return into;
    }
}
