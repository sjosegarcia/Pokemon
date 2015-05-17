package poke.mon.trainer;

import poke.mon.life.PlayerRenderer;

public class PokemonTrainer {

	private PlayerRenderer player;
	private PokemonParty party;
	private int id;
	private int sId;
	private Gender gender = Gender.UNKNOWN;
	private PokemonPokedex pokedex = null;
	private String name;
	
	public PokemonTrainer() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setPlayer(PlayerRenderer player) {
		this.player = player;
	}
	
	public PlayerRenderer getPlayer() {
		return player;
	}

	public PokemonParty getParty() {
		return party;
	}

	public void setParty(PokemonParty party) {
		this.party = party;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean hasPokedex() {
		return pokedex != null;
	}

	public void setPokedex(PokemonPokedex pokedex) {
		this.pokedex = pokedex;
	}
	
	public PokemonPokedex getPokedex() {
		return pokedex;
	}
	
	public boolean hasPokemon() {
		return party.getParty().size() > 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}
	
}