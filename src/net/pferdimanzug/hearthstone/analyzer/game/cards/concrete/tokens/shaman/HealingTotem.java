package net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.tokens.shaman;

import net.pferdimanzug.hearthstone.analyzer.game.GameTag;
import net.pferdimanzug.hearthstone.analyzer.game.cards.MinionCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.cards.UniqueEntity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Minion;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Race;
import net.pferdimanzug.hearthstone.analyzer.game.spells.HealingSpell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.desc.SpellDesc;
import net.pferdimanzug.hearthstone.analyzer.game.spells.trigger.SpellTrigger;
import net.pferdimanzug.hearthstone.analyzer.game.spells.trigger.TurnEndTrigger;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.EntityReference;

public class HealingTotem extends MinionCard {

	public HealingTotem() {
		super("Healing Totem", 0, 2, Rarity.FREE, HeroClass.SHAMAN, 1);
		setDescription("At the end of your turn, restore 1 Health to all friendly minions.");
		setRace(Race.TOTEM);

		setCollectible(false);
	}

	@Override
	public int getTypeId() {
		return 457;
	}

	@Override
	public Minion summon() {
		Minion healingTotem = createMinion();
		healingTotem.setTag(GameTag.UNIQUE_ENTITY, UniqueEntity.HEALING_TOTEM);
		SpellDesc healSpell = HealingSpell.create(1);
		healSpell.setTarget(EntityReference.FRIENDLY_MINIONS);
		SpellTrigger trigger = new SpellTrigger(new TurnEndTrigger(), healSpell);
		healingTotem.setSpellTrigger(trigger);
		return healingTotem;
	}
}
