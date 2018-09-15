import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PatientDAO {
	ArrayList<Patient> list = new ArrayList<Patient>();
	BufferedWriter writer = null;
	BufferedReader reader = null;
	int code = 1;
	public PatientDAO(){
		try {
			reader = new BufferedReader(new FileReader("src/Patient.txt"));
			String s;
			while ((s = reader.readLine()) != null) {
				s = s.trim();
				if (!s.isEmpty()) {
					Patient p = new Patient();
					String [] arr = s.split("\t");
					p.setCode(Integer.parseInt(arr[0]));
					p.setName(arr[1]);
					p.setDepartment(arr[2]);
					list.add(p);
					code++;
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Patient add() {
		Patient p = new Patient();
		Scanner sc = new Scanner(System.in);
		p.setCode(code++);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Nhập họ tên:");
		p.setName(sc1.nextLine());
		System.out.println("Nhập khoa:");
		p.setDepartment(sc1.nextLine());
		return p;
	}

	public void write() {
		try {
			writer = new BufferedWriter(new FileWriter("src/Patient.txt"));
			for(Patient p : list){
				writer.write(p.getCode() + "\t");
				writer.write(p.getName() + "\t");
				writer.write(p.getDepartment() + "\t" + System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void display() {
		try {
			reader = new BufferedReader(new FileReader("src/Patient.txt"));
			String s;
			while ((s = reader.readLine()) != null) {
				s = s.trim();
				if (!s.isEmpty()) {
					System.out.println(s);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int findIndex(int code){
		int index = -1;
		for(int i = 0; i < list.size(); i++){
			if(code == list.get(i).getCode()){
				index = i; break;
			}
		}
		return index;
	}
	
	public boolean remove(int index){
		try {
			list.remove(index);
			write();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(int index, String name){
		try {
			list.get(index).setName(name);
			write();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean sort(){
		try {
			Collections.sort(list, new NameComparator());
			write();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int countPatientInDepartment(String department){
		int count = 0;
		for(int i = 0; i < list.size(); i++){
			if(department.equals(list.get(i).getDepartment())){
				count++;
			}
		}
		return count;
	}
}