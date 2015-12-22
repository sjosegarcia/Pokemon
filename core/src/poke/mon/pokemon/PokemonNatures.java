package poke.mon.pokemon;

public enum PokemonNatures {
	HARDY("Hardy", PokemonStats.UNKNOWN, PokemonStats.UNKNOWN),
	LONELY("Lonely", PokemonStats.ATTACK, PokemonStats.DEFENSE),
	BRAVE("Brave", PokemonStats.ATTACK, PokemonStats.SPEED),
	ADAMANT("Adamant", PokemonStats.ATTACK, PokemonStats.SPECIAL_ATTACK),
	NAUGHTY("Naughty", PokemonStats.ATTACK, PokemonStats.SPECIAL_DEFENSE),
	BOLD("Bold", PokemonStats.DEFENSE, PokemonStats.ATTACK),
	DOCILE("Docile", PokemonStats.UNKNOWN, PokemonStats.UNKNOWN),
	RELAXED("Relaxed", PokemonStats.DEFENSE, PokemonStats.SPEED),
	IMPISH("Impish", PokemonStats.DEFENSE, PokemonStats.SPECIAL_ATTACK),
	LAX("Lax", PokemonStats.DEFENSE, PokemonStats.SPECIAL_DEFENSE),
	TIMID("Timid", PokemonStats.SPEED, PokemonStats.ATTACK),
	HASTY("Hasty", PokemonStats.SPEED, PokemonStats.DEFENSE),
	SERIOUS("Serious", PokemonStats.UNKNOWN, PokemonStats.UNKNOWN),
	JOLLY("Jolly", PokemonStats.SPEED, PokemonStats.SPECIAL_ATTACK),
	NAIVE("Naive", PokemonStats.SPEED, PokemonStats.SPECIAL_DEFENSE),
	MODEST("Modest", PokemonStats.SPECIAL_ATTACK, PokemonStats.ATTACK),
	MILD("Mild", PokemonStats.SPECIAL_ATTACK, PokemonStats.DEFENSE),
	QUIET("Quiet", PokemonStats.SPECIAL_ATTACK, PokemonStats.SPEED),
	BASHFUL("Bashful", PokemonStats.UNKNOWN, PokemonStats.UNKNOWN),
	RASH("Rash", PokemonStats.SPECIAL_ATTACK, PokemonStats.SPECIAL_DEFENSE),
	CALM("Calm", PokemonStats.SPECIAL_DEFENSE, PokemonStats.ATTACK),
	GENTLE("Gentle", PokemonStats.SPECIAL_DEFENSE, PokemonStats.DEFENSE),
	SASSY("Sassy", PokemonStats.SPECIAL_DEFENSE, PokemonStats.SPEED),
	CAREFUL("Careful", PokemonStats.SPECIAL_DEFENSE, PokemonStats.SPECIAL_ATTACK),
	QUIRKY("Quirky", PokemonStats.UNKNOWN, PokemonStats.UNKNOWN);//http://bulbapedia.bulbagarden.net/wiki/Nature#List_of_Natures
	
	private String name;
	private PokemonStats increased;
	private PokemonStats decreased;
	
	private PokemonNatures(String name, PokemonStats increased, PokemonStats decreased) {
		this.name = name;
		this.increased = increased;
		this.decreased = decreased;
	}
	
	public String getName() {
		return name;
	}
	
	public PokemonStats getDecreased() {
		return decreased;
	}

	public PokemonStats getIncreased() {
		return increased;
	}
}
