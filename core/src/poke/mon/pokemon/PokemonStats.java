package poke.mon.pokemon;

public enum PokemonStats {//hp atk def spatk spdef speed
	UNKNOWN(-1),
	HP(0),
	ATTACK(1),
	DEFENSE(2),
	SPEED(3),
	SPECIAL_ATTACK(4),
	SPECIAL_DEFENSE(5);
	
	private int id;
	
	private PokemonStats(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public PokemonStats getStat(int id) {
		for (PokemonStats stat : PokemonStats.values()) {
			if (stat.getId() == id) {
				return stat;
			}
		}
		return PokemonStats.UNKNOWN;
	}
	
}
