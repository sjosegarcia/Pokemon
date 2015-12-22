package poke.mon.trainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import poke.mon.pokemon.Pokemon;

public class PokemonPokedex {
	
	private List<Pokemon> seen = new ArrayList<Pokemon>();
	private List<Pokemon> owned = new ArrayList<Pokemon>();
	
	public PokemonPokedex() {}
	
	public List<Pokemon> getSeen() {
		return Collections.unmodifiableList(seen);
	}
	
	public List<Pokemon> getOwned() {
		return Collections.unmodifiableList(owned);
	}
	
	public boolean addOwned(Pokemon pokemon) {
	/*	if (owned.contains(pokemon)) {
			return false;
		}*/
		return owned.add(pokemon);
	}	
	
	public boolean addSeen(Pokemon pokemon) {
		for (Pokemon p : seen) {
			if (p.getData().getPokedexId() == pokemon.getData().getPokedexId()) {
				return false;
			}
		}
		return seen.add(pokemon);
	}	
}