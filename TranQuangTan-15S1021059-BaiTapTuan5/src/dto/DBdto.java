package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBdto {
	Connection con;
	
	public Connection openConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src/data/test.db");
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi Class not found");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Lỗi SQL");
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("Lỗi SQL");
			System.out.println(e.getMessage());
		}
	}
}
