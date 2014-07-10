import java.util.List;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.GameTag;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.actions.GameAction;
import net.pferdimanzug.hearthstone.analyzer.game.actions.PhysicalAttackAction;
import net.pferdimanzug.hearthstone.analyzer.game.behaviour.IBehaviour;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Card;
import net.pferdimanzug.hearthstone.analyzer.game.cards.IChooseOneCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.MinionCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.SpellCard;
import net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.druid.Wrath;
import net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.neutral.AbusiveSergeant;
import net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.neutral.AmaniBerserker;
import net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.neutral.KoboldGeomancer;
import net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.priest.MindBlast;
import net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.priest.Thoughtsteal;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Actor;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Anduin;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Garrosh;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Jaina;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Malfurion;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Rexxar;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Thrall;
import net.pferdimanzug.hearthstone.analyzer.game.spells.SetHpSpell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.SilenceSpell;
import net.pferdimanzug.hearthstone.analyzer.game.spells.Spell;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.TargetSelection;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AdvancedMechanicTests extends BasicTests {
	
	@Test
	public void testAura() {
		GameContext context = createContext(new Jaina(), new Garrosh());
		Player player = context.getPlayer1();
		Player opponent = context.getPlayer2();
		
		TestMinionCard minionCard = new TestMinionCard(1, 1);
		minionCard.getMinion().setSpellTrigger(new TestAura());
		context.getLogic().receiveCard(player.getId(), minionCard);
		context.getLogic().performGameAction(player.getId(), minionCard.play());
		
		Actor minion1 = getSingleMinion(player.getMinions());
		Assert.assertEquals(minion1.getAttack(), 1);
		
		minionCard = new TestMinionCard(1, 1);
		minionCard.getMinion().setSpellTrigger(new TestAura());
		Actor minion2 = playMinionCard(context, player, minionCard);
		
		Assert.assertNotEquals(minion1, minion2);
		Assert.assertEquals(minion1.getAttack(), 2);
		Assert.assertEquals(minion2.getAttack(), 2);
		
		TestMinionCard minionCardOpponent = new TestMinionCard(3, 3);
		Actor enemyMinion = playMinionCard(context, opponent, minionCardOpponent);
		Assert.assertEquals(enemyMinion.getAttack(), 3);
		
		Assert.assertEquals(minion1.getAttack(), 2);
		Assert.assertEquals(minion2.getAttack(), 2);
		PhysicalAttackAction attackAction = new PhysicalAttackAction(enemyMinion.getReference());
		attackAction.setTarget(minion2);
		context.getLogic().performGameAction(opponent.getId(), attackAction);
		Assert.assertEquals(minion1.getAttack(), 1);
		
		minionCard = new TestMinionCard(1, 1);
		minion2 = playMinionCard(context, player, minionCard);
		Assert.assertEquals(minion1.getAttack(), 1);
		Assert.assertEquals(minion2.getAttack(), 2);
	}
	
	@Test
	public void testChooseOne() {
		GameContext context = createContext(new Malfurion(), new Garrosh());
		Player player = context.getPlayer1();
		Player opponent = context.getPlayer2();
		player.getHand().removeAll();
		
		TestMinionCard minionCard = new TestMinionCard(1, 4);
		context.getLogic().receiveCard(opponent.getId(), minionCard);
		context.getLogic().performGameAction(opponent.getId(), minionCard.play());
		
		player.getHero().getHeroPower().setUsed(true);
		Card wrath = new Wrath();
		IChooseOneCard wrathChooseOne = (IChooseOneCard) wrath;
		context.getLogic().receiveCard(player.getId(), wrath);
		player.setMana(wrath.getBaseManaCost());
		List<GameAction> validActions = context.getLogic().getValidActions(player.getId());
		Assert.assertEquals(validActions.size(), 2);
		Assert.assertEquals(player.getHand().getCount(), 1);
		
		GameAction playWrath = wrathChooseOne.playOption1();
		playWrath.setTarget(getSingleMinion(opponent.getMinions()));
		context.getLogic().performGameAction(player.getId(), playWrath);
		
		validActions = context.getLogic().getValidActions(player.getId());
		Assert.assertEquals(validActions.size(), 0);
		Assert.assertEquals(player.getHand().getCount(), 0);
	}
	
	@Test
	public void testCopyCards() {
		GameContext context = createContext(new Anduin(), new Garrosh());
		Player player = context.getPlayer1();
		Player opponent = context.getPlayer2();
		player.getHand().removeAll();
		
		int cardsInHand = player.getHand().getCount();
		int cardsInOpponentsDeck = opponent.getDeck().getCount();
		Card thoughtsteal = new Thoughtsteal();
		context.getLogic().receiveCard(player.getId(), thoughtsteal);
		context.getLogic().performGameAction(player.getId(), thoughtsteal.play());
		Assert.assertEquals(opponent.getDeck().getCount(), cardsInOpponentsDeck);
		Assert.assertEquals(player.getHand().getCount(), cardsInHand + 2);
	}
	
	@Test
	public void testDivineShield() {
		GameContext context = createContext(new Jaina(), new Garrosh());
		Player mage = context.getPlayer1();
		mage.setMana(10);
		Player warrior = context.getPlayer2();
		warrior.setMana(10);

		MinionCard minionCard1 = new TestMinionCard(2, 2, GameTag.DIVINE_SHIELD);
		context.getLogic().receiveCard(mage.getId(), minionCard1);
		context.getLogic().performGameAction(mage.getId(), minionCard1.play());
		
		MinionCard minionCard2 = new TestMinionCard(5, 5);
		context.getLogic().receiveCard(warrior.getId(), minionCard2);
		context.getLogic().performGameAction(warrior.getId(), minionCard2.play());
		
		Actor attacker = getSingleMinion(mage.getMinions());
		Actor defender = getSingleMinion(warrior.getMinions());
		
		GameAction attackAction = new PhysicalAttackAction(attacker.getReference());
		attackAction.setTarget(defender);
		
		context.getLogic().performGameAction(mage.getId(), attackAction);
		Assert.assertEquals(attacker.getHp(), attacker.getMaxHp());
		Assert.assertEquals(defender.getHp(), defender.getMaxHp() - attacker.getAttack());
		Assert.assertEquals(attacker.isDead(), false);
		
		context.getLogic().performGameAction(mage.getId(), attackAction);
		Assert.assertEquals(attacker.getHp(), attacker.getMaxHp() - defender.getAttack());
		Assert.assertEquals(defender.getHp(), defender.getMaxHp() - attacker.getAttack() * 2);
		Assert.assertEquals(attacker.isDead(), true);
	}
	
	@Test
	public void testEnrage() {
		GameContext context = createContext(new Jaina(), new Anduin());
		Player mage = context.getPlayer1();
		mage.setMana(10);
		Player priest = context.getPlayer2();
		priest.setMana(10);

		MinionCard amaniBerserkerCard = new AmaniBerserker();
		context.getLogic().receiveCard(priest.getId(), amaniBerserkerCard);
		context.getLogic().performGameAction(priest.getId(), amaniBerserkerCard.play());
		
		MinionCard monsterCard = new TestMinionCard(1, 10);
		context.getLogic().receiveCard(mage.getId(), monsterCard);
		context.getLogic().performGameAction(mage.getId(), monsterCard.play());
		
		Entity attacker = getSingleMinion(mage.getMinions());
		Actor defender = getSingleMinion(priest.getMinions());
		
		Assert.assertEquals(defender.getAttack(), AmaniBerserker.BASE_ATTACK);
		Assert.assertEquals(defender.hasTag(GameTag.ENRAGED), false);
		
		// attack once, should apply the enrage attack bonus
		GameAction attackAction = new PhysicalAttackAction(attacker.getReference());
		attackAction.setTarget(defender);
		context.getLogic().performGameAction(mage.getId(), attackAction);
		Assert.assertEquals(defender.getAttack(), AmaniBerserker.BASE_ATTACK + AmaniBerserker.ENRAGE_ATTACK_BONUS);
		Assert.assertEquals(defender.hasTag(GameTag.ENRAGED), true);
		// attack second time, enrage bonus should not increase
		context.getLogic().performGameAction(mage.getId(), attackAction);
		Assert.assertEquals(defender.getAttack(), AmaniBerserker.BASE_ATTACK + AmaniBerserker.ENRAGE_ATTACK_BONUS);
		
		// heal - enrage attack bonus should be gone
		GameAction healAction = priest.getHero().getHeroPower().play();
		healAction.setTarget(defender);
		context.getLogic().performGameAction(priest.getId(), healAction);
		Assert.assertEquals(defender.getAttack(), AmaniBerserker.BASE_ATTACK);
		Assert.assertEquals(defender.hasTag(GameTag.ENRAGED), false);
	}
	
	@Test
	public void testOverload() {
		GameContext context = createContext(new Thrall(), new Garrosh());
		Player player = context.getPlayer1();
		int playerId = player.getId();
		
		context.getLogic().startTurn(playerId);
		Assert.assertEquals(player.getMana(), 1);
		context.getLogic().endTurn(playerId);
		context.getLogic().startTurn(playerId);
		Assert.assertEquals(player.getMana(), 2);
		
		Card overloadCard = new TestMinionCard(1, 1);
		overloadCard.setTag(GameTag.OVERLOAD, 2);
		context.getLogic().receiveCard(playerId, overloadCard);
		context.getLogic().performGameAction(playerId, overloadCard.play());
		context.getLogic().endTurn(playerId);
		context.getLogic().startTurn(playerId);
		Assert.assertEquals(player.getMana(), 1);
		
		context.getLogic().endTurn(playerId);
		context.getLogic().startTurn(playerId);
		Assert.assertEquals(player.getMana(), 4);
	}
	
	@Test
	public void testSetHpPlusSilence() {
		GameContext context = createContext(new Rexxar(), new Garrosh());
		Player player = context.getPlayer1();
		Player opponent = context.getPlayer2();
		
		int baseHp = 5;
		// summon a minion and check the base hp
		playCard(context, opponent, new TestMinionCard(4, baseHp));
		Actor minion = getSingleMinion(opponent.getMinions());
		Assert.assertEquals(minion.getHp(), baseHp);

		int modifiedHp = 1;
		// cast a spell on the minion which modifies the hp
		Spell setHpSpell = new SetHpSpell(modifiedHp);
		SpellCard spellCard = new TestSpellCard(setHpSpell);
		spellCard.setTargetRequirement(TargetSelection.MINIONS);
		context.getLogic().receiveCard(player.getId(), spellCard);
		GameAction playSpellCard = spellCard.play();
		playSpellCard.setTarget(minion);
		context.getLogic().performGameAction(player.getId(), playSpellCard);
		Assert.assertEquals(minion.getHp(), modifiedHp);
		Assert.assertEquals(minion.getMaxHp(), modifiedHp);
		
		// silence the creature - hp should be back to original value
		Spell silenceSpell = new SilenceSpell();
		spellCard = new TestSpellCard(silenceSpell);
		spellCard.setTargetRequirement(TargetSelection.MINIONS);
		context.getLogic().receiveCard(player.getId(), spellCard);
		playSpellCard = spellCard.play();
		playSpellCard.setTarget(minion);
		context.getLogic().performGameAction(player.getId(), playSpellCard);
		Assert.assertEquals(minion.getHp(), baseHp);		
	}
	
	@Test
	public void testShorttermBuffs() {
		GameContext context = createContext(new Jaina(), new Garrosh());
		Player mage = context.getPlayer1();
		mage.setMana(10);
		Player warrior = context.getPlayer2();
		warrior.setMana(10);
		
		int baseAttack = 1;
		mage.setBehaviour(new IBehaviour() {
			
			@Override
			public Entity provideTargetFor(Player player, GameAction action) {
				return action.getValidTargets().get(0);
			}

			@Override
			public GameAction requestAction(GameContext context, Player player, List<GameAction> validActions) {
				return null;
			}
		});
		
		playCard(context, mage, new TestMinionCard(baseAttack, 1));
		Actor testSubject = getSingleMinion(mage.getMinions());
		Assert.assertEquals(testSubject.getAttack(), baseAttack);
		
		playCard(context, mage, new AbusiveSergeant());
		Assert.assertEquals(testSubject.getAttack(), baseAttack + AbusiveSergeant.ATTACK_BONUS);
		context.getLogic().endTurn(mage.getId());
		Assert.assertEquals(testSubject.getAttack(), baseAttack);
	}
	
	@Test
	public void testSpellpower() {
		GameContext context = createContext(new Anduin(), new Garrosh());
		Player priest = context.getPlayer1();
		priest.setMana(10);
		Player warrior = context.getPlayer2();
		warrior.setMana(10);
		
		Assert.assertEquals(warrior.getHero().getHp(), warrior.getHero().getMaxHp());
		SpellCard damageSpell = new MindBlast();
		context.getLogic().receiveCard(priest.getId(), damageSpell);
		
		context.getLogic().performGameAction(priest.getId(), damageSpell.play());
		Assert.assertEquals(warrior.getHero().getHp(), warrior.getHero().getMaxHp() - MindBlast.DAMAGE);
		
		MinionCard spellPowerMinionCard = new KoboldGeomancer();
		context.getLogic().receiveCard(priest.getId(), spellPowerMinionCard);
		context.getLogic().performGameAction(priest.getId(), spellPowerMinionCard.play());
		context.getLogic().receiveCard(priest.getId(), damageSpell);
		context.getLogic().performGameAction(priest.getId(), damageSpell.play());
		int spellPower = getSingleMinion(priest.getMinions()).getTagValue(GameTag.SPELL_POWER);
		Assert.assertEquals(warrior.getHero().getHp(), warrior.getHero().getMaxHp() - 2 * MindBlast.DAMAGE - spellPower);
	}
}
