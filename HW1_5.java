import java.util.Scanner;

import javax.swing.JOptionPane;

public class HW1_5 {

	public static void main(String[] args) {
		double pay, price;
		Scanner sc = new Scanner(System.in);
		System.out.println("จำนวนเงินที่ต้องจ่าย");
		price = sc.nextDouble();
		System.out.println("จำนวนเงินที่ลูกค้าจ่ายจริง");
		pay = sc.nextDouble();
		float x;
		x = (float)(pay - price);
		int y;
		y = (int) x / 1000;
		x = x % 1000;
		System.out.print("แบงค์ 1,000 บาท = " + y + "\n");

		y = (int) x / 500;
		x = x % 500;
		System.out.print("แบงค์   500 บาท = " + y + "\n");

		y = (int) x / 100;
		x = x % 100;
		System.out.print("แบงค์   100 บาท = " + y + "\n");

		y = (int) x / 50;
		x = x % 50;
		System.out.print("แบงค์    50 บาท = " + y + "\n");

		y = (int) x / 20;
		x = x % 20;
		System.out.print("แบงค์    20 บาท = " + y + "\n");

		y = (int) x / 10;
		x = x % 10;
		System.out.print("เหรียญ    10 บาท = " + y + "\n");

		y = (int) x / 5;
		x = x % 5;
		System.out.print("เหรียญ     5 บาท = " + y + "\n");

		y = (int) x / 1;
		x = x % 1;
		System.out.print("เหรียญ     1 บาท = " + y + "\n");

		x = (float) x * 100;
		y = (int) x / 50;
		x = x % 50;
		System.out.print("เหรียญ    50 สตางค์ = " + y + "\n");

		y = (int) x / 25;
		x = x % 25;
		System.out.print("เหรียญ    25 สตางค์ = " + y + "\n");
	}

}
