package bai4_student;

import java.util.Scanner;

public class Student {
	static String name;
	static int age;
	static float math, literature;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên: ");
		name = sc.nextLine();
		System.out.print("Nhập tuổi: ");
		age = sc.nextInt();
		System.out.print("Nhập điểm môn toán: ");
		math = sc.nextFloat();
		System.out.print("Nhập điểm môn văn: ");
		literature = sc.nextFloat();
	}

	public void displayResult() {
		System.out.print("Kết quả là: " + ((math*2 + literature)/3 >= 5 ? "Đậu" : "Rớt"));
	}
	
	public static void main(String[] args) {
		Student st = new Student();
		st.input();
		st.displayResult();
	}
}
