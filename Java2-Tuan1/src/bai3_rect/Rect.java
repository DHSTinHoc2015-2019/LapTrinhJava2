package bai3_rect;

import java.util.Scanner;

public class Rect {
	static int width, height;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập chiều dài:");
		height = sc.nextInt();
		System.out.print("Nhập chiều cao:");
		width = sc.nextInt();
	}

	public void display(){
		System.out.println("Chiều dài:" + height);
		System.out.println("Chiều cao:" + width);
		System.out.println("Chu vi là: " + (height + width) * 2);
		System.out.println("Diện tích là: " + (height * width));
	}
	public static void main(String[] args) {
		Rect rect = new Rect();
		rect.input();
		rect.display();
	}
}
