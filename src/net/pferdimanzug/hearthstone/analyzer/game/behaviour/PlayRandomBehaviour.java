package net.pferdimanzug.hearthstone.analyzer.game.behaviour;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.actions.GameAction;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Actor;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.EntityReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayRandomBehaviour implements IBehaviour {

	private final static Logger logger = LoggerFactory.getLogger(PlayRandomBehaviour.class);

	@Override
	public Actor provideTargetFor(Player player, GameAction action) {
		List<Actor> validTargets = action.getValidTargets();
		if (validTargets.isEmpty()) {
			return null;
		}

		Actor randomTarget = validTargets.get(ThreadLocalRandom.current().nextInt(validTargets.size()));
		if (randomTarget != null) {
			logger.debug(player.getName() + " picks random target: " + randomTarget.getName());
		}
		
		return randomTarget;
	}

	@Override
	public GameAction requestAction(GameContext context, Player player, List<GameAction> validActions) {
		if (validActions.isEmpty()) {
			return null;
		}

		int randomIndex = ThreadLocalRandom.current().nextInt(validActions.size());
		GameAction randomAction = validActions.get(randomIndex);
		selectRandomTarget(randomAction);
		return randomAction;
	}
	
	private void selectRandomTarget(GameAction action) {
		List<Actor> validTargets = action.getValidTargets();
		if (validTargets == null || validTargets.isEmpty()) {
			return;
		}
		
		int randomIndex = ThreadLocalRandom.current().nextInt(validTargets.size());
		Entity randomTarget = validTargets.get(randomIndex);
		action.setTargetKey(EntityReference.pointTo(randomTarget));
	}

}
