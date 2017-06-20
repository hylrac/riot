package io.sopra.pox3.got.objectives;

import java.util.List;

import io.sopra.pox3.got.story.House;
import io.sopra.pox3.got.tile.Domain;

public class OccupyDomainCard extends ObjectiveCard{
	List <Domain> domains;
	
	boolean succed (House house){
		return false; 
	}
}
