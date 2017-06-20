package io.sopra.pox3.got.war;

import io.sopra.pox3.got.game.Player;
import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.tile.Domain;
import io.sopra.pox3.got.tile.Tile;

public class Army implements IArmy {

	int readyTroops;
	int movedTroops;
	House house;
	Tile position;
	ArmyState state;

	public Army(int troops, House house, Tile position) {
		this.readyTroops = troops;
		this.house = house;
		this.position = position;
	}

	public int getTroops() {

		return this.readyTroops;
	}

	@Override
	public boolean attack(IArmy ennemy) {
		if (ennemy.getTotalTroops() >= this.readyTroops) {
			setState(ArmyState.DEAD);
			return false;
		} else {
			setState(ArmyState.WON);
			return true;
		}
	}

	public void move(int troops, Domain domain) {
		// TODO Auto-generated method stub

	}

	public void move(Domain domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tile getPosition() {
		return this.position;
	}

	@Override
	public House getHouse() {
		return this.house;
	}

	public void setState(ArmyState state) {
		this.state = state;
	}

	@Override
	public ArmyState getState() {
		return this.state;
	}

	@Override
	public int getTotalTroops() {
		// TODO Auto-generated method stub
		return this.readyTroops + this.movedTroops;
	}

	@Override
	public int getMovedTroops() {
		// TODO Auto-generated method stub
		return this.movedTroops;
	}

	@Override
	public int getReadyTroops() {
		// TODO Auto-generated method stub
		return this.readyTroops;
	}

	@Override
	public void move(int troops, Direction direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(Direction direction) {
		
		this.getPlayer().decreaseMoves();

	}

	@Override
	public Player getPlayer() {

		return this.house.getPlayer();
	}

}
