package poke.mon.party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import poke.mon.pokemon.PokemonCreator;

public class PokemonParty {
	
	private List<PokemonCreator> party;
	
	public PokemonParty() {
		party = new ArrayList<PokemonCreator>(6);
	}
	
	public Collection<PokemonCreator> getparty() {
		return Collections.unmodifiableList(party);
	}
	
	public boolean addPokemon(PokemonCreator pokemon) {
		if (party.size() == 6) {
			return false;
		}
		if (party.add(pokemon)) {
			return true;
		}
		return false;
	}
	
	public boolean removePokemon(PokemonCreator pokemon) {
		if (party.size() < 2) {
			return false;
		}
		if (party.remove(pokemon)) {
			return true;
		}
		return false;
	}
	
	public void removePokemonIndex(int index) {
		party.remove(index);
	}
	
	public void removePokedexId(int pokemonId) {
		int i = 0;
		for (PokemonCreator p : party) {
			if (p.getPokedexId() == pokemonId) {
				party.remove(i);
			}
			i++;
		}
	}
}
