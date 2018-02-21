package net.demilich.metastone.game.spells.custom;

import co.paralleluniverse.fibers.Suspendable;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.cards.Card;
import net.demilich.metastone.game.cards.CardType;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.spells.Spell;
import net.demilich.metastone.game.spells.SpellUtils;
import net.demilich.metastone.game.spells.desc.SpellDesc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class LastMinionCardInDeckSpell extends Spell {
	private static Logger logger = LoggerFactory.getLogger(LastMinionCardInDeckSpell.class);

	@Override
	@Suspendable
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity source, Entity target) {
		// Note the top of the deck is the last element in the deck List, therefore the "last minion in the deck" is
		// the first minion we find in the deck array.
		Optional<Card> card = player.getDeck().stream().filter(c -> c.getCardType() == CardType.MINION).findFirst();
		if (!card.isPresent()) {
			logger.debug("onCast {} {}: No minion found for this effect.", context.getGameId(), source);
			return;
		}

		desc.subSpells(0).forEach(subSpell -> {
			SpellUtils.castChildSpell(context, player, subSpell, source, target, card.get());
		});
	}
}
