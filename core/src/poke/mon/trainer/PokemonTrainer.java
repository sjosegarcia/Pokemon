package poke.mon.trainer;

import java.util.Random;

import poke.mon.life.PlayerRenderer;

public class PokemonTrainer extends PlayerRenderer {

	private PokemonParty party;
	private int id;
	private long sId = 0xFFFFFFFFL;
	private long money;
	private Gender gender = Gender.UNKNOWN;
	private PokemonPokedex pokedex = null;
	private String name;
	private Random rand = new Random();
	
	
	public PokemonTrainer(String player) {
		super(player);
		this.id = rand.nextInt(65536);
		this.sId = rand.nextInt() & sId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public void givePokedex() {
		this.pokedex = new PokemonPokedex();
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

	public long getSid() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}
	
	public boolean gainMoney(long money) {
		if (this.money > Long.MAX_VALUE || money > Long.MAX_VALUE || money < Long.MIN_VALUE) {
			return false;
		}
		if ((this.money - money) <= 0) {
			this.money = 0;
			return true;
		}
		if ((this.money + money) >= Long.MAX_VALUE) {
			this.money = Long.MAX_VALUE;
			return true;
		}
		if (money < 0) {
			this.money-=money;
		}
		if (money > 0) {
			this.money+=money;
		}
		return true;
	}
}