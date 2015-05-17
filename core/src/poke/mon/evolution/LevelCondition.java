package poke.mon.evolution;

public class LevelCondition extends EvolutionConditions {

	private int level;
	
	public LevelCondition(int level) {
		setCondition(Conditions.LEVEL);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}	
}
