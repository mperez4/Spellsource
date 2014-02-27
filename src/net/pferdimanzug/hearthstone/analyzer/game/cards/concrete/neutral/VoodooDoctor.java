package net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.neutral;

import net.pferdimanzug.hearthstone.analyzer.game.actions.Battlecry;
import net.pferdimanzug.hearthstone.analyzer.game.cards.MinionCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Minion;
import net.pferdimanzug.hearthstone.analyzer.game.spells.HealingSpell;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.TargetSelection;

public class VoodooDoctor extends MinionCard {

	public VoodooDoctor() {
		super("Voodoo Doctor", 2, 1, Rarity.FREE, HeroClass.ANY, 1);
		setDescription("Battlecry: Restore 2 Health.");
	}

	@Override
	public Minion summon() {
		Minion voodooDoctor = createMinion();
		Battlecry battlecry = Battlecry.createBattlecry(new HealingSpell(2), TargetSelection.ANY);
		voodooDoctor.setBattlecry(battlecry);
		return voodooDoctor;
	}

}
