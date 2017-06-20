package io.sopra.pox3.got.tile;

import java.util.Optional;

import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.story.HouseFactory;

public class World {

	Tile[][] tiles = new Tile[12][11];
	boolean winter = false;
	int winterLatitude = 0;

	public World() {
		generate();
	}
	
	public Domain getWinterfell7(){
		return (Domain) this.get(3,3);
	}
	
	public Domain getTheEyrie1() {
		return (Domain) this.get(3, 4);
	}
	
	public Domain getThrone() {
		return (Domain) this.get(4, 7);
	}
	
	public Domain getMereen3() {
		return (Domain) this.get(8, 9);
	}

	public void generate() {
		assignFreeDomain(1, 0, 4, 2, "North");
		assignFreeDomain(8, 2, 2, 2, "Bravos");
		assignFreeDomain(8, 4, 2, 2, "Pentos");
		assignFreeDomain(8, 6, 2, 2, "Volantis");
		assignFreeDomain(10, 4, 1, 6, "Red Waste");

		House stark = new HouseFactory().getStark();
		this.assignDomainWithHouse(1, 2, 4, 2, "Winterfell", stark);

		House lannister = new HouseFactory().getLannister();
		this.assignDomainWithHouse(1, 6, 2, 2, "Casterly Rock", lannister);

		House baratheon = new HouseFactory().getBaratheon();
		this.assignDomainWithHouse(3, 6, 2, 2, "Kings Landing", baratheon);

		House tyrell = new HouseFactory().getTyrell();
		this.assignDomainWithHouse(1, 8, 2, 2, "High Garden", tyrell);

		House greyjoy = new HouseFactory().getGreyjoy();
		this.assignDomainWithHouse(1, 4, 2, 2, "Iron Islands", greyjoy);

		House arryn = new HouseFactory().getArryn();
		this.assignDomainWithHouse(3, 4, 2, 2, "The Eyre", arryn);

		House martell = new HouseFactory().getMartell();
		this.assignDomainWithHouse(3, 8, 2, 2, "Dorne", martell);

		House targaryen = new HouseFactory().getTargaryen();
		this.assignDomainWithHouse(8, 8, 2, 2, "Mereen", targaryen);

		fillWater();

	}

	void assignFreeDomain(int xOrigin, int yOrigin, int xSize, int ySize, String name) {

		assignDomainWithHouse(xOrigin, yOrigin, xSize, ySize, name, null);
	}

	void assignDomainWithHouse(int xOrigin, int yOrigin, int xSize, int ySize, String name, House house) {
		int number = 1;

		for (int y = yOrigin; y < (yOrigin + ySize); y++) {
			for (int x = xOrigin; x < (xOrigin + xSize); x++) {

				Domain domain = new Domain(x, y, name + "-" + number);

				domain.x = x;
				domain.y = y;

				tiles[x][y] = domain;
				domain.house = house == null ? Optional.empty() : Optional.of(house);

				number++;
			}
		}
	}

	void fillWater() {

		for (int x = 0; x < 12; x++) {

			for (int y = 0; y < 11; y++) {

				WaterTile water = new WaterTile(x, y);

				if (tiles[x][y] == null) {
					tiles[x][y] = water;
				}
			}
		}
	}

	boolean allowMove(Tile origin, Tile destination, boolean boat) {
		return false;
	}

	boolean isWinter() {
		return false;
	}

	void startWinter() {
		this.winter = true;
	}

	public void display() {
		for (int y = 0; y < 11; y++) {
			for (int x = 0; x < 12; x++) {
				Tile wTile = tiles[x][y];
				if (wTile.toString().length() > 10) {

					System.out.print(" " + wTile.toString().substring(0, 10) + "\t");

				} else {

					System.out.print(" " + wTile + "\t");

				}
			}
			System.out.println(' ');
		}
	}

	public static void main(String[] args) {
		World map = new World();
		map.generate();
		map.display();
	}

	public Tile get(int x, int y) {
		return this.tiles[x][y];
	}

}
