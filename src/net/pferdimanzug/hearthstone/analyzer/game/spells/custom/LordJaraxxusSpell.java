package net.pferdimanzug.hearthstone.analyzer.game.spells.custom;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.cards.MinionCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.cards.WeaponCard;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Hero;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Minion;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Race;
import net.pferdimanzug.hearthstone.analyzer.game.entities.weapons.Weapon;
import net.pferdimanzug.hearthstone.analyzer.game.heroes.powers.HeroPower;
import net.pferdimanzug.hearthstone.analyzer.game.spells.DestroySpell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.EquipWeaponSpell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.SummonSpell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.desc.SpellDesc;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.TargetSelection;

public class LordJaraxxusSpell extends DestroySpell {
	
	public static SpellDesc create() {
		SpellDesc desc = new SpellDesc(LordJaraxxusSpell.class);
		return desc;
	}

	@Override
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity target) {
		context.getLogic().changeHero(player, new LordJaraxxusHero());
		SpellDesc equipWeaponSpell = EquipWeaponSpell.create(new BloodFury());
		context.getLogic().castSpell(player.getId(), equipWeaponSpell);
		super.onCast(context, player, desc, target);
	}
	
	private class BloodFury extends WeaponCard {

		public BloodFury() {
			super("Blood Fury", Rarity.COMMON, HeroClass.WARLOCK, 3);
			setCollectible(false);
		}

		@Override
		public Weapon getWeapon() {
			return createWeapon(3, 8);
		}

	}

	private class Infernal extends MinionCard {

		public Infernal() {
			super("Infernal", 6, 6, Rarity.COMMON, HeroClass.WARLOCK, 6);
			setRace(Race.DEMON);

			setCollectible(false);
		}

		@Override
		public Minion summon() {
			return createMinion();
		}

	}

	private class Inferno extends HeroPower {

		public Inferno() {
			super("INFERNO!", HeroClass.WARLOCK);
			setSpell(SummonSpell.create(new Infernal()));
			setTargetRequirement(TargetSelection.NONE);
		}

	}

	private class LordJaraxxusHero extends Hero {

		public LordJaraxxusHero() {
			super("Lord Jaraxxus", HeroClass.WARLOCK, new Inferno());
			setRace(Race.DEMON);
			
			setMaxHp(15);
			setHp(15);
		}

	}

}
