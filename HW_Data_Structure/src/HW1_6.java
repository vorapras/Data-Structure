import java.util.Arrays;
import java.util.Scanner;

public class HW1_6 {

	public static void main(String[] args) 
	{
		int[] a = new int[20];
		int sum=0;
		System.out.println("Please input score numbers for 20 students");
		
		int countF=0;
		int countD=0;
		int countDplus=0;
		int countC=0;
		int countCplus=0;
		int countB=0;
		int countBplus=0;
		int countA=0;
		
		for(int i =0 ; i<a.length ;i++)
		{
		Scanner sc = new Scanner(System.in);
		a[i] = sc.nextInt();
		     if(a[i]<50)
		     {
		    	 countF++;
		     }
		     else if(a[i]<=54)
		     {
		    	 countD++;
		     }
		     else if(a[i]<=59)
		     {
		    	 countDplus++;
		     }
		     else if(a[i]<=64)
		     {
		    	 countC++;
		     }
		     else if(a[i]<=69)
		     {
		    	 countCplus++;
		     }
		     else if(a[i]<=74)
		     {
		    	 countB++;
		     }
		     else if(a[i]<=79)
		     {
		    	 countBplus++;
		     }
		     else
		     {
		    	 countA++;
		     }	    
		    	sum+=a[i];
		  
		}
		System.out.println("เกรด A\t" + countA + "\tคน");
		System.out.println("เกรด B\t+" + countBplus + "\tคน");
		System.out.println("เกรด B\t" + countB + "\tคน");
		System.out.println("เกรด C+\t" + countCplus + "\tคน");
		System.out.println("เกรด C\t" + countC + "\tคน");
		System.out.println("เกรด D+\t" + countDplus + "\tคน");
		System.out.println("เกรด D\t" + countD + "\tคน");
		System.out.println("เกรด F\t" + countF + "\tคน");
		System.out.println();
		double avg;
		avg = (double)sum/(double)a.length;
	     if(avg<50)
	     {
	    	 System.out.println("ค่าคะแนนเฉลี่ยอยู่ที่เกรด F");
	     }
	     else if(avg<=54)
	     {
	    	 System.out.println("ค่าคะแนนเฉลี่ยอยู่ที่เกรด D");
	     }
	     else if(avg<=59)
	     {
	    	 System.out.println("ค่าคะแนนเฉลี่ยอยู่่ที่เกรด D+");
	     }
	     else if(avg<=64)
	     {
	    	 System.out.println("ค่าคะแนนเฉลี่ยอยู่ที่เกรด C");
	     }
	     else if(avg<=69)
	     {
	    	 System.out.println("ค่าคะแนนเฉลี่ยอยู่่ที่เกรด C+");
	     }
	     else if(avg<=74)
	     {
	    	 System.out.println("ค่าคะแนนเฉลี่ยอยู่่ที่เกรด B");
	     }
	     else if(avg<=79)
	     {
	    	 System.out.println("ค่าคะแนนเฉลี่ยอยู่่ที่เกรด B+");
	     }
	     else
	     {
	    	 System.out.println("ค่าคะแนนเฉลี่ยอยู่่ที่เกรด A");
	     }

	}

}
