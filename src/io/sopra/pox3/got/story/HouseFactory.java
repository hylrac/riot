package io.sopra.pox3.got.story;

import java.util.ArrayList;
import java.util.List;

public class HouseFactory {
	static List<House> houses = new ArrayList<>();

	public List<House> getAllHouses() {
		if (houses.size() == 8) {
			return houses;
		}
		House stark = new House("Stark", "Winter is coming");
		House lannister = new House("Lannister", "Hear Me Roar!");
		House baratheon = new House("Baratheon", "Ours is the fury");
		House tyrell = new House("Tyrell", "Growing Strong");
		House greyjoy = new House("Greyjoy", "We Do Not Sow");
		House arryn = new House("Arryn", "As High as Honor");
		House martell = new House("Martell", "Unbowed, Unbent, Unbroken");
		House targaryen = new House("Targaryen", " Fire and Blood");

		houses.add(stark);
		houses.add(lannister);
		houses.add(baratheon);
		houses.add(tyrell);
		houses.add(greyjoy);
		houses.add(arryn);
		houses.add(martell);
		houses.add(targaryen);

		return houses;
	}

	public House getStark() {
		return getAllHouses().get(0);
	}
	
	public House getLannister() {
		return getAllHouses().get(1);
	}
	
	public House getBaratheon() {
		return getAllHouses().get(2);
	}
	
	public House getTyrell() {
		return getAllHouses().get(3);
	}
	
	public House getGreyjoy() {
		return getAllHouses().get(4);
	}
	
	public House getArryn() {
		return getAllHouses().get(5);
	}
	
	public House getMartell() {
		return getAllHouses().get(6);
	}
	
	public House getTargaryen() {
		return getAllHouses().get(7);
	}

}
