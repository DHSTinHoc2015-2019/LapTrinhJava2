package dao;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import dto.Student;

public class StudentTableModel extends AbstractTableModel {
	ArrayList<Student> students;
	String[] col = new String[] { "Mã SV", "Họ và Tên", "Giới tính" };

	// Số lượng cột = số lượng tên cột
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
	}

	// Số lượng dòng = số lượng phần tử của danh sách
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return students.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return students.get(rowIndex).getCode();
		case 1:
			return students.get(rowIndex).getName();
		case 2:
			return students.get(rowIndex).getGender();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return col[column];
	}

	public ArrayList<Student> getData() {
		return this.students;
	}

	public void setData(ArrayList<Student> list) {
		this.students = list;
		fireTableDataChanged();
	}
	
	// @Override
	// public void fireTableDataChanged() {
	// // TODO Auto-generated method stub
	// super.fireTableDataChanged();
	// }

}
