package net.pferdimanzug.hearthstone.analyzer.game.spells;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.GameTag;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.cards.MinionCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.UniqueEntity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.minions.Minion;
import net.pferdimanzug.hearthstone.analyzer.game.spells.desc.SpellArg;
import net.pferdimanzug.hearthstone.analyzer.game.spells.desc.SpellDesc;

public class IfXDiedSummonYSpell extends Spell {
	
	public static SpellDesc create(UniqueEntity x, MinionCard y) {
		SpellDesc desc = new SpellDesc(IfXDiedSummonYSpell.class);
		desc.set(SpellArg.UNIQUE_MINION, x);
		desc.set(SpellArg.CARD, y);
		return desc;
	}

	@Override
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity target) {
		UniqueEntity x = (UniqueEntity) desc.get(SpellArg.UNIQUE_MINION);
		MinionCard y = (MinionCard) desc.get(SpellArg.CARD);
		for (Minion deadMinion : player.getGraveyard()) {
			if (deadMinion.getTag(GameTag.UNIQUE_ENTITY) == x) {
				context.getLogic().summon(player.getId(), y.summon());
				break;
			}
		}
	}

}
