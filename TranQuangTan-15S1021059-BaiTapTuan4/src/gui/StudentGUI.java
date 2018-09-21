package gui;

import java.awt.EventQueue;
import java.awt.Font;
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

public class StudentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSV;
	private JTextField txtHoTen;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JButton btnXoa;
	private JTable tblSinhVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGUI frame = new StudentGUI();
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
	public StudentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 125, 179, 114, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblMSv = new JLabel("Mã SV");
		lblMSv.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblMSv = new GridBagConstraints();
		gbc_lblMSv.insets = new Insets(0, 0, 5, 5);
		gbc_lblMSv.anchor = GridBagConstraints.EAST;
		gbc_lblMSv.gridx = 0;
		gbc_lblMSv.gridy = 1;
		contentPane.add(lblMSv, gbc_lblMSv);

		txtMaSV = new JTextField();
		txtMaSV.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_txtMaSV = new GridBagConstraints();
		gbc_txtMaSV.insets = new Insets(0, 0, 5, 5);
		gbc_txtMaSV.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaSV.gridx = 1;
		gbc_txtMaSV.gridy = 1;
		contentPane.add(txtMaSV, gbc_txtMaSV);
		txtMaSV.setColumns(10);

		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblHTn = new GridBagConstraints();
		gbc_lblHTn.anchor = GridBagConstraints.EAST;
		gbc_lblHTn.insets = new Insets(0, 0, 5, 5);
		gbc_lblHTn.gridx = 0;
		gbc_lblHTn.gridy = 2;
		contentPane.add(lblHTn, gbc_lblHTn);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_txtHoTen = new GridBagConstraints();
		gbc_txtHoTen.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoTen.gridx = 1;
		gbc_txtHoTen.gridy = 2;
		contentPane.add(txtHoTen, gbc_txtHoTen);
		txtHoTen.setColumns(10);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblGioiTinh = new GridBagConstraints();
		gbc_lblGioiTinh.anchor = GridBagConstraints.EAST;
		gbc_lblGioiTinh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGioiTinh.gridx = 0;
		gbc_lblGioiTinh.gridy = 3;
		contentPane.add(lblGioiTinh, gbc_lblGioiTinh);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student st;
				if (!txtHoTen.getText().isEmpty()) {
					if (rdbtnNam.isSelected()) {
						st = new Student(dao.maxCode() + 1, txtHoTen.getText(), 1);
					} else {
						st = new Student(dao.maxCode() + 1, txtHoTen.getText(), 0);
					}
					dao.create(st);
					dao.writeAll();
					JOptionPane.showMessageDialog(null, dao.getError(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					loadData();
					loadForm();
				} else {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập họ tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		rdbtnNam = new JRadioButton("Nam");
		GridBagConstraints gbc_rdbtnNam = new GridBagConstraints();
		gbc_rdbtnNam.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNam.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNam.gridx = 1;
		gbc_rdbtnNam.gridy = 3;
		contentPane.add(rdbtnNam, gbc_rdbtnNam);

		btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadForm();
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnHuy = new GridBagConstraints();
		gbc_btnHuy.insets = new Insets(0, 0, 5, 0);
		gbc_btnHuy.gridx = 2;
		gbc_btnHuy.gridy = 3;
		contentPane.add(btnHuy, gbc_btnHuy);

		rdbtnNu = new JRadioButton("Nữ");
		GridBagConstraints gbc_rdbtnNu = new GridBagConstraints();
		gbc_rdbtnNu.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNu.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNu.gridx = 1;
		gbc_rdbtnNu.gridy = 4;
		contentPane.add(rdbtnNu, gbc_rdbtnNu);

		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnThem = new GridBagConstraints();
		gbc_btnThem.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem.gridx = 0;
		gbc_btnThem.gridy = 5;
		contentPane.add(btnThem, gbc_btnThem);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st;
				if (!txtHoTen.getText().isEmpty()) {
					if (rdbtnNam.isSelected()) {
						st = new Student(Integer.parseInt(txtMaSV.getText()), txtHoTen.getText(), 1);
					} else {
						st = new Student(Integer.parseInt(txtMaSV.getText()), txtHoTen.getText(), 0);
					}
					if (dao.update(st)) {
						dao.writeAll();
						JOptionPane.showMessageDialog(null, dao.getError(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, dao.getError(), "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					loadData();
					loadForm();
				} else {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập họ tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnCapNhat = new GridBagConstraints();
		gbc_btnCapNhat.insets = new Insets(0, 0, 5, 5);
		gbc_btnCapNhat.gridx = 1;
		gbc_btnCapNhat.gridy = 5;
		contentPane.add(btnCapNhat, gbc_btnCapNhat);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dao.delete(Integer.parseInt(txtMaSV.getText()))) {
					dao.writeAll();
					JOptionPane.showMessageDialog(null, dao.getError(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					loadData();
					loadForm();
				}else {
					JOptionPane.showMessageDialog(null, dao.getError(), "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnXoa = new GridBagConstraints();
		gbc_btnXoa.insets = new Insets(0, 0, 5, 0);
		gbc_btnXoa.gridx = 2;
		gbc_btnXoa.gridy = 5;
		contentPane.add(btnXoa, gbc_btnXoa);

		tblSinhVien = new JTable();
		tblSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblSinhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(model.getRowCount() > 0) {
					enable1(false);
					int hang = tblSinhVien.getSelectedRow();
					
					txtMaSV.setText(String.valueOf(model.getValueAt(hang, 0)));
					txtHoTen.setText(String.valueOf(model.getValueAt(hang, 1)));
					if (Integer.parseInt(String.valueOf(model.getValueAt(hang, 2))) == 1) {
						rdbtnNam.setSelected(true);
					} else {
						rdbtnNu.setSelected(true);
					}
				}
			}
		});

		GridBagConstraints gbc_tblSinhVien = new GridBagConstraints();
		gbc_tblSinhVien.gridwidth = 3;
		gbc_tblSinhVien.fill = GridBagConstraints.BOTH;
		gbc_tblSinhVien.gridx = 0;
		gbc_tblSinhVien.gridy = 7;
		contentPane.add(tblSinhVien, gbc_tblSinhVien);

		loadData();
		loadForm();
	}

	StudentDAO dao = new StudentDAO();
	ArrayList<Student> data = new ArrayList<Student>();
	StudentTableModel model = new StudentTableModel();
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private ButtonGroup btnGroup = new ButtonGroup();
	private JButton btnHuy;

	void loadData() {
		dao.readAll();
		// Gán arraylist của form = araylist của dao
		data = dao.getList();
		model.setData(data);
		tblSinhVien.setModel(model);
	}

	void loadForm() {
		btnGroup.add(rdbtnNam);
		btnGroup.add(rdbtnNu);
		txtMaSV.setEditable(false);
		rdbtnNam.setSelected(true);
		txtMaSV.setText("");
		txtHoTen.setText("");
		enable1(true);
	}

	void enable1(boolean b) {
		btnCapNhat.setEnabled(!b);
		btnXoa.setEnabled(!b);
		btnHuy.setEnabled(!b);
		btnThem.setEnabled(b);
	}
}
