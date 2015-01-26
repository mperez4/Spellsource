package net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral;

import net.demilich.metastone.game.actions.Battlecry;
import net.demilich.metastone.game.cards.MinionCard;
import net.demilich.metastone.game.cards.Rarity;
import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.entities.minions.Minion;
import net.demilich.metastone.game.spells.DamageRandomSpell;
import net.demilich.metastone.game.spells.desc.SpellDesc;
import net.demilich.metastone.game.targeting.EntityReference;
import net.demilich.metastone.game.targeting.TargetSelection;

public class MadderBomber extends MinionCard {

	public MadderBomber() {
		super("Madder Bomber", 5, 6, Rarity.RARE, HeroClass.ANY, 5);
		setDescription("Battlecry: Deal 6 damage randomly split between all other characters.");
	}

	@Override
	public int getTypeId() {
		return 529;
	}



	@Override
	public Minion summon() {
		Minion madderBomber = createMinion();
		SpellDesc spell = DamageRandomSpell.create(1, 6);
		spell.setTarget(EntityReference.ALL_CHARACTERS);
		Battlecry battlecry = Battlecry.createBattlecry(spell, TargetSelection.NONE);
		madderBomber.setBattlecry(battlecry);
		return madderBomber;
	}
}
