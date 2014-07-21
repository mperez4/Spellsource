package net.pferdimanzug.hearthstone.analyzer.gui.playmode.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import net.pferdimanzug.hearthstone.analyzer.game.behaviour.IBehaviour;
import net.pferdimanzug.hearthstone.analyzer.game.behaviour.MinMaxBehaviour;
import net.pferdimanzug.hearthstone.analyzer.game.behaviour.NoAggressionBehaviour;
import net.pferdimanzug.hearthstone.analyzer.game.behaviour.PlayRandomBehaviour;
import net.pferdimanzug.hearthstone.analyzer.game.decks.Deck;
import net.pferdimanzug.hearthstone.analyzer.game.decks.DeckFactory;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Anduin;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Garrosh;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Guldan;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Hero;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Jaina;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Rexxar;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Thrall;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Uther;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.Valeera;
import net.pferdimanzug.hearthstone.analyzer.gui.IconFactory;
import net.pferdimanzug.hearthstone.analyzer.gui.gameconfig.PlayerConfig;

public class PlayerConfigView extends VBox {

	@FXML
	private Label heroNameLabel;

	@FXML
	private ImageView heroIcon;

	@FXML
	private ChoiceBox<IBehaviour> behaviourBox;

	@FXML
	private ChoiceBox<Hero> heroBox;

	@FXML
	private ChoiceBox<Deck> deckBox;

	private final PlayerConfig playerConfig = new PlayerConfig();

	private List<Deck> decks = new ArrayList<Deck>();

	public PlayerConfigView() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlayerConfigView.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		heroBox.setConverter(new HeroStringConverter());
		deckBox.setConverter(new DeckStringConverter());
		behaviourBox.setConverter(new BehaviourStringConverter());
		setupHeroes();
		setupBehaviours();
	}

	public void setupHeroes() {
		ObservableList<Hero> heroList = FXCollections.observableArrayList();
		heroList.add(new Garrosh());
		heroList.add(new Jaina());
		heroList.add(new Rexxar());
		heroList.add(new Guldan());
		heroList.add(new Valeera());
		heroList.add(new Thrall());
		heroList.add(new Anduin());
		heroList.add(new Uther());

		heroBox.setItems(heroList);
		heroBox.valueProperty().addListener((ChangeListener<Hero>) (observableValue, oldHero, newHero) -> {
			selectHero(newHero);
		  });
	}

	public void setupBehaviours() {
		ObservableList<IBehaviour> behaviourList = FXCollections.observableArrayList();
		behaviourList.add(new PlayRandomBehaviour());
		behaviourList.add(new MinMaxBehaviour());
		behaviourList.add(new NoAggressionBehaviour());

		behaviourBox.setItems(behaviourList);
	}

	public void injectDecks(List<Deck> decks) {
		this.decks = decks;
		playerConfig.setHero(heroBox.itemsProperty().getValue().get(0));
		selectHero(playerConfig.getHero());
		filterDecks();
		playerConfig.setDeck(deckBox.itemsProperty().getValue().get(0));
		playerConfig.setBehaviour(behaviourBox.itemsProperty().getValue().get(0));
	}

	private void filterDecks() {
		HeroClass heroClass = playerConfig.getHero().getHeroClass();
		ObservableList<Deck> deckList = FXCollections.observableArrayList();

		Deck randomDeck = DeckFactory.getRandomDeck(heroClass);
		deckList.add(randomDeck);
		for (Deck deck : decks) {
			if (deck.getHeroClass() == heroClass || deck.getHeroClass() == HeroClass.ANY) {
				deckList.add(deck);
			}
		}
		deckBox.setItems(deckList);
	}

	private void selectHero(Hero hero) {
		Image heroPortrait = new Image(IconFactory.getHeroIconUrl(hero));
		heroIcon.setImage(heroPortrait);
		heroNameLabel.setText(hero.getName());
		heroBox.setValue(hero);
	}

	public PlayerConfig getPlayerConfig() {
		return playerConfig;
	}

	private class HeroStringConverter extends StringConverter<Hero> {

		@Override
		public Hero fromString(String arg0) {
			return null;
		}

		@Override
		public String toString(Hero hero) {
			return hero.getHeroClass().toString();
		}

	}

	private class DeckStringConverter extends StringConverter<Deck> {

		@Override
		public Deck fromString(String arg0) {
			return null;
		}

		@Override
		public String toString(Deck deck) {
			return deck.getName();
		}

	}

	private class BehaviourStringConverter extends StringConverter<IBehaviour> {

		@Override
		public IBehaviour fromString(String string) {
			return null;
		}

		@Override
		public String toString(IBehaviour behaviour) {
			return behaviour.getName();
		}

	}

}
