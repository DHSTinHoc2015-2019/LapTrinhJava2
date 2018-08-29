package bai2_rectangle;

import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		System.out.println("Nhập chiều dài:");
		Scanner sc = new Scanner(System.in);
		int chieuDai = sc.nextInt();
		System.out.println("Nhập chiều rộng:");
		int chieuRong = sc.nextInt();
		
		System.out.println("Chu vi là: " + (chieuDai + chieuRong) * 2);
		System.out.println("Diện tích là: " + (chieuDai * chieuRong));
	}

}
