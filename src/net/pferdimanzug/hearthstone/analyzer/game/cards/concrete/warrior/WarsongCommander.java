package net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.warrior;

import net.pferdimanzug.hearthstone.analyzer.game.GameTag;
import net.pferdimanzug.hearthstone.analyzer.game.aura.Aura;
import net.pferdimanzug.hearthstone.analyzer.game.cards.MinionCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.EntityType;
import net.pferdimanzug.hearthstone.analyzer.game.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.minions.Minion;

public class WarsongCommander extends MinionCard {

	public WarsongCommander() {
		super("Warsong Commander", Rarity.FREE, HeroClass.WARRIOR, 3);
	}

	@Override
	public Minion summon() {
		Minion warsongCommander = createMinion(2, 3);
		warsongCommander.setAura(new WarsongCommanderAura(warsongCommander));
		return warsongCommander;
	}
	
	private class WarsongCommanderAura extends Aura {

		public WarsongCommanderAura(Entity source) {
			super(source);
		}

		@Override
		public boolean affects(Entity entity) {
			if (entity == getSource()) {
				return false;
			} else if (entity.getOwner() != getSource().getOwner()) {
				return false;
			}
			return entity.getEntityType() == EntityType.MINION;
		}

		@Override
		protected void onApply(Entity entity) {
			entity.setTag(GameTag.CHARGE);
		}

		@Override
		protected void onRemove(Entity entity) {
			entity.removeTag(GameTag.CHARGE);
			
		}
		
	}
	

}
