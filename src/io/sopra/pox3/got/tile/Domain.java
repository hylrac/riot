package io.sopra.pox3.got.tile;

import java.util.Optional;
import java.util.Random;

import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.war.IArmy;

public class Domain extends Tile {

	int population;
	String name;

	Optional<House> house = Optional.empty();
	static Random seed = new Random();


	public Domain(int x, int y, String name) {
		super(x, y);
		this.population = seed.nextInt(10) + 1;
		this.name = name;
	}

	IArmy createArmy() {
		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
