package net.demilich.metastone.game.spells;

import co.paralleluniverse.fibers.Suspendable;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.spells.desc.SpellArg;
import net.demilich.metastone.game.spells.desc.SpellDesc;
import net.demilich.metastone.game.spells.desc.condition.Condition;

/**
 * Casts {@link SpellArg#SPELL1}. Evaluates the {@link SpellArg#CONDITION}: if it is fulfilled, casts {@link
 * SpellArg#SPELL2}. When {@link SpellArg#EXCLUSIVE} is {@code true}, behaves like an {@link EitherOrSpell}.
 * <p>
 * For example, "Deal 3 damage. If the target dies, draw a card.":
 * <pre>
 *   "spell": {
 *     "class": "ConditionalEffectSpell",
 *     "condition": {
 *       "class": "IsDeadCondition"
 *     },
 *     "spell1": {
 *       "class": "DamageSpell",
 *       "value": 3
 *     },
 *     "spell2": {
 *       "class": "DrawCardSpell"
 *     }
 *   }
 * </pre>
 *
 * @see EitherOrSpell for a spell that does one thing when true or another when false (i.e., this spell with {@link
 * SpellArg#EXCLUSIVE} set to true.
 * @see ConditionalSpell for a spell that executes its subspell only if its condition is met.
 */
public class ConditionalEffectSpell extends Spell {

	protected boolean isConditionFulfilled(GameContext context, Player player, SpellDesc desc, Entity source, Entity target) {
		Condition condition = (Condition) desc.get(SpellArg.CONDITION);
		return condition.isFulfilled(context, player, source, target);
	}

	@Override
	@Suspendable
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity source, Entity target) {
		boolean exclusive = desc.getBool(SpellArg.EXCLUSIVE);
		SpellDesc primarySpell = (SpellDesc) desc.get(SpellArg.SPELL1);
		SpellDesc secondarySpell = (SpellDesc) desc.get(SpellArg.SPELL2);

		if (exclusive) {
			SpellUtils.castChildSpell(context, player, isConditionFulfilled(context, player, desc, source, target) ? secondarySpell : primarySpell,
					source, target);
		} else {
			SpellUtils.castChildSpell(context, player, primarySpell, source, target);
			if (isConditionFulfilled(context, player, desc, source, target)) {
				SpellUtils.castChildSpell(context, player, secondarySpell, source, target);
			}
		}

	}

}
