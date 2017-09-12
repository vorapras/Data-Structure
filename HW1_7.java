import java.util.Scanner;

public class HW1_7 {

	public static void main(String[] args) 
	{
		int[] a = new int[10];
		System.out.println("Please input number of ages for 20 persons");
		
		int count15=0;
		int count20=0;
		int count40=0;
		int count60=0;
		int countOld=0;
		
		for(int i =0 ; i<a.length ;i++)
		{
		Scanner sc = new Scanner(System.in);
		a[i] = sc.nextInt();
		     if(a[i]<15)
		     {
		    	 count15++;
		     }
		     else if(a[i]<=20)
		     {
		    	 count20++;
		     }
		     else if(a[i]<=40)
		     {
		    	 count40++;
		     }
		     else if(a[i]<=60)
		     {
		    	 count60++;
		     }
		     else
		     {
		    	 countOld++;
		     }	    		  
		}
		System.out.println("วัยเด็กอายุน้อยกว่า 15 ปี\t\t" + count15 + "\tคน");
		System.out.println("วัยรุ่นอายุมากกว่าและเท่ากับ 15 ปี ถึง 20 ป๊ \t" + count20 + "\tคน");
		System.out.println("วัยผู้ใหญ่ตอนต้นอายุมากกว่าและเท่ากับ 20 ปี ถึง 40 ป๊\t" + count40 + "\tคน");
		System.out.println("วัยกลางคนอายุมากกว่า 40 ปี ถึง 60 ป๊\t\t" + count60 + "\tคน");
		System.out.println("วัยชราอายุมากกว่า 60 ปี\t\t" + countOld + "\tคน");
	
	}

}
