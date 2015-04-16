package net.demilich.metastone.game.cards;

import net.demilich.metastone.game.GameTag;
import net.demilich.metastone.game.entities.heroes.HeroClass;

public class CardCatalogue {

	private final static CardCollection cards = new CardCollection();

	static {
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.AxeFlinger());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.BlackwingTechnician());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.DarkIronSkulker());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.DragonEgg());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.DragonkinSorcerer());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.GrimPatron());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.HungryDragon());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.LavaShock());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.RendBlackhand());
		cards.add(new net.demilich.metastone.game.cards.concrete.blackrockmountain.Whelp());
		cards.add(new net.demilich.metastone.game.cards.concrete.druid.AncientOfLore());
		cards.add(new net.demilich.metastone.game.cards.concrete.druid.AncientOfWar());
		cards.add(new net.demilich.metastone.game.cards.concrete.druid.Cenarius());
		cards.add(new net.demilich.metastone.game.cards.concrete.druid.DruidOfTheClaw());
		cards.add(new net.demilich.metastone.game.cards.concrete.druid.KeeperOfTheGrove());
		cards.add(new net.demilich.metastone.game.cards.concrete.druid.WildGrowth());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.druid.AnodizedRoboCub());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.druid.DruidOfTheFang());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.druid.GroveTender());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.druid.Malorne());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.druid.MechBearCat());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.druid.Recycle());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.druid.TreeOfLife());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.hunter.CallPet());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.hunter.CobraShot());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.hunter.FeignDeath());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.hunter.Gahzrilla());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.hunter.Glaivezooka());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.hunter.KingOfBeasts());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.hunter.MetaltoothLeaper());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.hunter.SteamwheedleSniper());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.mage.EchoOfMedivh());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.mage.Flamecannon());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.mage.FlameLeviathan());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.mage.GoblinBlastmage());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.mage.Snowchugger());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.mage.SootSpewer());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.mage.UnstablePortal());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.mage.WeeSpellstopper());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.AnnoyOTron());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.AntiqueHealbot());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.ArcaneNullifierX21());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Blingtron3000());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.BombLobber());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.BurlyRockjawTrogg());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.ClockworkGiant());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.ClockworkGnome());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Cogmaster());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.DrBoom());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.EnhanceOMechano());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.ExplosiveSheep());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.FelReaver());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.FlyingMachine());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.FoeReaper4000());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.ForceTankMax());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Gazlowe());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.GilblinStalker());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.GnomereganInfantry());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.GnomishExperimenter());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.GoblinSapper());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.HemetNesingwary());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Hobgoblin());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Illuminator());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Jeeves());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Junkbot());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.KezanMystic());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.LilExorcist());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.LostTallstrider());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.MadderBomber());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.MechanicalYeti());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Mechwarper());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.MekgineerThermaplugg());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.MicroMachine());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.MimironsHead());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.MiniMage());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.MogorTheOgre());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.OgreBrute());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.PilotedShredder());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.PilotedSkyGolem());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Puddlestomper());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Recombobulator());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.SaltyDog());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.ShipsCannon());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.SneedsOldShredder());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.SpiderTank());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.StonesplinterTrogg());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.TargetDummy());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.TinkertownTechnician());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.Toshley());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.neutral.TroggzorTheEarthinator());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin.BolvarFordragon());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin.CobaltGuardian());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin.Coghammer());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin.MusterForBattle());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin.Quartermaster());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin.ScarletPurifier());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin.SealOfLight());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.paladin.ShieldedMinibot());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.priest.Lightbomb());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.priest.LightOfTheNaaru());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.priest.Shadowbomber());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.priest.Shadowboxer());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.priest.Shrinkmeister());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.priest.UpgradedRepairBot());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.priest.VelensChosen());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.priest.Voljin());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.rogue.CogmastersWrench());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.rogue.GoblinAutoBarber());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.rogue.IronSensai());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.rogue.OgreNinja());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.rogue.OneEyedCheat());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.rogue.Sabotage());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.rogue.TinkersSharpswordOil());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.rogue.TradePrinceGallywix());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.shaman.AncestorsCall());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.shaman.Crackle());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.shaman.DunemaulShaman());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.shaman.Neptulon());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.shaman.Powermace());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.shaman.SiltfinSpiritwalker());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.shaman.VitalityTotem());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.shaman.WhirlingZapOmatic());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.spareparts.ArmorPlating());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.spareparts.EmergencyCoolant());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.spareparts.FinickyCloakfield());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.spareparts.ReversingSwitch());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.spareparts.RustyHorn());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.spareparts.TimeRewinder());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.spareparts.WhirlingBlades());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.tokens.BoomBot());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.tokens.BurrowingMine());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.tokens.Chicken());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.tokens.CobraForm());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.tokens.GallywixsCoin());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.tokens.V07TR0N());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warlock.AnimaGolem());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warlock.Darkbomb());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warlock.Demonheart());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warlock.FelCannon());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warlock.FloatingWatcher());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warlock.Implosion());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warlock.MalGanis());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warlock.MistressOfPain());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warrior.BouncingBlade());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warrior.Crush());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warrior.IronJuggernaut());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warrior.OgreWarmaul());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warrior.ScrewjankClunker());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warrior.Shieldmaiden());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warrior.SiegeEngine());
		cards.add(new net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.warrior.Warbot());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.BestialWrath());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.EaglehornBow());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.ExplosiveShot());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.ExplosiveTrap());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.FreezingTrap());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.GladiatorsLongbow());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.Houndmaster());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.KillCommand());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.Misdirection());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.MultiShot());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.ScavengingHyena());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.SnakeTrap());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.Snipe());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.StarvingBuzzard());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.TimberWolf());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.TundraRhino());
		cards.add(new net.demilich.metastone.game.cards.concrete.hunter.UnleashTheHounds());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.ArchmageAntonidas());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.ConeOfCold());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.Counterspell());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.EtherealArcanist());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.IceBarrier());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.IceBlock());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.IceLance());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.KirinTorMage());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.ManaWyrm());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.SorcerersApprentice());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.Spellbender());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.Vaporize());
		cards.add(new net.demilich.metastone.game.cards.concrete.mage.WaterElemental());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.AnubarAmbusher());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Avenge());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.BaronRivendare());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.DancingSwords());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.DarkCultist());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Deathlord());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.DeathsBite());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Duplicate());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.EchoingOoze());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Feugen());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.HauntedCreeper());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.KelThuzad());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Loatheb());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.MadScientist());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Maexxna());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.NerubarWeblord());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.NerubianEgg());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.PoisonSeeds());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Reincarnate());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.ShadeOfNaxxramas());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.SludgeBelcher());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.SpectralKnight());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Stalagg());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.StoneskinGargoyle());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.tokens.Nerubian());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.tokens.Slime());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.tokens.SpectralSpider());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.tokens.Thaddius());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Undertaker());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.UnstableGhoul());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Voidcaller());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.WailingSoul());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.Webspinner());
		cards.add(new net.demilich.metastone.game.cards.concrete.naxxramas.ZombieChow());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.AcolyteOfPain());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.AlarmOBot());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.AmaniBerserker());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.AngryChicken());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.BaronGeddon());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.BigGameHunter());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.BloodsailRaider());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.ColdlightSeer());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.CultMaster());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.Demolisher());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.DireWolfAlpha());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.Doomsayer());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.DreadCorsair());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.EmperorCobra());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.FlesheatingGhoul());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.GadgetzanAuctioneer());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.GelbinMekkatorque());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.GrimscaleOracle());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.Gruul());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.GurubashiBerserker());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.Hogger());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.HungryCrab());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.IllidanStormrage());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.ImpMaster());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.KnifeJuggler());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.Lightwarden());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.LorewalkerCho());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.ManaAddict());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.ManaWraith());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.MasterSwordsmith());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.MillhouseManastorm());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.MindControlTech());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.MoltenGiant());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.MountainGiant());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.MurlocTidecaller());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.MurlocWarleader());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.NatPagle());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.OldMurkEye());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.PintSizedSummoner());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.QuestingAdventurer());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.RagingWorgen());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.RagnarosTheFirelord());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.RaidLeader());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.SeaGiant());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.Secretkeeper());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.SouthseaCaptain());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.SouthseaDeckhand());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.SpitefulSmith());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.StampedingKodo());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.StormwindChampion());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.TaurenWarrior());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.TheBlackKnight());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.TinkmasterOverspark());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.VentureCoMercenary());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.VioletTeacher());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.WildPyromancer());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.YoungPriestess());
		cards.add(new net.demilich.metastone.game.cards.concrete.neutral.Ysera());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.BlessingOfWisdom());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.DivineFavor());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.EyeForAnEye());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.HolyWrath());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.LightsJustice());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.NobleSacrifice());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.Redemption());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.Repentance());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.SwordOfJustice());
		cards.add(new net.demilich.metastone.game.cards.concrete.paladin.TruesilverChampion());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.AuchenaiSoulpriest());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.CabalShadowPriest());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.Lightwell());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.NorthshireCleric());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.ProphetVelen());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.Shadowform());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.ShadowMadness());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.ShadowWordDeath());
		cards.add(new net.demilich.metastone.game.cards.concrete.priest.ShadowWordPain());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.AssassinsBlade());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.Backstab());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.Betrayal());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.BladeFlurry());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.Conceal());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.DefiasRingleader());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.Kidnapper());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.MasterOfDisguise());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.PatientAssassin());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.PerditionsBlade());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.Preparation());
		cards.add(new net.demilich.metastone.game.cards.concrete.rogue.SI7Agent());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.AncestralSpirit());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.Doomhammer());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.FarSight());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.FireElemental());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.FlametongueTotem());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.ForkedLightning());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.ManaTideTotem());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.RockbiterWeapon());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.StormforgedAxe());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.TotemicMight());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.UnboundElemental());
		cards.add(new net.demilich.metastone.game.cards.concrete.shaman.Windspeaker());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.druid.BearForm());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.druid.CatForm());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.druid.ForceOfNatureTreant());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.druid.Panther());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.druid.Treant());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.hunter.Leokk());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.Chicken());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.Devilsaur());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.Emboldener3000());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.EmeraldDrake());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.FlameOfAzzinoth());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.Gnoll());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.HomingChicken());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.Imp());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.LaughingSister());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.Murloc());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.Poultryizer());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.RepairBot());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.Squirrel());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.neutral.VioletApprentice());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.paladin.Defender());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.priest.ShadowOfNothing());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.rogue.DefiasBandit());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.shaman.Frog());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.shaman.HealingTotem());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.shaman.SearingTotem());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.shaman.SpiritWolf());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.shaman.StoneclawTotem());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.shaman.WrathOfAirTotem());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.spells.Dream());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.spells.ExcessManaCard());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.spells.Nightmare());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.spells.YseraAwakens());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.weapons.Ashbringer());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.weapons.BattleAxe());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.weapons.BloodFury());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.weapons.HeavyAxe());
		cards.add(new net.demilich.metastone.game.cards.concrete.tokens.weapons.WickedKnife());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.BaneOfDoom());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.BloodImp());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.Corruption());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.Demonfire());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.Doomguard());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.DreadInfernal());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.Felguard());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.FlameImp());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.LordJaraxxus());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.MortalCoil());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.PitLord());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.PowerOverwhelming());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.SacrificialPact());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.SenseDemons());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.Shadowflame());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.Succubus());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.SummoningPortal());
		cards.add(new net.demilich.metastone.game.cards.concrete.warlock.VoidTerror());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.ArathiWeaponsmith());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.ArcaniteReaper());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.Armorsmith());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.BattleRage());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.Brawl());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.Cleave());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.CommandingShout());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.CruelTaskmaster());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.Execute());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.FieryWarAxe());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.FrothingBerserker());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.Gorehowl());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.GrommashHellscream());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.MortalStrike());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.Rampage());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.ShieldBlock());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.Slam());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.Upgrade());
		cards.add(new net.demilich.metastone.game.cards.concrete.warrior.WarsongCommander());
	}
	
	public static void add(Card card) {
		cards.add(card);
	}

	public static CardCollection getAll() {
		CardCollection result = new CardCollection();
		for (Card card : cards) {
			result.add(card);
		}
		return result;
	}
	
	public static Card getCardById(int id) {
		for (Card card : cards) {
			if (card.getTypeId() == id) {
				return card.clone();
			}
		}

		return null;
	}

	public static Card getCardById(String id) {
		for (Card card : cards) {
			if (card.getCardId() != null && card.getCardId().equalsIgnoreCase(id)) {
				return card.clone();
			}
		}

		return null;
	}

	public static Card getCardByName(String name) {
		for (Card card : cards) {
			if (card.getName().equals(name)) {
				return card.clone();
			}
		}

		return null;
	}

	public static CardCollection query(CardType cardType) {
		return query(cardType, null, null);
	}

	public static CardCollection query(CardType cardType, Rarity rarity, HeroClass heroClass) {
		return query(cardType, rarity, heroClass, null);
	}

	public static CardCollection query(CardType cardType, Rarity rarity, HeroClass heroClass, GameTag tag) {
		CardCollection result = new CardCollection();
		for (Card card : cards) {
			if (!card.isCollectible()) {
				continue;
			}
			if (cardType != null && card.getCardType() != cardType) {
				continue;
			}
			if (rarity != null && card.getRarity() != rarity) {
				continue;
			}
			if (heroClass != null && card.getClassRestriction() != heroClass) {
				continue;
			}
			if (tag != null && !card.hasTag(tag)) {
				continue;
			}
			result.add(card.clone());
		}

		return result;
	}

	public static CardCollection query(GameTag tag) {
		return query(null, null, null, tag);
	}
}
