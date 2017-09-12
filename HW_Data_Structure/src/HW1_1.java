import java.util.Scanner;

public class HW1_1 {

	public static void main(String[] args) {
		double a,b,c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number");
		a = sc.nextDouble();
		System.out.println("Please input power");
		b = sc.nextDouble();
		c = Math.pow(a, b);
		System.out.println(c);
		
	}

}
