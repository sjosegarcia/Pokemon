package poke.mon.trainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import poke.mon.pokemon.Pokemon;

public class PokemonStorage {
	
	private List<Pokemon> storage = new ArrayList<Pokemon>();
	
	public PokemonStorage() {}
	
	public Collection<Pokemon> getStorage() {
		return Collections.unmodifiableList(storage);
	}
	
	public boolean addPokemon(Pokemon pokemon) {
		return storage.add(pokemon);
	}
	
	public boolean removePokemon(Pokemon pokemon) {
		return storage.remove(pokemon);
	}
	
	public void removePokemonIndex(int index) {
		storage.remove(index);
	}
	
	public void removePokedexId(int pokemonId) {
		for (Pokemon pokemon : storage) {
			if (pokemon.getData().getPokedexId() == pokemonId) {
				storage.remove(storage.indexOf(pokemon));
			}
		}
	}
	
	public void clearStorage() {
		storage.clear();
	}
	
}
