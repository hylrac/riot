package io.sopra.pox3.got.story;

import java.util.List;

import io.sopra.pox3.got.game.Player;
import io.sopra.pox3.got.tile.Domain;

public class House {

	public String name;
	String words;
	Player player;

	public House(String name, String words) {
		this.name = name;
		this.words = words;
	}

	List<Domain> getDomain() {
		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
		
	}
	
	public boolean hasBoat(){
		return false;
	}
	
	public boolean hasDragon(){
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof House))
			return false;
		House other = (House) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
