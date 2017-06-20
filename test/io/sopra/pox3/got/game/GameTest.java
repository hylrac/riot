package io.sopra.pox3.got.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.sopra.pox3.got.game.Game;
import io.sopra.pox3.got.game.Player;
import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.story.HouseFactory;

public class GameTest {

	Game game;
	Player anne;
	Player nicolas;
	House stark, lannister;

	@Before
	public void setUp() {
		System.out.println("reinitialize new game");
		game = new Game();
		
		HouseFactory factory = new HouseFactory();
		this.stark = factory.getStark();
		this.lannister = factory.getLannister();
		anne = new Player("Anne", lannister);
		nicolas = new Player("Nicolas", stark);
	}


	@Test
	public void testGetAvailableHouses() {
		assertEquals(8, game.getAvailableHouses().size());
		assertTrue(game.getAvailableHouses().size() == 8);

	}

	@Test
	public void testSavePlayers() {
		assertTrue(game.getAvailableHouses().size() == 8);
		anne.house = lannister;
		game.savePlayers(anne);
		System.out.println(anne.house);
		assertTrue(game.getAvailableHouses().size() == 7);

	}

}
