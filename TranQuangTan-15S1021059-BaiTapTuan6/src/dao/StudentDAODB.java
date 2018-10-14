package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Student;
import utility.DBUtility;

public class StudentDAODB {
	Connection con;
	ResultSet rs;
	ArrayList<Student> list = new ArrayList<Student>();
	DBUtility dbu = new DBUtility();
	String error = "";

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public ArrayList<Student> getList() {
		return list;
	}

	public void setList(ArrayList<Student> list) {
		this.list = list;
	}
	
	public void readAll() {
		list = new ArrayList<Student>();
		con = dbu.openConnection();

		try {
//			rs = con.createStatement().executeQuery("SELECT * FROM student");
			rs = con.createStatement().executeQuery("CALL DanhSachSinhVien()");
			// Chừng nào resultset vẫn còn kết quả
			while (rs.next()) {
				// Đọc từ result set vào 1 đối tượng student
				Student s = new Student();
				s.setCode(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setGender(rs.getInt(3));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dbu.closeConnection();
	}

	public boolean update(Student s) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == s.getCode()) {
				con = dbu.openConnection();
				// Chuẩn bị 1 prepared statement
				// Cho phép dùng câu lệnh SQL có truyền tham số vào
				PreparedStatement pst = null;
				try {
					list.set(i, s);
//					pst = con.prepareStatement("UPDATE Student SET Name = ?, Gender = ? WHERE Code = ?");
					pst = con.prepareStatement("CALL sp_update_student(?,?,?)");
					pst.setString(1, s.getName());
					pst.setInt(2, s.getGender());
					pst.setInt(3, s.getCode());
					pst.executeUpdate();
					dbu.closeConnection();
					setError("Cập nhật thành công!");
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					setError("Lỗi cập nhật");
					e.printStackTrace();
				}
				dbu.closeConnection();
			}
		}
		return false;
	}
	
	public boolean create(Student st) {
		con = dbu.openConnection();
		PreparedStatement pst = null;
		// Cho phép truyền câu lệnh SQL có tham số vào
		try {			
			//pst = con.prepareStatement("INSERT INTO Student VALUES (?, ?, ?)");
			pst = con.prepareStatement("CALL sp_create_student(?,?,?)");
			pst.setString(2, st.getName());
			pst.setInt(3, st.getGender());
			pst.setInt(1, st.getCode());
			pst.executeUpdate();
			dbu.closeConnection();
			list.add(st);
			setError("Thêm thành công!");
			return true;
		} catch (SQLException e) {
			setError("Lỗi thêm dữ liệu");
			System.out.println(e.getMessage());
		}
		dbu.closeConnection();
		
		return false;
	}
	
	public boolean delete(int code) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode() == code) {

				con = dbu.openConnection();
				PreparedStatement pst = null;
				// Cho phép truyền câu lệnh SQL có tham số vào
				try {
//					pst = con.prepareStatement("DELETE FROM Student WHERE Code = ?");
					pst = con.prepareStatement("CALL sp_delete_student(?)");
					pst.setInt(1, code);
					pst.executeUpdate();
					dbu.closeConnection();
					setError("Xóa thành công!");
					list.remove(i);
					return true;
				} catch (SQLException e) {
					setError("Lỗi xóa dữ liệu");
					System.out.println(e.getMessage());
				}
				dbu.closeConnection();
			}
		}
		return false;
	}
}
