package net.pferdimanzug.hearthstone.analyzer.game.decks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;

public class MetaDeck extends Deck {

	private final List<Deck> decks;

	public MetaDeck() {
		this(new ArrayList<Deck>());
	}

	public MetaDeck(List<Deck> decks) {
		super(HeroClass.DECK_COLLECTION);
		this.decks = decks;
	}

	public Deck selectRandom() {
		return getDecks().get(ThreadLocalRandom.current().nextInt(getDecks().size()));
	}

	public List<Deck> getDecks() {
		return decks;
	}

	public boolean isComplete() {
		return decks.size() > 1;
	}

}
