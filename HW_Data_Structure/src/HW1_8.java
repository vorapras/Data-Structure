import java.util.Arrays;
import java.util.Scanner;

public class HW1_8 {

	public static void main(String[] args) 
	{
		int[][] A = new int[4][4];
		
		Scanner sc = new Scanner(System.in);
		
		// input for A
		for (int j = 0; j < A[0].length; j++)
		{
			for (int i = 0; i < A.length; i++)
			{
				System.out.println("Please input number of type "+i+" work hours in the "+(j+1)+" week");
				A[i][j] = sc.nextInt();
			}
		}
		System.out.println(Arrays.toString(A));

	}

}
