package net.pferdimanzug.hearthstone.analyzer.gui.cards;

import javafx.fxml.FXML;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Card;
import net.pferdimanzug.hearthstone.analyzer.gui.IconFactory;

public class HandCard extends CardToken {
	
	@FXML
	private Pane topPane;
	@FXML
	private Pane centerPane;
	@FXML
	private Pane bottomPane;

	private CardTooltip tooltipContent;
	private Tooltip tooltip;

	public HandCard() {
		super("HandCard.fxml");
	}

	@Override
	public void setCard(GameContext context, Card card, Player player) {
		super.setCard(context, card, player);
		if (tooltipContent == null) {
			tooltip = new Tooltip();
			tooltipContent = new CardTooltip();
			tooltipContent.setCard(context, card, player);
			tooltip.setGraphic(tooltipContent);
			Tooltip.install(this, tooltip);
		} else {
			tooltipContent.setCard(context, card, player);
		}
		if (player.hideCards()) {
			hideAllElements(true);
			Tooltip.uninstall(this, tooltip);
			tooltipContent = null;
			tooltip = null;
		}
	}
	
	private void hideAllElements(boolean hide) {
		topPane.setVisible(!hide);
		centerPane.setVisible(!hide);
		bottomPane.setVisible(!hide);
		if (hide) {
			BackgroundSize size = new BackgroundSize(getWidth(), getHeight(), false, false, true, false);
			BackgroundImage image = new BackgroundImage(IconFactory.getDefaultCardBack(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size);
			Background background = new Background(image);
			setBackground(background);
		} else {
			setBackground(null);
		}
	}

}
