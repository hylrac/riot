package io.sopra.pox3.got.tile;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.story.HouseFactory;

public class WorldTest {

	World map;

	@Before
	public void setUp() throws Exception {
		map = new World();
	}

	@Test
	public void testGenerate() {
		map.generate();
		assertTrue(map.tiles.length == 12);
		assertTrue(map.tiles[0].length == 11);
	}

	@Test
	public void testAssignFreeDomain() {
		map.assignFreeDomain(1, 0, 4, 2, "North");
		assertTrue(map.tiles[1][0] instanceof Domain);
		Domain north1 = (Domain) map.tiles[1][0];
		assertTrue(north1.name.equals("North-1"));

		map.assignFreeDomain(8, 6, 2, 2, "Volantis");
		assertTrue(map.tiles[8][6] instanceof Domain);
		Domain volantis2 = (Domain) map.tiles[9][6];
		assertTrue(volantis2.name.equals("Volantis-2"));

	}

	@Test
	public void testAssignDomainWithHouse() {
		House stark = new HouseFactory().getStark();
		map.assignDomainWithHouse(1, 2, 4, 2, "Winterfell", stark);
		assertTrue(map.tiles[1][3] instanceof Domain);
		Domain winterfell1 = (Domain) map.tiles[1][2];
		// assertTrue(winterfell1.house.name.equals("Stark"));
		assertTrue(winterfell1.name.equals("Winterfell-1"));

		House martell = new HouseFactory().getMartell();
		map.assignDomainWithHouse(3, 8, 2, 2, "Dorne", martell);
		assertTrue(map.tiles[3][8] instanceof Domain);
		Domain dorne1 = (Domain) map.tiles[3][8];
		// assertTrue(dorne1.house.name.equals("Martell"));
		assertTrue(dorne1.name.equals("Dorne-1"));

	}

	@Test
	public void testFillWater() {
		House stark = new HouseFactory().getStark();
		map.assignDomainWithHouse(1, 2, 4, 2, "Winterfell", stark);

		map.fillWater();

		Domain winterfell1 = (Domain) map.tiles[1][2];

		assertTrue(winterfell1.name.equals("Winterfell-1"));

		assertTrue(map.tiles[6][6] instanceof WaterTile);

	}

	@Test
	public void testAllowMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsWinter() {

		assertTrue(map.winter == false);
		map.startWinter();
		assertTrue(map.winter);
	}

}
