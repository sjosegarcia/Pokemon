package poke.mon.pokemon;

import java.util.ArrayList;

public class PokemonTypeManipulator {
	private PokemonTypes type;
	private ArrayList<PokemonTypes> weakness;
	private ArrayList<PokemonTypes> resistance;
	private ArrayList<PokemonTypes> immunities;

	
	public PokemonTypeManipulator(PokemonTypes type, ArrayList<PokemonTypes> weakness, ArrayList<PokemonTypes> resistance, ArrayList<PokemonTypes> immunities) {
		this.type = type;
		this.weakness = weakness;
		this.resistance = resistance;
		this.immunities = immunities;
	}

	public ArrayList<PokemonTypes> getWeakness() {
		return weakness;
	}

	public void setWeakness(ArrayList<PokemonTypes> weakness) {
		this.weakness = weakness;
	}

	public ArrayList<PokemonTypes> getResistance() {
		return resistance;
	}

	public void setResistance(ArrayList<PokemonTypes> resistance) {
		this.resistance = resistance;
	}

	public ArrayList<PokemonTypes> getImmunities() {
		return immunities;
	}

	public void setImmunities(ArrayList<PokemonTypes> immunities) {
		this.immunities = immunities;
	}

	public PokemonTypes getType() {
		return type;
	}

	public void setType(PokemonTypes type) {
		this.type = type;
	}
}
