package dao;

import java.util.Scanner;

import entity.Product;

public class ProductDAO implements ProductInterface{

	@Override
	public Product add() {
		Product p = new Product();
		Scanner sc=new Scanner(System.in);

		System.out.print("Nhập id: ");
		p.setId(sc.nextInt());

		System.out.print("Nhập name: ");
		Scanner sc1=new Scanner(System.in);
		p.setName(sc1.nextLine());
		
		System.out.print("Nhập quantity: ");
		p.quantity = sc.nextInt();
		
		System.out.print("Nhập price: ");
		p.price = sc.nextFloat();
		return p;
	}

	@Override
	public void display(Product p) {
		System.out.print("id: " + p.getId() + "; ");
		System.out.print("name: " + p.getName() + "; ");
		System.out.println("cost: " + p.quantity * p.price);
		
	}

	@Override
	public float getTotal(Product[] list, int n) {
		int total = 0;
		for(int i = 0; i <= n; i++) {
			total += list[i].quantity * list[i].price;
		}
		return total;
	}

	@Override
	public int findProduct(Product[] list, int n, int id) {
		for(int i = 0; i <= n; i++) {
			if(list[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean update(int id, Product[] list, int n) {
		int index = findProduct(list, n, id);
		if(index == -1) return false;
		Scanner sc = new Scanner(System.in);
		System.out.print("Cập nhật quantity: ");
		list[index].quantity = sc.nextInt();
		System.out.print("Cập nhật price: ");
		list[index].price = sc.nextFloat();
		return true;
	}
}
