package poke.mon.pokemon;

public class PokemonEvolution {
	
	private String pokemonName;
	private int level;
	
	public PokemonEvolution(String pokemonName, int level) {
		this.pokemonName = pokemonName;
		this.level = level;
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
