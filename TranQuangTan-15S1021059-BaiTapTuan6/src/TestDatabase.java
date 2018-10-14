import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Student;

public class TestDatabase {
	Connection connection;
	ResultSet rs;
	
	public Connection getConnection() {
		connection = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?useUnicode=yes&characterEncoding=UTF-8","root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("get connection not found");
			return null;
		} catch (SQLException e) {
			System.out.println("get connection sql exception");
			return null;
		}
		return connection;
	}
	
	public void closeConnection() {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("close exception");
		}
	}
	
	public ArrayList<Student> readAll() {
		try {
			connection = getConnection();
			ArrayList<Student> list = new ArrayList<>();
			rs = connection.createStatement().executeQuery("SELECT * FROM Student");
			while (rs.next()) {
				Student student = new Student();
				student.setCode(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setGender(rs.getInt(3));
				list.add(student);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				rs.close();
				closeConnection();
			} catch (SQLException e) {
				
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ArrayList<Student> listStudents = new TestDatabase().readAll();
		System.out.println("--------------------------------------------");
		System.out.println("| Mã SV |      Họ và Tên       | Giới tính |");
		System.out.println("--------+----------------------+------------");
		for (Student s : listStudents) {
			System.out.printf("| %5d | %20s | %9d |%n", s.getCode(), s.getName(), s.getGender());
		}
		System.out.print("--------------------------------------------");
	}
}
