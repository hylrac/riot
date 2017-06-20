package io.sopra.pox3.got.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.story.HouseFactory;
import io.sopra.pox3.got.tile.World;
import io.sopra.pox3.got.war.Army;
import io.sopra.pox3.got.war.Direction;
import io.sopra.pox3.got.war.IArmy;

public class RoundTest {

	World world;
	Round round;
	Game game;
	Player a, b;
	IArmy a1, a2, a3, b1;
	House stark, lannister;

	@Before
	public void setUp() throws Exception {
		world = new World();
		world.generate();
		game = new Game();

		HouseFactory factory = new HouseFactory();
		this.stark = factory.getStark();
		this.lannister = factory.getLannister();

		this.a = new Player("Anne", lannister);
		this.b = new Player("Nicolas", stark);

		a1 = new Army(2, stark, world.getWinterfell7());
		a2 = new Army(2, stark, world.getMereen3());
		a3 = new Army(4, stark, world.getThrone());
		b1 = new Army(2, lannister, world.getTheEyrie1());

		round = new Round();
	}

	@Test(expected = PlayerRoundEndedException.class)
	public void testEndPlayer() {
		a1.move(Direction.NORTH);
		round.end(a);
		a2.move(Direction.SOUTH);

	}

	@Test
	public void testEnd() {
		fail("Not yet implemented");
	}

}
