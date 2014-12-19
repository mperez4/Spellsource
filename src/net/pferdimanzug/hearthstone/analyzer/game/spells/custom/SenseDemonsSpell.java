package net.pferdimanzug.hearthstone.analyzer.game.spells.custom;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.GameTag;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Card;
import net.pferdimanzug.hearthstone.analyzer.game.cards.CardCollection;
import net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.tokens.warlock.WorthlessImp;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Race;
import net.pferdimanzug.hearthstone.analyzer.game.spells.Spell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.SpellUtils;
import net.pferdimanzug.hearthstone.analyzer.game.spells.desc.SpellDesc;

public class SenseDemonsSpell extends Spell {
	
	public static SpellDesc create() {
		SpellDesc desc = new SpellDesc(SenseDemonsSpell.class);
		return desc;
	}

	@Override
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity target) {
		CardCollection demonCards = SpellUtils.getCards(player.getDeck(), card -> card.getTag(GameTag.RACE) == Race.DEMON);
		for (int i = 0; i < 2; i++) {
			Card demonCard = null;
			if (demonCards.isEmpty()) {
				demonCard = new WorthlessImp();

			} else {
				demonCard = demonCards.getRandom();
				demonCards.remove(demonCard);
				player.getDeck().remove(demonCard);
			}
			context.getLogic().receiveCard(player.getId(), demonCard);
		}
	}
}