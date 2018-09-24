package utility;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	Connection con;
	
	public Connection openConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Student.db");
		} catch (ClassNotFoundException e) {
			System.out.println("Loi Class not found");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Loi SQL");
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Loi SQL");
			System.out.println(e.getMessage());
		}
	}
}
