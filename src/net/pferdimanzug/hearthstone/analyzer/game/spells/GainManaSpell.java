package net.pferdimanzug.hearthstone.analyzer.game.spells;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GainManaSpell extends Spell {
	private static Logger logger = LoggerFactory.getLogger(GainManaSpell.class);

	private final int mana;

	public GainManaSpell(int mana) {
		this.mana = mana;
	}

	@Override
	protected void onCast(GameContext context, Player player, Actor target) {
		logger.debug("{} gains {} mana", player.getName(), mana);
		context.getLogic().modifyCurrentMana(player.getId(), mana);
	}

}
