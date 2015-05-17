package poke.mon.evolution;

public enum Conditions {
	UNKNOWN("Unknown"), 
	LEVEL("Level"), 
	ITEM("Item"), 
	LOCATION("Location"),
	Day("HappinessDay"),
	Night("HappinessNight");
	
	String condition;
	private Conditions(String condition) {
		this.condition = condition;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public Conditions getConditionbyName(String condition) {
		for (Conditions condi : Conditions.values()) {
			if (condi.getCondition().equalsIgnoreCase(condition)) {
				return condi;
			}
		}
		return Conditions.UNKNOWN;
	}
}