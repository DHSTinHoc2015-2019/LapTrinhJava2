package main;

import entity.Product;

import java.util.Scanner;

import dao.ProductDAO;

public class ProductManage {
	Product[] list;
	int n;
	int max;
	
	public ProductManage() {
		n = 0;
		max = 10;
		list = new Product[max];
		ProductDAO pDAO = new ProductDAO();
		
		System.out.println("THÊM SẢN PHẨM THỨ NHẤT");
		list[0] = pDAO.add();
		
		System.out.println("THÊM SẢN PHẨM THỨ HAI");
		do {
			list[++n] = pDAO.add();

			if(pDAO.findProduct(list, n - 1, list[n].getId()) != -1) {
				System.out.println("id sản phẩm đã tồn tại. Nhập lại thông tin sản phẩm thứ hai");
				n--;
			}else {
				break;
			}
		}
		while(true);

		System.out.println("THÊM SẢN PHẨM THỨ BA");
		do {
			list[++n] = pDAO.add();

			if(pDAO.findProduct(list, n - 1, list[n].getId()) != -1) {
				System.out.println("id sản phẩm đã tồn tại. Nhập lại thông tin sản phẩm thứ ba");
				n--;
			}else {
				break;
			}
		}
		while(true);
	}
	
	public static void main(String[] args) {
		
		ProductManage pManager= new ProductManage();
		
		ProductDAO pDAO = new ProductDAO();
		
		Scanner sc = new Scanner(System.in);
		
		int chon;
		
		do {
			System.out.println();
			System.out.println("------------MENU-----------");
			System.out.println("1. Thêm mới sản phẩm");
			System.out.println("2. Cập nhật thông tin sản phẩm");
			System.out.println("3. Hiển thị danh sách sản phẩm");
			System.out.println("4. Thoát chương trình");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				if(pManager.n + 1 < pManager.max) {
					System.out.println("THÊM SẢN PHẨM THỨ " + (pManager.n + 1));
					do {
						pManager.n++;
						pManager.list[pManager.n] = pDAO.add();
						if(pDAO.findProduct(pManager.list, pManager.n - 1, pManager.list[pManager.n].getId()) != -1) {
							System.out.println("id sản phẩm đã tồn tại. Nhập lại thông tin sản phẩm thứ " +  (pManager.n + 1));
							pManager.n--;
						}else {
							break;
						}						
					}
					while(true);
					System.out.println("Thêm thành công sản phẩm thứ " + (pManager.n + 1));
					pDAO.display(pManager.list[pManager.n]);
				}
				else {
					System.out.println("Danh sách sản phẩm đã đầy. Không thể thêm tiếp sản phẩm");
				}				
				break;
			case 2: 
				System.out.println("CẬP NHẬT THÔNG TIN SẢN PHẨM");
				System.out.print("Nhập vào id cần sửa: ");
				int id = sc.nextInt();
				int index = pDAO.findProduct(pManager.list, pManager.n, id);
				if(index != -1) {
					System.out.println("Cập nhật thông tin cho sản phẩm có id = " + id);
					pDAO.update(id, pManager.list, pManager.n);
					System.out.println("Cập nhật thông tin thành công");
					System.out.println("Thông tin sản phẩm thứ " + (index + 1));
					pDAO.display(pManager.list[index]);
				}else {
					System.out.println("Không tìm thấy id = " + id + " trong danh sách sản phẩm");
				}
				break;
			case 3: 
				System.out.println("DANH SÁCH SẢN PHẨM");
				for(int i = 0; i <= pManager.n; i++) {
					System.out.println("Sản phẩm thứ " + (i + 1));
					pDAO.display(pManager.list[i]);
				}
				break;
			case 4: 
				System.exit(0);
				break;
			default:
	            System.out.println("Giá trị bạn chọn không có trong danh sách.");
	            System.out.println("Vui lòng chọn lại các số từ 1 - 4");
	            break;
			}
		}
		while(chon != 4);
	}
}
