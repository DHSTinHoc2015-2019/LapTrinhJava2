import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		PatientDAO patient = new PatientDAO();
		Scanner sc = new Scanner(System.in);
		int chon = 0, code = -1, index = -1;
		do {
			System.out.println("------------------------");
			System.out.println("          MENU");
			System.out.println("1. Thêm thông tin bênh nhân ");
			System.out.println("2. Xóa thông tin bệnh nhân");
			System.out.println("3. Cập nhật tên bệnh nhân");
			System.out.println("4. Sắp xếp danh sách bệnh nhân");
			System.out.println("5. Hiển thị danh sách bệnh nhân");
			System.out.println("6. Đếm số bệnh nhân của một khoa");
			System.out.println("7. Thoát chương trình");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				System.out.println("THÊM BỆNH NHÂN:");
				patient.list.add(patient.add());
				patient.write();
				break;
			case 2:
				System.out.println("XÓA THÔNG TIN BỆNH NHÂN");
				System.out.print("Nhập mã bệnh nhân bạn muốn xóa: ");
				code = sc.nextInt();
				index = patient.findIndex(code);
				if(index == -1){
					System.out.println("Không tìm thấy mã bệnh nhân: " + code);
				}else{
					if(patient.remove(index)){
						System.out.println("Xóa thành công bệnh nhân có mã: " + code);
					}else{
						System.out.println("Xóa thông tin thất bại");
					}
				}
				break;
			case 3:
				System.out.println("CẬP NHẬT TÊN BỆNH NHÂN");
				System.out.print("Nhập mã bệnh nhân bạn muốn cập nhật: ");
				code = sc.nextInt();
				index = patient.findIndex(code);
				if(index == -1){
					System.out.println("Không tìm thấy mã bệnh nhân: " + code);
				}else{
					System.out.println("Tên hiện tại của bênh nhân có mã " + code + "là: " + patient.list.get(index).getName());
					System.out.println("Nhập vào tên mới: ");
					String name = sc.nextLine();
					if(patient.update(index, name)){
						System.out.println("Cập nhật thông tin thành công");
					}else{
						System.out.println("Cập nhật thông tin thất bại");
					}
				}
				break;
			case 4:
				System.out.println("SẮP XẾP DANH SÁCH BỆNH NHÂN");
				if(patient.sort()){
					System.out.println("Sắp xếp danh sách thành công");
				}else{
					System.out.println("Sắp xếp danh sách thất bại");
				}
				break;
			case 5:
				System.out.println("DANH SÁCH BỆNH NHÂN");
				patient.display();
				break;
			case 6:
				System.out.println("ĐẾM SỐ BỆNH NHÂN CỦA MỘT KHOA");
				System.out.print("Nhập tên khoa: ");
				String department = sc.nextLine();
				if(patient.countPatientInDepartment(department) == 0){
					System.out.println("Không có bệnh nhân nào thuộc khoa " + department);
				}else{
					System.out.println("Số bệnh nhân thuộc khoa " + department + " : ");
				}
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Giá trị bạn chọn không có trong danh sách.");
				System.out.println("Vui lòng chọn lại các số từ 1 - 7");
				break;
			}
		} while (chon != 7);
	}
}