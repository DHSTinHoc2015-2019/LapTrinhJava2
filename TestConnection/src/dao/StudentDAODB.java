package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.DBUtility;
import utility.Student;

public class StudentDAODB {
	Connection con;
	ResultSet rs;
	ArrayList<Student> list = new ArrayList<Student>();

	public ArrayList<Student> getList() {
		return list;
	}

	public void setList(ArrayList<Student> list) {
		this.list = list;
	}

	DBUtility dbu = new DBUtility();

	public void readAll() {
		list = new ArrayList<Student>();
		con = dbu.openConnection();

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

		dbu.closeConnection();
	}

	public void update(Student st) {
		con = dbu.openConnection();
		
		PreparedStatement pst = null;
		//Cho phép truyền câu lệnh SQL có tham số vào
		try {
			pst = con.prepareStatement("UPDATE Student SET Name = ?, Gender = ? WHERE Code = ?");
			pst.setString(1, st.getName());
			pst.setInt(2, st.getGender());
			pst.setInt(3, st.getCode());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Lỗi update");
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

	public static void main(String[] args) {
		StudentDAODB dao = new StudentDAODB();
		
		Student s = new Student(2, "Nguyễn A", 1);
		dao.update(s);
		dao.readAll();
		ArrayList<Student> listStudent = dao.getList();

		for (int i = 0; i < listStudent.size(); i++) {
			Student st = listStudent.get(i);
			System.out.println(st.getCode() + "\t" + st.getName() + "\t" + st.getGender());
		}
		
		
	}
}
