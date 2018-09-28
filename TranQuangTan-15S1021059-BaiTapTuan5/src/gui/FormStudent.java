package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.StudentDAO;
import dao.StudentTableModel;
import dto.Student;

public class FormStudent extends JFrame {

	private JPanel contentPane;
	private JTable tblStudents;
	private JTextField txtCode;
	private JTextField txtName;
	private JLabel lblName;
	private JLabel lblGender;
	private JRadioButton rdbMale;
	private JRadioButton rdbFemale;
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private final ButtonGroup btgGender = new ButtonGroup();

	StudentDAO dao = new StudentDAO();
	ArrayList<Student> data = new ArrayList<Student>();
	StudentTableModel model = new StudentTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormStudent frame = new FormStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblCode = new JLabel("M\u00E3 SV");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 0;
		contentPane.add(lblCode, gbc_lblCode);

		txtCode = new JTextField();
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.gridx = 1;
		gbc_txtCode.gridy = 0;
		contentPane.add(txtCode, gbc_txtCode);
		txtCode.setColumns(10);

		lblName = new JLabel("H\u1ECD v\u00E0 T\u00EAn");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		contentPane.add(lblName, gbc_lblName);

		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		contentPane.add(txtName, gbc_txtName);
		txtName.setColumns(10);

		lblGender = new JLabel("Gi\u1EDBi T\u00EDnh");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 2;
		contentPane.add(lblGender, gbc_lblGender);

		rdbMale = new JRadioButton("Nam");
		btgGender.add(rdbMale);
		GridBagConstraints gbc_rdbMale = new GridBagConstraints();
		gbc_rdbMale.insets = new Insets(0, 0, 5, 5);
		gbc_rdbMale.gridx = 1;
		gbc_rdbMale.gridy = 2;
		contentPane.add(rdbMale, gbc_rdbMale);

		rdbFemale = new JRadioButton("N\u1EEF");
		btgGender.add(rdbFemale);
		GridBagConstraints gbc_rdbFemale = new GridBagConstraints();
		gbc_rdbFemale.insets = new Insets(0, 0, 5, 0);
		gbc_rdbFemale.gridx = 2;
		gbc_rdbFemale.gridy = 2;
		contentPane.add(rdbFemale, gbc_rdbFemale);

		btnCreate = new JButton("Th\u00EAm m\u1EDBi");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreate.gridx = 0;
		gbc_btnCreate.gridy = 3;
		contentPane.add(btnCreate, gbc_btnCreate);

		btnUpdate = new JButton("C\u1EADp nh\u1EADt");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 1;
		gbc_btnUpdate.gridy = 3;
		contentPane.add(btnUpdate, gbc_btnUpdate);

		btnDelete = new JButton("X\u00F3a");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 3;
		contentPane.add(btnDelete, gbc_btnDelete);

		tblStudents = new JTable();
		tblStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblStudentsMouseClicked(e);
			}
		});
		GridBagConstraints gbc_tblStudents = new GridBagConstraints();
		gbc_tblStudents.gridwidth = 3;
		gbc_tblStudents.fill = GridBagConstraints.BOTH;
		gbc_tblStudents.gridx = 0;
		gbc_tblStudents.gridy = 4;
		contentPane.add(tblStudents, gbc_tblStudents);

		// Comment 2 dòng sau khi cần chỉnh sửa giao diện
		// Bỏ comment khi chạy chương trình
		dao.readAll();
		loadData();
	}

	// Đưa dữ liệu từ DAO vào giao diện
	void loadData() {

		// Gán arraylist của form = arraylist của dao
		data = dao.getList();
		// Đưa dữ liệu vào model
		model.setData(data);
		// Đưa model vào bảng
		tblStudents.setModel(model);
	}

	// Đặt hàm mới để xử lý sự kiện click bảng, hàm này sẽ được gọi trong hàm tạo
	void tblStudentsMouseClicked(MouseEvent e) {
		// Lấy chỉ số dòng đang được chọn
		int index = tblStudents.getSelectedRow();
		// Lấy ra phần tử có thứ tự tương ứng với chỉ số dòng
		Student student = data.get(index);

		// Đưa dữ liệu từ đối tượng student vào các control
		txtCode.setText(String.valueOf(student.getCode()));
		txtName.setText(student.getName());

		// Tùy vào giới tính của SV mà chọn rdbMale hoặc rdbFemale
		if (student.getGender() == 0) {
			rdbMale.setSelected(true);
		} else {
			rdbFemale.setSelected(true);
		}
	}

	// Sự kiện cho nút Thêm
	void btnCreateActionPerformed(ActionEvent e) {
		int code = 0;
		try {
			code  = Integer.parseInt(txtCode.getText());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Nhập dữ liệu không đúng định dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String name = txtName.getText();
		// Viết tắt
		int gender = rdbMale.isSelected() ? 0 : 1;

		// Tạo đối tượng Student mới
		Student student = new Student(code, name, gender);

		// Gọi hàm create của dao đưa đối tượng student vào arraylist của dao
		if (dao.create(student)) {
			JOptionPane.showMessageDialog(null, dao.getError(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, dao.getError(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}

		// Viết hàm lưu

		// Hiển thị lại dữ liệu / Refresh lại bảng
		loadData();
	}

	// Nút cập nhật
	void btnUpdateActionPerformed(ActionEvent e) {
		int code = Integer.parseInt(txtCode.getText());
		String name = txtName.getText();
		// Viết tắt
		int gender = rdbMale.isSelected() ? 0 : 1;

		// Tạo đối tượng Student mới
		Student student = new Student(code, name, gender);

		if (dao.update(student)) {
			JOptionPane.showMessageDialog(null, dao.getError(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, dao.getError(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}

		loadData();
	}

	// Nút xóa
	void btnDeleteActionPerformed(ActionEvent e) {
		try {
			int code = Integer.parseInt(txtCode.getText());
			if (dao.delete(code)) {
				JOptionPane.showMessageDialog(null, dao.getError(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, dao.getError(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Xóa không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}

		loadData();
	}
}
