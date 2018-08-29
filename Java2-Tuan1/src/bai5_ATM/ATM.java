package bai5_ATM;

import java.util.Scanner;

public class ATM {
	public static String ID;
	public static int balance, amount;
	Scanner sc = new Scanner(System.in);
	
	public  void input() {
		System.out.print("Nhập ID: ");
		ID = sc.nextLine();
		System.out.print("Nhập số dư: ");
		balance = sc.nextInt();
	}
	
	public void withdraw() {
		System.out.print("Nhập số tiền muốn rút: ");
		amount = sc.nextInt();
		if(amount <= balance) balance = balance - amount;
		else System.out.println("Lỗi");
	}
	
	public void displayBalance() {
		System.out.println("Số dư còn lại: " + balance);
	}
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.input();
		atm.withdraw();
		atm.displayBalance();
	}

}
