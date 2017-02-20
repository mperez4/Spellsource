package com.hiddenswitch.proto3.net.models;

import java.io.Serializable;

public class DeckDeleteRequest implements Serializable {
	private final String deckId;

	public DeckDeleteRequest(String deckId) {
		this.deckId = deckId;
	}

	public String getDeckId() {
		return deckId;
	}
}
