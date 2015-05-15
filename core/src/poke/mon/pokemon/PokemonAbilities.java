package poke.mon.pokemon;

public class PokemonAbilities { //http://bulbapedia.bulbagarden.net/wiki/Ability

	private String name, discription;
	private int id;
	
	public PokemonAbilities(int id, String name, String discription) {
		this.id = id;
		this.name = name;
		this.discription = discription;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getDiscription() {
		return discription;
	}
	
}
