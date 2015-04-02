package net.demilich.metastone.game.cards.concrete.neutral;

import net.demilich.metastone.game.GameTag;
import net.demilich.metastone.game.cards.MinionCard;
import net.demilich.metastone.game.cards.Rarity;
import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.entities.minions.Minion;

public class OgreMagi extends MinionCard {

	public OgreMagi() {
		super("Ogre Magi", 4, 4, Rarity.FREE, HeroClass.ANY, 4);
		setDescription("Spell Damage +1");
	}

	@Override
	public int getTypeId() {
		return 179;
	}



	@Override
	public Minion summon() {
		Minion ogreMagi = createMinion();
		ogreMagi.setTag(GameTag.SPELL_DAMAGE, 1);
		return ogreMagi;
	}
}
