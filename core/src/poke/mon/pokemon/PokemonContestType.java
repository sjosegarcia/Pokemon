package poke.mon.pokemon;

public enum PokemonContestType {
	BEAUTY("Beauty"),
	COOL("Cool"),
	CUTE("Cute"),
	SMART("Smart"),
	THOUGH("Though"),
	SHEEN("Sheen");
	
	private String contestType;
	
	private PokemonContestType(String contestType) {
		this.contestType = contestType;
	}
	
	public String getString() {
		return contestType;
	}	
}
