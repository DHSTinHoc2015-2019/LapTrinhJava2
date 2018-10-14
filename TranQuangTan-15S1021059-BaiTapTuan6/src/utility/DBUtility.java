package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	// Gõ connection xong bấm ctrl-space để import
	Connection con;
	
	// Mở kết nối với CSDL
	public Connection openConnection() {
		try {
			//Class.forName("org.sqlite.JDBC");
			//con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BIM10-SAGER\\Desktop\\test.db");
			//mySQL
			Class.forName("com.mysql.jdbc.Driver");
			//Có dạng jdbc:mysql://<ip server>/<tên CSDL>?user=<tên người dùng>&password=<mật khẩu>&useSSL=false
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?useUnicode=yes&characterEncoding=UTF-8","root", "");
		} catch (ClassNotFoundException e) {
			// Xử lý ngoại lệ
			System.out.println("Lỗi class not found");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Lỗi SQL");
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	// Đóng kết nối sau khi xử lý xong
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Lỗi SQL");
			System.out.println(e.getMessage());
		}
	}
	
	
}
