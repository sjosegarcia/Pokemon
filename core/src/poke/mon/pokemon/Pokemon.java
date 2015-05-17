package poke.mon.pokemon;

import java.util.EnumMap;

import poke.mon.trainer.Gender;

public class Pokemon {
	
	private EnumMap<PokemonStats, Integer> iv = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private EnumMap<PokemonStats, Integer> ev = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private String nickName;
	private boolean isShiny;
	private boolean isShadow;
	private boolean hasPokerus;
	private PokemonCreator pokemon;
	private int trainerId = -1;
	private int trainerSid = -1;
	private int level;
	private int exp;
	private String trainerName;
	private PokemonAbilities ability;
	private PokemonAbilities hiddenAbility = null;
	private int happiness = -1;
	private Gender gender = Gender.UNKNOWN;
	
	/*TODO 
	 * add a rng for pokemon that can have different abilities
	 * add movesets
	 * add the logic to randomly generate a gender
	 * add the math to calculate ev's and iv's
	 * */
	
	public Pokemon(PokemonCreator pokemon) { 
		this.pokemon = pokemon;
		this.happiness = pokemon.getHappiness();
		this.ev = pokemon.getEv();
	}
	
	public EnumMap<PokemonStats, Integer> getIv() {
		return iv;
	}

	public void setIv(EnumMap<PokemonStats, Integer> iv) {
		this.iv = iv;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isShiny() {
		return isShiny;
	}

	public void setShiny(boolean isShiny) {
		this.isShiny = isShiny;
	}

	public boolean isShadow() {
		return isShadow;
	}

	public void setShadow(boolean isShadow) {
		this.isShadow = isShadow;
	}

	public boolean isHasPokerus() {
		return hasPokerus;
	}

	public void setPokerus(boolean hasPokerus) {
		this.hasPokerus = hasPokerus;
	}

	public PokemonCreator getPokemon() {
		return pokemon;
	}

	public void setPokemon(PokemonCreator pokemon) {
		this.pokemon = pokemon;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getTrainerSid() {
		return trainerSid;
	}

	public void setTrainerSid(int trainerSid) {
		this.trainerSid = trainerSid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public PokemonAbilities getAbility() {
		return ability;
	}

	public void setAbility(PokemonAbilities ability) {
		this.ability = ability;
	}

	public PokemonAbilities getHiddenAbility() {
		return hiddenAbility;
	}

	public void setHiddenAbility(PokemonAbilities hiddenAbility) {
		this.hiddenAbility = hiddenAbility;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public EnumMap<PokemonStats, Integer> getEv() {
		return ev;
	}

	public void setEv(EnumMap<PokemonStats, Integer> ev) {
		this.ev = ev;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}