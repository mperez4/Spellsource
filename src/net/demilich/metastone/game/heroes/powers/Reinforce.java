package net.demilich.metastone.game.heroes.powers;

import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.spells.SummonSpell;
import net.demilich.metastone.game.targeting.TargetSelection;

public class Reinforce extends HeroPower {

	public Reinforce() {
		super("Reinforce", HeroClass.PALADIN);
		setTargetRequirement(TargetSelection.NONE);
		setSpell(SummonSpell.create("token_silver_hand_recruit"));
	}

}
