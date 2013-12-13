package net.pferdimanzug.hearthstone.analyzer.game.spells.enrage;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.GameTag;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.spells.ISpell;

public class Enrage implements ISpell {
	
	private final int attackBonus;

	public Enrage(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	@Override
	public void cast(GameContext context, Player player, Entity target) {
		int attackModifier = target.hasTag(GameTag.ENRAGED) ? +attackBonus : -attackBonus;
		target.modifyTag(GameTag.ATTACK_BONUS, attackModifier);
	}

}
