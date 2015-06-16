package net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin;

import net.demilich.metastone.game.cards.CardCatalogue;
import net.demilich.metastone.game.cards.MinionCard;
import net.demilich.metastone.game.cards.Rarity;
import net.demilich.metastone.game.cards.SpellCard;
import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.spells.EquipWeaponSpell;
import net.demilich.metastone.game.spells.MetaSpell;
import net.demilich.metastone.game.spells.SummonSpell;
import net.demilich.metastone.game.spells.desc.SpellDesc;
import net.demilich.metastone.game.targeting.EntityReference;
import net.demilich.metastone.game.targeting.TargetSelection;

public class MusterForBattle extends SpellCard {

	public MusterForBattle() {
		super("Muster for Battle", Rarity.RARE, HeroClass.PALADIN, 3);
		setDescription("Summon three 1/1 Silver Hand Recruits. Equip a 1/4 Weapon.");
		
		SpellDesc summonSpell = SummonSpell.create((MinionCard)CardCatalogue.getCardByName("token_silver_hand_recruit"));
		SpellDesc equipWeaponSpell = EquipWeaponSpell.create("weapon_lights_justice");
		setSpell(MetaSpell.create(EntityReference.NONE, summonSpell, equipWeaponSpell));
		setTargetRequirement(TargetSelection.NONE);
	}

	@Override
	public int getTypeId() {
		return 554;
	}
}
