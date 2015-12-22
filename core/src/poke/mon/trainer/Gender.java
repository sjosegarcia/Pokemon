package poke.mon.trainer;

public enum Gender {
	UNKNOWN("?"), MALE("♂"), FEMALE("♀"), GENDERLESS("");
	
	private String gender;
	
	private Gender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
	
}
