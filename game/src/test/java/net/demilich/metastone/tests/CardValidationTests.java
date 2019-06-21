package net.demilich.metastone.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.vertx.core.json.DecodeException;
import io.vertx.core.json.Json;
import net.demilich.metastone.game.cards.CardCatalogueRecord;
import net.demilich.metastone.game.cards.CardParser;
import net.demilich.metastone.game.cards.desc.CardDesc;
import net.demilich.metastone.game.targeting.EntityReference;
import com.hiddenswitch.spellsource.ResourceInputStream;
import net.demilich.metastone.game.cards.Attribute;
import net.demilich.metastone.game.cards.AttributeMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

/**
 * This test will iterate through all the cards in the cards resources dir and invoke the CardParser.parseCard(cardFile)
 * method to ensure that each card is well formed and can be parsed.
 */
public class CardValidationTests {
	private static final String CARDS_DIR = "src/main/resources/cards/"; // relative path from module root
	private static final CardParser CARD_PARSER = new CardParser();
	private static List<File> ALL_CARD_FILES;

	@DataProvider(name = "CardProvider")
	public static Object[][] getCardFiles() {
		if (ALL_CARD_FILES == null) {
			try {
				ALL_CARD_FILES = (List<File>) FileUtils.listFiles(
						new File(CARDS_DIR),
						new RegexFileFilter("^(.*json)"),
						DirectoryFileFilter.DIRECTORY);
			} catch (IllegalArgumentException ignored) {
				ALL_CARD_FILES = (List<File>) FileUtils.listFiles(
						new File("../cards/" + CARDS_DIR),
						new RegexFileFilter("^(.*json)"),
						DirectoryFileFilter.DIRECTORY);
			}

		}

		int size = ALL_CARD_FILES.size();
		File file;
		Object[][] matrix = (Object[][]) Array.newInstance(Object.class, size, 1);
		for (int i = 0; i < size; i++) {
			file = ALL_CARD_FILES.get(i);
			matrix[i][0] = file;
		}

		return matrix;
	}

	@Test(dataProvider = "CardProvider")
	public void validateCard(File cardFile) throws IOException {
		ResourceInputStream resourceInputStream = new ResourceInputStream(cardFile.getName(), new FileInputStream(cardFile), true);

		try {
			CardCatalogueRecord record = CARD_PARSER.parseCard(resourceInputStream);
			Assert.assertFalse(record.getDesc().getHeroClass() == null && (record.getDesc().getHeroClasses() == null || record.getDesc().getHeroClasses().length == 0));
			String description = record.getDesc().getDescription();
			if (description != null) {
				AttributeMap attributes = record.getDesc().getAttributes();
				if (description.startsWith("Battlecry:")
						|| description.startsWith("Opener:")) {
					Assert.assertTrue(attributes != null && attributes.containsKey(Attribute.BATTLECRY),
							"An Opener card is missing the BATTLECRY attribute.");
				}

				if (description.startsWith("Deathrattle:")
						|| description.startsWith("Aftermath:")) {
					Assert.assertTrue(attributes != null && attributes.containsKey(Attribute.DEATHRATTLES),
							"An Aftermath card is missing the DEATHRATTLES attribute.");
				}

				if (record.getDesc().deathrattle != null) {
					Assert.assertNotEquals(record.getDesc().deathrattle.getTarget(), EntityReference.ADJACENT_MINIONS,
							"Deathrattles trigger from the graveyard, so they cannot contain a reference to ADJACENT_MINIONS. Use a custom.AdjacentDeathrattleSpell instead.");
				}
			}
		} catch (DecodeException ex) {
			// Decode again to throw the inner exception
			try {
				CardDesc desc = Json.mapper.readValue(new FileInputStream(cardFile), CardDesc.class);
			} catch (JsonProcessingException innerEx) {
				Assert.fail(String.format("%s has a parse exception %s, Line: %d, Column: %d",
						cardFile.getName(),
						innerEx.getMessage(),
						innerEx.getLocation().getLineNr(),
						innerEx.getLocation().getColumnNr()), innerEx);
			}
		} catch (Exception ex) {
			Assert.fail(cardFile.getName(), ex);
		}
	}
}
