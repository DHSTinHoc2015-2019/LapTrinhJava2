package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.DBdto;
import dto.Student;

public class StudentDAO {
	Connection con;
	ResultSet rs;
	String error = "";

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	ArrayList<Student> list = new ArrayList<Student>();

	public ArrayList<Student> getList() {
		return list;
	}

	public void setList(ArrayList<Student> list) {
		this.list = list;
	}

	DBdto db = new DBdto();

	public void readAll() {
		list = new ArrayList<Student>();
		con = db.openConnection();
		try {
			rs = con.createStatement().executeQuery("SELECT * FROM Student");
			// Chừng nào resultset vẫn còn kết quả
			while (rs.next()) {
				// Đọc từ result set vào một đối tượng student
				Student st = new Student();
				st.setCode(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setGender(rs.getInt(3));

				list.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.closeConnection();
	}

	public boolean update(Student st) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == st.getCode()) {

				con = db.openConnection();
				PreparedStatement pst = null;
				// Cho phép truyền câu lệnh SQL có tham số vào
				try {
					list.set(i, st);
					pst = con.prepareStatement("UPDATE Student SET Name = ?, Gender = ? WHERE Code = ?");
					pst.setString(1, st.getName());
					pst.setInt(2, st.getGender());
					pst.setInt(3, st.getCode());
					pst.executeUpdate();
					db.closeConnection();
					setError("Cập nhật thành công!");
					return true;
				} catch (SQLException e) {
					setError("Lỗi cập nhật");
					System.out.println(e.getMessage());
				}
				db.closeConnection();
			}
		}
		return false;
	}
	
	public boolean create(Student st) {
		con = db.openConnection();
		PreparedStatement pst = null;
		// Cho phép truyền câu lệnh SQL có tham số vào
		try {			
			pst = con.prepareStatement("INSERT INTO Student VALUES (?, ?, ?)");
			pst.setString(2, st.getName());
			pst.setInt(3, st.getGender());
			pst.setInt(1, st.getCode());
			pst.executeUpdate();
			db.closeConnection();
			list.add(st);
			setError("Thêm thành công!");
			return true;
		} catch (SQLException e) {
			setError("Lỗi thêm dữ liệu");
			System.out.println(e.getMessage());
		}
		db.closeConnection();
		
		return false;
	}
	
	public boolean delete(int code) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == code) {

				con = db.openConnection();
				PreparedStatement pst = null;
				// Cho phép truyền câu lệnh SQL có tham số vào
				try {
					pst = con.prepareStatement("DELETE FROM Student WHERE Code = ?");
					pst.setInt(1, code);
					pst.executeUpdate();
					db.closeConnection();
					setError("Xóa thành công!");
					list.remove(i);
					return true;
				} catch (SQLException e) {
					setError("Lỗi xóa dữ liệu");
					System.out.println(e.getMessage());
				}
				db.closeConnection();
			}
		}
		return false;
	}
}
