package dao;

import entity.Product;

public interface ProductInterface {
	
	//nhập thông tin về một sản phẩm mới từ bàn phím, giá trị trả lại là sản phẩm vừa nhập
	public abstract Product add();
	
	//hiển thị các thuộc tính id, name và giá trị cost (công thức cost = quantity * price) trên cùng 1 dòng
	public abstract void display(Product p);
	
	//trả lại cost của tất cả sản phẩm có trong danh sách có kích cỡ là n
	public float getTotal(Product[] list, int n);
	
	//trả lại chỉ số của sản phẩm có id giống với id trong tham số từ danh sách n sản phẩm, nếu không tìm thấy trả lại giá trị -1
	public int findProduct(Product[] list, int n, int id);
	
	//cập nhật quantity và price của sản phẩm có id giống với id trong tham số từ danh sách n sản phẩm, 
	//các giá trị mới của quantity và price nhập từ bàn phím, nếu không tìm ra sản phẩm cần cập nhật trả lại giá tị false
	public boolean update(int id, Product[] list, int n);
}
