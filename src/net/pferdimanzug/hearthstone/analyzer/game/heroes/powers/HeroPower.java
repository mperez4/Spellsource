package net.pferdimanzug.hearthstone.analyzer.game.heroes.powers;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.actions.ActionType;
import net.pferdimanzug.hearthstone.analyzer.game.actions.HeroPowerAction;
import net.pferdimanzug.hearthstone.analyzer.game.actions.PlayCardAction;
import net.pferdimanzug.hearthstone.analyzer.game.cards.CardType;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.cards.SpellCard;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;

public abstract class HeroPower extends SpellCard {

	private boolean used;

	public HeroPower(String name) {
		super(name, CardType.HERO_POWER, Rarity.FREE, HeroClass.ANY, 2);
	}

	public boolean hasBeenUsed() {
		return used;
	}

	@Override
	public PlayCardAction play() {
		return new HeroPowerAction(this) {
			{
				setTargetRequirement(getTargetRequirement());
				setEffectHint(getEffectHint());
				setActionType(ActionType.HERO_POWER);
			}

			@Override
			protected void play(GameContext context, Player player) {
				context.getLogic().castSpell(player, getSpell(), getTarget());
			}
		};
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
	

}
