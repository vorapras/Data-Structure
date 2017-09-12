import java.util.Scanner;

public class CalculationPosfix 
{	
	public static void main(String[] args) 
	{
	  		Scanner sc = new Scanner(System.in);
	  		String s = sc.nextLine();
	  		String [] ss = s.split(" "); // Split input
	  		
	  		Stack<Integer> stack = new Stack<Integer>();
	  		
	  		for(int i = 0 ; i < ss.length ; i++)
	  		{
	  			if(ss[i].equals("+"))
	  			{
	  				int a = stack.pop();
	  				int b = stack.pop();
	  				int c = b+a ;
	  				stack.push(c);
	  				
	  			}
	  			else if(ss[i].equals("-"))
	  			{
	  				int a = stack.pop();
	  				int b = stack.pop();
	  				int c = b-a ;
	  				stack.push(c);
	  			}
	  			else if(ss[i].equals("*"))
	  			{
	  				int a = stack.pop();
	  				int b = stack.pop();
	  				int c = b*a ;
	  				stack.push(c);
	  			}
	  			else if(ss[i].equals("/"))
	  			{
	  				int a = stack.pop();
	  				int b = stack.pop();
	  				int c = b/a ;
	  				stack.push(c);
	  			}
	  			else
	  			{
	  				stack.push(Integer.parseInt(ss[i]));
	  			}	 
	  			System.out.println(stack);
	  		}
	      int result = stack.pop();
	      System.out.println(result);
	}
}
