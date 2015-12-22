package poke.mon.pokemon;

import java.util.EnumMap;
import java.util.Random;

import poke.mon.constants.Constants;
import poke.mon.loader.PokemonLoader;
import poke.mon.status.StatusConditions;
import poke.mon.trainer.Gender;
import poke.mon.trainer.PokemonTrainer;

public class Pokemon {
	
	private EnumMap<PokemonStats, Integer> iv = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private EnumMap<PokemonStats, Integer> ev = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private EnumMap<PokemonStats, Integer> stats = new EnumMap<PokemonStats, Integer>(PokemonStats.class);
	private EnumMap<PokemonContestType, Integer> contest = new EnumMap<PokemonContestType, Integer>(PokemonContestType.class);	
	private String nickName;
	private boolean isShiny = false;
	private boolean isShadow = false;
	private boolean hasPokerus = false;
	private PokemonCreator pokemon;
	private int trainerId = -1;
	private int currentTrainerId = -1;
	private long trainerSid = -1;
	private int level = Constants.defaultLevel;
	private int levelObtained = -1;
	private int exp = 0;
	private int expForNextLevel = 0;
	private String oT;
	private Gender oTGender = Gender.UNKNOWN;
	private String nT;
	private PokemonAbilities ability;
	private int happiness = -1;
	private Gender gender = Gender.UNKNOWN;
	private StatusConditions condition = StatusConditions.NORMAL;
	private long pId = 0xFFFFFFFFL;
	private Random rand;
	private int hp = 0;
	private PokemonNatures nature;
	private byte marking = 0xF;
	/*TODO
	 * http://pokemonessentials.wikia.com/wiki/Editing_a_Pok�mon
	 * http://bulbapedia.bulbagarden.net/wiki/Stats
	 * http://bulbapedia.bulbagarden.net/wiki/Personality_value
	 * http://bulbapedia.bulbagarden.net/wiki/Nature
	 * add movesets
	 * Markings
	 * Expand on IV when its bred
	 * Create a way to set location where pokemon was obtained from
	 * Ribbons

		
		Hidden ability chances: 20% if male, 60% if female (Only if one of the parents have the hidden ability).
	 * */
	
	public Pokemon(PokemonCreator pokemon) {
		this.pokemon = pokemon;
		newPokemon(null);
	}
	
	public Pokemon(String name) {
		this.pokemon = PokemonLoader.getPokemonByName(name);
		newPokemon(null);
	}
	
	public Pokemon(int id) {
		this.pokemon = PokemonLoader.getPokemonById(id);
		newPokemon(null);
	}
	
	public Pokemon(PokemonCreator pokemon, int level) {
		this.pokemon = pokemon;
		this.level = level;
		newPokemon(null);
	}
	
	public Pokemon(String name, int level) {
		this.pokemon = PokemonLoader.getPokemonByName(name);
		this.level = level;
		newPokemon(null);
	}
	
	public Pokemon(int id, int level) {
		this.pokemon = PokemonLoader.getPokemonById(id);
		this.level = level;
		newPokemon(null);
	}
	
	
	public Pokemon(PokemonCreator pokemon, PokemonTrainer trainer) {
		this.pokemon = pokemon;
		newPokemon(trainer);
	}
	
	public Pokemon(String name, PokemonTrainer trainer) {
		this.pokemon = PokemonLoader.getPokemonByName(name);
		newPokemon(trainer);	
	}
	
	public Pokemon(int id, PokemonTrainer trainer) {
		this.pokemon = PokemonLoader.getPokemonById(id);
		newPokemon(trainer);
	}
	
	public Pokemon(PokemonCreator pokemon, int level, PokemonTrainer trainer) {
		this.pokemon = pokemon;
		this.level = level;
		newPokemon(trainer);
	}
	
	public Pokemon(String name, int level, PokemonTrainer trainer) {
		this.pokemon = PokemonLoader.getPokemonByName(name);
		this.level = level;
		newPokemon(trainer);
	}
	
	public Pokemon(int id, int level, PokemonTrainer trainer) {
		this.pokemon = PokemonLoader.getPokemonById(id);
		this.level = level;
		newPokemon(trainer);
	}
	
	private void newPokemon(PokemonTrainer trainer) {
		this.nickName = pokemon.getName();
		this.happiness = pokemon.getHappiness();
		this.ev = pokemon.getEv();
		this.levelObtained = level;
		checkExp();
		rand = new Random();
		setpId(rand.nextInt() & pId);
		setPokemonGender();
		if (hasHiddenAbility()) {
			setAbility(this.pokemon.getHiddenAbility());
		} else {
			setAbility(this.pokemon.getAbility()[rand.nextInt(this.pokemon.getAbility().length)]);
		}
		for (int i = 0; i < PokemonContestType.values().length; i++) {
			this.contest.put(PokemonContestType.values()[i], 0);
		}
		for (int i = 1; i < PokemonStats.values().length; i++) {
			this.iv.put(PokemonStats.values()[i], rand.nextInt(32));
		}
		if (isLegendary()) {
			for (int i = 0; i < 3; i++) {
				this.iv.put(PokemonStats.values()[rand.nextInt(PokemonStats.values().length)+1], 31);
			}
		}
		this.nature = PokemonNatures.values()[(int) (pId % PokemonNatures.values().length)];
		this.hp = calculateHP();
		this.stats.put(PokemonStats.HP, calculateHP());
		for (int i = 1; i < PokemonStats.values().length; i++) {
			PokemonStats stat = PokemonStats.values()[i];
			stats.put(stat, (int) calculateStats(stat));
		}
		if (trainer != null)
			setTrainer(trainer);
	}
	
	private int calculateHP() {
		return (((iv.get(PokemonStats.HP) + (2 * pokemon.getEv().get(PokemonStats.HP)) + (ev.get(PokemonStats.HP) / 4) + 100) * level) / 100) + 10;
	}
	
	private float calculateStats(PokemonStats stat) {
		float modifier = 1.0f;
		if (this.nature.getDecreased().equals(stat)) {
			modifier = 0.9f;
		} else if (this.nature.getIncreased().equals(stat)) {
			modifier = 1.1f;
		}
		return ((((iv.get(stat) + (2 * pokemon.getEv().get(stat)) + (ev.get(stat) / 4)) * level) / 100) + 5) * modifier;
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

	public PokemonCreator getData() {
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

	public long getTrainerSid() {
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

	public String getOriginalTrainerName() {
		return oT;
	}

	public void setOriginalTrainerName(String oT) {
		this.oT = oT;
	}

	public PokemonAbilities getAbility() {
		return ability;
	}

	public void setAbility(PokemonAbilities ability) {
		this.ability = ability;
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

	public String getNewTrainerName() {
		return nT;
	}

	public void setNewTrainerName(String nT) {
		this.nT = nT;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public int getCurrentTrainerId() {
		return currentTrainerId;
	}

	public void setCurrentTrainerId(int currentTrainerId) {
		this.currentTrainerId = currentTrainerId;
	}

	public StatusConditions getStatus() {
		return condition;
	}

	public void setStatus(StatusConditions condition) {
		this.condition = condition;
	}

	public Gender getoTGender() {
		return oTGender;
	}

	public void setoTGender(Gender oTGender) {
		this.oTGender = oTGender;
	}
	
	public void setPokemonGender() {
		byte genderRNG = (byte) (pId % 256);
		switch (pokemon.getGenderRate().toUpperCase()) {
			case "GENDERLESS":
				this.gender = Gender.GENDERLESS;
				break;
			case "ALWAYSFEMALE":
				this.gender = Gender.FEMALE;
				break;
			case "ALWAYSMALE":
				this.gender = Gender.MALE;
				break;
			case "FEMALESEVENEIGHTHS":
				if (genderRNG <= 224) {
					this.gender = Gender.FEMALE;
				} else {
					this.gender = Gender.MALE;
				}			
				break;
			case "FEMALE75PERCENT":
				if (genderRNG <= 192) {
					this.gender = Gender.FEMALE;
				} else {
					this.gender = Gender.MALE;
				}
				break;
			case "FEMALE50PERCENT":
				if (genderRNG <= 128) {
					this.gender = Gender.FEMALE;
				} else {
					this.gender = Gender.MALE;
				}
				break;
			case "FEMALE25PERCENT":
				if (genderRNG <= 64) {
					this.gender = Gender.FEMALE;
				} else {
					this.gender = Gender.MALE;
				}
				break;
			case "FEMALEONEEIGHTH":
				if (genderRNG <= 32) {
					this.gender = Gender.FEMALE;
				} else {
					this.gender = Gender.MALE;
				}
				break;
			default:
				this.gender = Gender.UNKNOWN;
			}
		}

	public boolean hasHiddenAbility() {
		return pId / 65536 % 2 == 1;
	}
	
	public void setTrainer(PokemonTrainer trainer) {
		this.oTGender = trainer.getGender();
		this.trainerId = trainer.getId();
		this.oT = trainer.getName();
		this.currentTrainerId = trainer.getId();
		this.nT = trainer.getName();
		this.trainerSid = trainer.getSid();
		int p1 = (int) pId / 65536;
		int p2 = (int) pId % 65536;
		long shiny = trainerId ^ trainerSid ^ p1 ^ p2;
		if (shiny < Constants.shinyChance)
			isShiny = true;
	}

	public int getLevelObtained() {
		return levelObtained;
	}

	public void setLevelObtained(int levelObtained) {
		this.levelObtained = levelObtained;
	}

	public EnumMap<PokemonContestType, Integer> getContest() {
		return contest;
	}

	public void setContest(EnumMap<PokemonContestType, Integer> contest) {
		this.contest = contest;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}		
	
	public EnumMap<PokemonStats, Integer> getStats() {
		return stats;
	}

	public void setStats(EnumMap<PokemonStats, Integer> stats) {
		this.stats = stats;
	}

	public PokemonNatures getNature() {
		return nature;
	}

	public void setNature(PokemonNatures nature) {
		this.nature = nature;
	}
	
	public byte getMarking() {
		return marking;
	}

	public void setMarking(byte marking) {
		this.marking = marking;
	}
	
	public int getExpForNextLevel() {
		return expForNextLevel;
	}
	
	
	public boolean isWildPokemon() {
		return trainerId == -1;
	}
	
	
	public boolean isLegendary() {
		int pokeId = pokemon.getPokedexId();
		return pokeId >= 144 && pokeId <= 146 || pokeId == 150 || pokeId == 151
				|| pokeId >= 243 && pokeId <= 245 || pokeId >= 249 && pokeId <= 251
				|| pokeId >= 377 && pokeId <= 386 || pokeId >= 480 && pokeId <= 494
				|| pokeId >= 638 && pokeId <= 649 || pokeId >= 715 && pokeId <= 720;
	}
	
	
	private PokemonCreator getPokemon() {
		return pokemon;
	}
	
	public void checkExp() {
		switch(pokemon.getGrowthRate().toUpperCase()) {
			case "ERRATIC":
				if (level <= 50) {
					expForNextLevel = (int) Math.floor((Math.pow(level, 3) * (100 - level)) / 50);
				} else if (level >= 50 && level <= 68)  {
					expForNextLevel = (int) Math.floor((Math.pow(level, 3) * (100 - level)) / 100);
				} else if (level >= 68 && level <= 98)  {
					expForNextLevel = (int) Math.floor((Math.pow(level, 3) * ((1911 - (10 *level)) / 3)) / 100);
				} else if (level >= 98 && level <= 100)  {
					expForNextLevel = (int) Math.floor((Math.pow(level, 3) * (160 - level)) / 100);
				}			
				break;
			case "FAST":
				expForNextLevel = (int) (4 * Math.pow(level, 3)) / 5;
				break;
			case "MEDIUMFAST":
				expForNextLevel = (int) Math.pow(level, 3);
				break;
			case "MEDIUMSLOW":
				expForNextLevel = (int) ((int) ((6/5) * Math.pow(level, 3)) - (15 * Math.pow(level, 2)) + (100*level) - 140);
				break;
			case "SLOW":
				expForNextLevel = (int) (5 * Math.pow(level, 3)) / 4;
				break;
			case "FLUCTUATING":
				if (level <= 15) {
					expForNextLevel = (int) Math.pow(level, 3) * (( ((level + 1) / 3) + 24) / 50); 
				} else if (level >= 15 && level <= 36) {
					expForNextLevel = (int) Math.pow(level, 3) * ((level + 14) / 50);
				} else {
					expForNextLevel = (int) Math.pow(level, 3) * (( (level / 2) + 32) / 50); 
				}
				break;
			default:
				expForNextLevel = 0;
				break;
		}
	}
	
	
	public void gainExp(Pokemon opponent) {
		float opponentPokemonModifier = opponent.isWildPokemon() ? 1.0f : 1.5f; 
		float opponentBaseExp = opponent.getPokemon().getBaseExp();
		float luckyEggModifier = 1f; //TODO: for now until I start working on items
		float affectionModifier = 1f; //TODO: poke-amie feature if the pokemon has more than two hearts
		float oPowerModifier = 1f; //TODO: Certain O-Powers stacks up to this
		float expShare = 1f; //TODO: for now until exp-share works
		float trainerModifier = opponent.getTrainerSid() == trainerSid ? 1f : !opponent.isWildPokemon() ? 1.5f : 1f; //TODO if it was a international trade then the modifier would be 1.7
		float isPastEvolutionModifier = 1f; //TODO: if the pokemon is past evolution, then 1.2
		if (Constants.scaledFormula) {
			exp += (int) (( ((opponentPokemonModifier * opponentBaseExp * opponent.getLevel()) / (5 * expShare)) * (Math.pow((2 * opponent.getLevel()), 2.5) / Math.pow(opponent.getLevel() + level + 10, 2.5)) + 1) * trainerModifier * luckyEggModifier * oPowerModifier);
		} else {
			exp += (int) ((opponentPokemonModifier * trainerModifier * opponentBaseExp * luckyEggModifier * opponent.getLevel() * oPowerModifier * affectionModifier * isPastEvolutionModifier) / (7 * expShare));
		}
	}
	
	public void heal() { //TODO: Finish this when movesets gets introduced
		hp = stats.get(PokemonStats.HP);
		condition = StatusConditions.NORMAL;
	}
	
	public int compareTo(Pokemon compare) {
		if (this.getpId() == compare.getpId() && this.getGender().equals(compare.getGender()) && this.getNickName().equals(compare.getNickName()) && this.iv.equals(compare.getIv())) {
			return 0;
		} else if (this.pokemon.getPokedexId() < compare.getData().getPokedexId()) {
			return -1;
		}
		return 1;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Pokemon) {
			Pokemon poke = (Pokemon) o;
			if (this.getpId() == poke.getpId() && this.getTrainerSid() == poke.getTrainerSid()) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "Pokemon ID: " + pId + "\nID: " + pokemon.getId() + "\nName: " + pokemon.getName() + " " + gender.getGender() + "\nNickname: " + nickName + "\nLevel: " + level + "\nHp: " + hp + "\nStats: " + stats.toString() + "\nIv: " + iv.toString() + "\nEv: " + 
				ev.toString() + "\nHidden Ability: " + hasHiddenAbility() + "\nHappiness: " + happiness + "\nShiny: " + isShiny + "\nLegendary: " + isLegendary() + "\nGrowthRate: " + pokemon.getGrowthRate();
	}

	public enum Markings {
		Circle("●", (byte) 0x1),
		Square("■", (byte) 0x2),
		Triangle("▲", (byte) 0x4),
		Heart("♥", (byte) 0x8);
		
		private String marking;
		private byte value;
		
		private Markings(String marking, byte value) {
			this.marking = marking;
			this.value = value;
		}
		
		public String getMarking() {
			return marking;
		}
		
		public byte getValue() {
			return value;
		}
		
	}
	
}