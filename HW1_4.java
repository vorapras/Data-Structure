import java.util.Arrays;
import java.util.Scanner;

public class HW1_4 {

	public static void main(String[] args) 
	{
		int[] a = new int[20];
		int sum=0;
		System.out.println("Please input 20 numbers");
		
		for(int i =0 ; i<a.length ;i++)
		{
		Scanner sc = new Scanner(System.in);
		a[i] = sc.nextInt();
		    if(a[i]%2==0)
		    {
		    	sum+=a[i];
		    }
		}
		System.out.println(Arrays.toString(a));
		System.out.println(sum);
	}
}
