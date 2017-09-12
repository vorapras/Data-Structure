import java.util.Arrays;
import java.util.Scanner;

public class HW3_2 {

	public static void main(String[] args) 
	{
		    double sum = 0;
		    double avg = 0;
		    int index = 0;
		    String[] name = new String[20];
            double[] score = new double[20];
            for(int i = 0 ; i<name.length ;i++)
            {
          	  Scanner sc = new Scanner(System.in);
          	  System.out.println("Please input name");
          	  name[i] = sc.nextLine();
          	 System.out.println("Please input score");
          	  score[i] = sc.nextDouble();
          	  
          	  if(score[i]<50)
          	  {
          		 index = i;
          	  }
          	  sum +=score[i];          	  	  
            }
            avg = sum / 20;
            
            System.out.print(Arrays.toString(name));
            System.out.println();
            System.out.print(Arrays.toString(score));
            System.out.println();
            System.out.println(avg);  
            System.out.println("Students below 50 = "+name[index]+"\t"+score[index]); 

	}

}
