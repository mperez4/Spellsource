import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.cards.SecretCard;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.spells.DamageSpell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.desc.SpellDesc;
import net.pferdimanzug.hearthstone.analyzer.game.spells.trigger.HeroAttackedTrigger;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.EntityReference;


public class TestSecretCard extends SecretCard {

	public TestSecretCard() {
		this(1);
	}
	
	public TestSecretCard(int damage) {
		super("Trap", Rarity.FREE, HeroClass.ANY, 0);
		setDescription("Secret for unit testing. Deals $" + damage + " damage to all enemies");
		setCollectible(false);
		
		SpellDesc damageSpell = DamageSpell.create(damage);
		damageSpell.setTarget(EntityReference.ENEMY_CHARACTERS);
		setTriggerAndEffect(new HeroAttackedTrigger(), damageSpell);
	}

}
