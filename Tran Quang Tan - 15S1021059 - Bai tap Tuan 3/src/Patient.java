import java.util.Comparator;

public class Patient {
	private int code;
	private String name;
	private String department;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Patient(){
		code = 0;
		name = department = "";
	}
	
	public Patient(int code, String name, String department){
		this.code = code;
		this.name = name;
		this.department = department;
	}
}

class NameComparator implements Comparator<Patient> {

	@Override
	public int compare(Patient o1, Patient o2) {
		return o1.getName().compareTo(o2.getName());
	}
}	