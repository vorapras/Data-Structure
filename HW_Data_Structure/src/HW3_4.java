import java.util.Scanner;

public class HW3_4 {

	public static void main(String[] args) 
	{
		int[][] A = new int[3][4];
		int[][] B = new int[3][4];
		int[][] C = new int[3][4];
		//Input A
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please input numbers for Matrix A");
				A[i][j] = sc.nextInt();
			}
		}
		
		//Input B
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please input numbers for Matrix B");
				B[i][j] = sc.nextInt();
			}
		}
		
		//Plus
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				C[i][j]=A[i][j]+B[i][j] ;
			}
		}
		
		//Print 
		System.out.println("Matrix Result =");
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[0].length; j++) {
				System.out.print(C[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
