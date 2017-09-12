import java.util.Scanner;

public class HW1_2 {

	public static void main(String[] args) 
	{
		int sec, min, hour;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input time (seconds)");
		sec = sc.nextInt();
		
		hour = sec/3600;
		if(hour<1)
		{
			min = sec/60;
			sec = sec - min*60;
		}
		else
		{
			sec = sec-hour*3600;
			min = sec/60;
			sec = sec - min*60;
		}
		System.out.println(hour+"hr."+min+"min"+sec+"sec");
	}

}
