/*
 * This file is generated by jOOQ.
 */
package com.hiddenswitch.framework.schema.spellsource.tables.pojos;


import com.hiddenswitch.framework.schema.spellsource.tables.interfaces.IDeckShares;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


/**
 * indicates a deck shared to a player
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeckShares implements VertxPojo, IDeckShares {

    private static final long serialVersionUID = 1338556433;

    private String  deckId;
    private String  shareRecipientId;
    private Boolean trashedByRecipient;

    public DeckShares() {}

    public DeckShares(IDeckShares value) {
        this.deckId = value.getDeckId();
        this.shareRecipientId = value.getShareRecipientId();
        this.trashedByRecipient = value.getTrashedByRecipient();
    }

    public DeckShares(
        String  deckId,
        String  shareRecipientId,
        Boolean trashedByRecipient
    ) {
        this.deckId = deckId;
        this.shareRecipientId = shareRecipientId;
        this.trashedByRecipient = trashedByRecipient;
    }

    public DeckShares(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public String getDeckId() {
        return this.deckId;
    }

    @Override
    public DeckShares setDeckId(String deckId) {
        this.deckId = deckId;
        return this;
    }

    @Override
    public String getShareRecipientId() {
        return this.shareRecipientId;
    }

    @Override
    public DeckShares setShareRecipientId(String shareRecipientId) {
        this.shareRecipientId = shareRecipientId;
        return this;
    }

    @Override
    public Boolean getTrashedByRecipient() {
        return this.trashedByRecipient;
    }

    @Override
    public DeckShares setTrashedByRecipient(Boolean trashedByRecipient) {
        this.trashedByRecipient = trashedByRecipient;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DeckShares (");

        sb.append(deckId);
        sb.append(", ").append(shareRecipientId);
        sb.append(", ").append(trashedByRecipient);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IDeckShares from) {
        setDeckId(from.getDeckId());
        setShareRecipientId(from.getShareRecipientId());
        setTrashedByRecipient(from.getTrashedByRecipient());
    }

    @Override
    public <E extends IDeckShares> E into(E into) {
        into.from(this);
        return into;
    }
}
