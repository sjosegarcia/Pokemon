package poke.mon.pokemon;

public enum PokemonTypes {
	
	UNKOWN("Unknown"),
	NORMAL("Normal"),
	FIGHTING("Fighting"),
	PSYCHIC("Psychic"),
	GHOST("Ghost"),
	ELECTRIC("Electric"),
	WATER("Water"),
	FLYING("Flying"),
	GRASS("Grass"),
	BUG("Bug"),
	FIRE("Fire"),
	DRAGON("Dragon"),
	ICE("Ice"),
	FAIRY("Fairy"),
	STEEL("Steel"),
	ROCK("Rock"),
	GROUND("Ground"),
	DARK("Dark"),
	POISON("Poison"),
	SHADOW("Shadow");	
	
	private String type;
	
	private PokemonTypes(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public PokemonTypes getTypeByString(String typing) {
		for (PokemonTypes types : PokemonTypes.values()) {
			if (types.getType().equalsIgnoreCase(typing)) {
				return types;
			}
		}
		return PokemonTypes.UNKOWN;
	}
	
}
