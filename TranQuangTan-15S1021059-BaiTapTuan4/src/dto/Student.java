package dto;

public class Student {
	int code;
	String name;
	int gender;

	public static final int GENDER_MALE = 0, GENDER_FEMALE = 1;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Student(int code, String name, int gender) {
		super();
		this.code = code;
		this.name = name;
		this.gender = gender;
	}
}
