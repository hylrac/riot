package io.sopra.pox3.got.game;

import java.util.ArrayList;
import java.util.List;

import io.sopra.pox3.got.objectives.ObjectiveCard;
import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.story.HouseFactory;

/**
 * Starting class for launching game
 * @author AELION
 *
 */
public class Game {
	List<Player> players = new ArrayList<>();
	List<House> houses = new HouseFactory().getAllHouses();
	List<House> availablehouses = new HouseFactory().getAllHouses();

	List<ObjectiveCard> cards;
	List<Round> rounds = new ArrayList<>();
	
	public Game(){
		
	}
	
	public void init(){
		newRound();
	}



	List<House> getAvailableHouses() {
		return availablehouses;
	}

	void savePlayers(Player player) {
		this.players.add(player);
		this.availablehouses.remove(player.house);
	}
	
	Round getCurrentRound(){
		return this.rounds.get(this.rounds.size()-1);
	}
	
	void newRound(){
		rounds.add(new Round());
		//this.players.stream().forEach(p -> p.moves = 3);
		boolean firstNotDead = true;
		
		for (Player p : this.players){
			if (p.roundState != RoundState.DEAD){
				p.moves = 3;
				if (firstNotDead){
					p.roundState=RoundState.PLAYING;
					firstNotDead = false;
				}else{
					p.roundState = RoundState.WAITING;
				}
			}else{
				p.moves =0;
			}
		}
		
	}

}
