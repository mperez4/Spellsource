package net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.neutral;

import net.pferdimanzug.hearthstone.analyzer.game.cards.MinionCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Minion;

public class MagmaRager extends MinionCard {

	public MagmaRager() {
		super("Magma Rager", 5, 1, Rarity.FREE, HeroClass.ANY, 3);
	}

	@Override
	public int getTypeId() {
		return 160;
	}



	@Override
	public Minion summon() {
		return createMinion();
	}
}
