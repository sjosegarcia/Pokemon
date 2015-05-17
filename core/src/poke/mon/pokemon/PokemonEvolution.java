package poke.mon.pokemon;

import poke.mon.evolution.EvolutionConditions;
import poke.mon.loader.PokemonLoader;

public class PokemonEvolution {

	
	/*
  		<evolution name="VAPOREON" condition="Item" value="WATERSTONE"/>
		<evolution name="JOLTEON" condition="Item" value="THUNDERSTONE"/>
		<evolution name="FLAREON" condition="Item" value="FIRESTONE"/>
		<evolution name="LEAFEON" condition="Location" value="28"/>
		<evolution name="GLACEON" condition="Location" value="34"/>
		<evolution name="ESPEON" condition="HappinessDay" value=""/>
		<evolution name="UMBREON" condition="HappinessNight"/>
	*/
	private int id;
	private String name;
	private int level;
	private EvolutionConditions condition;
	private String item;
	
	public PokemonEvolution(int id, int level) {
		this.id = id;
		this.name = PokemonLoader.getPokemonById(id).getName();
		this.level = level;
	}
	
	public PokemonEvolution(String name, int level) {
		this.id = PokemonLoader.getPokemonByName(name).getId();
		this.name = name;
		this.level = level;
	}
	
	public PokemonEvolution(int id, String name, int level) {
		this.id = id;
		this.name = name;
		this.level = level;
	}
	
	public PokemonEvolution(PokemonCreator pokemon) {
		this.id = pokemon.getId();
	}
	
	public int getId() {
		return id;
	}
	
	public String getPokemonName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}