package poke.mon.trainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import poke.mon.pokemon.Pokemon;

public class PokemonStorage {
	
	/*
	 * 
	 * TODO Implement the logic for player storage
	 * 
	 * */
	
	private List<Pokemon> storage = new ArrayList<Pokemon>();
	
	public PokemonStorage() {

	}
	
	public Collection<Pokemon> getStorage() {
		return Collections.unmodifiableList(storage);
	}
}