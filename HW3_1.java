import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HW3_1 {

	public static void main(String[] args) 
	{
		   System.out.println("Please input n");
		   int n;
		   double sum = 0;
		   Scanner sc1 = new Scanner(System.in);
		         n=sc1.nextInt();	   
		      int[] x = new int[n];
              int[] y = new int[n];
              for(int i = 0 ; i<x.length ;i++)
              {
            	  Scanner sc2 = new Scanner(System.in);
            	  System.out.println("Please input x");
            	  x[i] = sc2.nextInt();
            	  System.out.println("Please input y");
              	  y[i] = sc2.nextInt();
              	  sum += Math.pow((double)(x[i]+y[i]),2);           	  
              }
              
              System.out.print(Arrays.toString(x));
              System.out.println();
              System.out.print(Arrays.toString(y));
              System.out.println();
              System.out.println(sum);           
	}

}
