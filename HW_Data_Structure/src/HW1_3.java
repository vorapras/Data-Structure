import java.util.Scanner;

public class HW1_3 {

	public static void main(String[] args)
	{
		double baht, dollar,yen,yuan;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input total amount of Thai bath");
		baht = sc.nextDouble();
        dollar = baht/35.29;
        yen = baht*100/35.265;
        yuan = baht/5.53425;
        
        System.out.println(dollar+"$\t"+yen+"JPY\t"+yuan+"CNY\t");

	}

}
