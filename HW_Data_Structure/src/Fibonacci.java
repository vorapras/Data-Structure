
public class Fibonacci {

	public static int fibo(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibo(n - 1) + fibo(n - 2);
	}

	public static void main(String[] args) {

		for (int i = 1; i < 100; i++) {
			double a = fibo(i);
			double b = fibo(i + 1);
			double c = b / a;
			System.out.println(c);
		}
	}
}
