package io.sopra.pox3.got.game;

import io.sopra.pox3.got.objectives.ObjectiveCard;
import io.sopra.pox3.got.story.House;

public class Player {
	String name;
	House house;
	ObjectiveCard cards;
	PlayerState state = PlayerState.PLAYING;
	RoundState roundState = RoundState.WAITING;

	// Bidirection, argh
	Game game;
	Round currentRound;

	public int moves = 3;

	public Player(String name, House house) {
		this.name = name;
		this.house = house;
		// bidirection
		this.house.setPlayer(this);
		// but this link never moves. not so bad
	}

	boolean chooseName(String pName) {

		this.name = pName;
		return true;
	}

	boolean chooseHouse(House pHouse) {
		this.house = pHouse;
		return true;
	}

	public void decreaseMoves() {
		if (this.roundState == RoundState.WAITING) {
			throw new PlayerRoundEndedException();
		}
		this.moves--;

	}

}
