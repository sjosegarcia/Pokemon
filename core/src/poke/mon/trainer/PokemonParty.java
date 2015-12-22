package poke.mon.trainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import poke.mon.constants.Constants;
import poke.mon.pokemon.Pokemon;

public class PokemonParty {
	
	private List<Pokemon> party = new ArrayList<Pokemon>();
	
	public PokemonParty() {}
	
	public Collection<Pokemon> getParty() {
		return Collections.unmodifiableList(party);
	}
	
	public boolean addPokemon(Pokemon pokemon) {
		if (party.size() == Constants.partySize) {
			return false;
		}
		return party.add(pokemon);
	}
	
	public boolean removePokemon(Pokemon pokemon) {
		if (party.size() < 2) {
			return false;
		}
		return party.remove(pokemon);
	}
	
	public void removePokemonIndex(int index) {
		party.remove(index);
	}
	
	public void removePokedexId(int pokemonId) {
		for (Pokemon pokemon : party) {
			if (pokemon.getData().getPokedexId() == pokemonId) {
				party.remove(party.indexOf(pokemon));
			}
		}
	}
	
	public boolean isFull() {
		return party.size() == Constants.partySize;
	}
	
	public void clearParty() {
		party.clear();
	}
	
}