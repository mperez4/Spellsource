package net.demilich.metastone.game.cards.concrete.naxxramas;

import net.demilich.metastone.game.GameTag;
import net.demilich.metastone.game.cards.MinionCard;
import net.demilich.metastone.game.cards.Rarity;
import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.entities.minions.Minion;

public class Loatheb extends MinionCard {

	public Loatheb() {
		super("Loatheb", 5, 5, Rarity.LEGENDARY, HeroClass.ANY, 5);
		setDescription("Battlecry: Enemy spells cost (5) more next turn.");
		setTag(GameTag.BATTLECRY);
	}

	@Override
	public int getTypeId() {
		return 407;
	}

	@Override
	public Minion summon() {
		Minion loatheb = createMinion();
//		OneTurnManaModifier costModifier = new OneTurnManaModifier(CardType.SPELL, +5);
//		costModifier.setTargetPlayer(TargetPlayer.OPPONENT);
//		SpellDesc increaseSpellCost = AddManaModifierSpell.create(EntityReference.FRIENDLY_HERO, costModifier);
//		loatheb.setBattlecry(BattlecryAction.createBattlecry(increaseSpellCost));
		return loatheb;
	}
}
