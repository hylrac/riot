package io.sopra.pox3.got.game;

public class Round {

	void end(Player player){
		player.moves =0;
		player.roundState=RoundState.WAITING;
		
	}
	
	void end(){
		
	}
}
