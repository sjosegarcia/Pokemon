package poke.mon.pokemon;

import java.util.EnumMap;

public class PokemonCreator {

	private int id;
	private PokemonTypes[] type;
	private EnumMap<PokemonStats, Integer> effortPoints = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private EnumMap<PokemonStats, Integer> ev = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private PokemonAbilities[] ability;
	private PokemonAbilities hiddenAbility;
	private int pokedexId;
	private int baseExp;
	private int rareness;
	private int happiness;
	private String name;
	private int numStepsToHatch;
	private float height;
	private float weight;
	private String color;
	private String habitat;
	private String species;
	private String pokedexDescription;
	private String genderRate;
	private String growthRate;
	private int playerY;
	private int enemyY;
	private int altitude;
	private String[] compatibility;
	
	public PokemonCreator() {}
	
	public PokemonTypes[] getType() {
		return type;
	}
	
	public void setTypes(PokemonTypes[] type) {
		this.type = type;
	}
	
	public EnumMap<PokemonStats, Integer> getEv() {
		return ev;
	}

	public void setEv(EnumMap<PokemonStats, Integer> ev) {
		this.ev = ev;
	}

	public int getPokedexId() {
		return pokedexId;
	}

	public void setPokedexId(int pokedexId) {
		this.pokedexId = pokedexId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getRareness() {
		return rareness;
	}

	public void setRareness(int rareness) {
		this.rareness = rareness;
	}

	public int getBaseExp() {
		return baseExp;
	}

	public void setBaseExp(int baseExp) {
		this.baseExp = baseExp;
	}

	public PokemonAbilities[] getAbility() {
		return ability;
	}

	public void setAbility(PokemonAbilities[] ability) {
		this.ability = ability;
	}

	public PokemonAbilities getHiddenAbility() {
		return hiddenAbility;
	}

	public void setHiddenAbility(PokemonAbilities hiddenAbility) {
		this.hiddenAbility = hiddenAbility;
	}

	public int getNumStepsToHatch() {
		return numStepsToHatch;
	}

	public void setNumStepsToHatch(int numStepsToHatch) {
		this.numStepsToHatch = numStepsToHatch;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getPokedexDescription() {
		return pokedexDescription;
	}

	public void setPokedexDescription(String pokedexDescription) {
		this.pokedexDescription = pokedexDescription;
	}

	public String getGenderRate() {
		return genderRate;
	}

	public void setGenderRate(String genderRate) {
		this.genderRate = genderRate;
	}

	public String getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(String growthRate) {
		this.growthRate = growthRate;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public int getEnemyY() {
		return enemyY;
	}

	public void setEnemyY(int enemyY) {
		this.enemyY = enemyY;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EnumMap<PokemonStats, Integer> getEffortPoints() {
		return effortPoints;
	}

	public void setEffortPoints(EnumMap<PokemonStats, Integer> effortPoints) {
		this.effortPoints = effortPoints;
	}

	public String[] getCompatibility() {
		return compatibility;
	}

	public void setCompatibility(String[] compatibility) {
		this.compatibility = compatibility;
	}
}