package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dto.Student;

public class StudentDAO {
	ArrayList<Student> list = new ArrayList<Student>();
	String error = "";

	public ArrayList<Student> getList() {
		return list;
	}

	public void setList(ArrayList<Student> list) {
		this.list = list;
	}

	public void create(Student s) {
		list.add(s);
		setError("Thêm mới thành công!");
	}

	public boolean readAll() {
		list = new ArrayList<Student>();
		BufferedReader reader = null;
		String s = "";
		try {
			reader = new BufferedReader(new FileReader("src/data/Student.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		try {
			while ((s = reader.readLine()) != null) {
				int code = Integer.parseInt(s.split(",")[0]);
				String name = s.split(",")[1];
				int gender = Integer.parseInt(s.split(",")[2]);
				Student student = new Student(code, name, gender);
				list.add(student);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		setError("Đọc dữ liệu từ file thành công!");
		return true;
	}

	public boolean update(Student s) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == s.getCode()) {
				list.set(i, s);
				setError("Cập nhật thành công!");
				return true;
			}
		}
		setError("Không tìm thấy sinh viên!");
		return false;
	}

	public boolean delete(int code) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == code) {
				list.remove(i);
				setError("Xóa thành công!");
				return true;
			}
		}
		setError("Không tìm thấy sinh viên!");
		return false;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void display() {
		for (Student s : list) {
			System.out.println(s.getCode() + " " + s.getName() + " " + s.getGender());
		}
	}

	public void writeAll() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("src/data/Student.txt"));
			for (Student st : list) {
				writer.write(st.getCode() + ",");
				writer.write(st.getName() + ",");
				writer.write(st.getGender() + System.lineSeparator());
			}
			writer.close();
		} catch (NumberFormatException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int maxCode() {
		int max = 0;
		for(Student st : list) {
			if(st.getCode() > max) max = st.getCode();
		}
		return max;
	}
}
