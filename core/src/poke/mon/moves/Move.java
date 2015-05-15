package poke.mon.moves;

public class Move {
	
	private int id;
	private String name;
	private String description;
	private int accuracy;
	private int damage;
	private DamageCategories damageType;
	
	public Move() {
		//Got to create the constructor
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public DamageCategories getDamageType() {
		return damageType;
	}
	public void setDamageType(DamageCategories damageType) {
		this.damageType = damageType;
	}
}
