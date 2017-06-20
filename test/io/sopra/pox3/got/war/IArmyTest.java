package io.sopra.pox3.got.war;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.story.HouseFactory;
import io.sopra.pox3.got.tile.Domain;
import io.sopra.pox3.got.tile.World;

public class IArmyTest {

	IArmy army, bigArmy;
	HouseFactory factory;
	House stark, lannister;
	World world;
	Domain winterfell3, winterfell7;

	@Before
	public void setUp() throws Exception {
		factory = new HouseFactory();

		this.stark = factory.getStark();
		this.lannister = factory.getLannister();

		world = new World();
		world.generate();
		Domain winterfell3 = (Domain) world.get(3, 2);
		Domain winterfell7 = (Domain) world.get(3, 3);
		Domain winterfell4 = (Domain) world.get(4, 2);

		army = new Army(15, stark, winterfell3);
		bigArmy = new Army(10, lannister, winterfell4);
		
	}

	@Test
	public void testGetTroops() {

		assertEquals(3, army.getTotalTroops());
		assertEquals(3, army.getMovedTroops());
		assertEquals(3, army.getReadyTroops());
	}

	@Test
	public void testMoveIntDomain() {

		army.move(2, Direction.SOUTH);
		assertEquals(3, army.getPosition().getX());
		assertEquals(3, army.getPosition().getY());
		assertEquals(1, winterfell3.getArmy().getReadyTroops());
		assertEquals(1, winterfell3.getArmy().getMovedTroops());

	}

	@Test
	public void testMoveDomain() {
		army.move(Direction.SOUTH);
		assertEquals(3, army.getPosition().getX());
		assertEquals(3, army.getPosition().getY());
		assertEquals(0, winterfell3.getArmy().getReadyTroops());

		assertEquals(3, winterfell7.getArmy().getMovedTroops());

	}

	@Test
	public void testGetPosition() {
		assertEquals(winterfell3, army.getPosition());
	}

	@Test
	public void testGetHouse() {
		assertEquals(stark, army.getHouse());
	}

	@Test
	public void testGetState() {
		assertEquals(ArmyState.IDLE, army.getState());
		army.move(Direction.SOUTH);
		assertEquals(ArmyState.IDLE, army.getState());

	}

	@Test
	public void testAttack() {
		assertEquals(true, army.attack(bigArmy));
		assertEquals(ArmyState.WON, army.getState());

		
		
	}

}
