import java.util.Scanner;

public class ConvertInfixToPostFix 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] ss = s.split(" "); // Split input
		String result = "";
		Stack<String> stack = new Stack<String>();
		String top;
	    int index_top;
	    int index_new;
		
		String order = ")^*/+-(";
		
		for (int i = 0; i < ss.length; i++) 
		{
			if (ss[i].equals("+") || ss[i].equals("-") || ss[i].equals("*") || ss[i].equals("/") || ss[i].equals("^") ) 
			{
				if(stack.size() == 0)
				{
					stack.push(ss[i]);
				}
				else
				{
					top = stack.top();
					index_top = order.indexOf(top);
					index_new = order.indexOf(ss[i]);
					if(index_new < index_top)
					{
						stack.push(ss[i]);
					}
					else
					{
						String operator = stack.pop();
						result = result + " " + operator;
						if(stack.size() > 0)
						{
						top = stack.top();
					    index_top = order.indexOf(top);
						index_new = order.indexOf(ss[i]);
						while(index_new >= index_top)
						{
							operator = stack.pop();
							result = result + " " + operator;
							if(stack.size() > 0)
							{
							top = stack.top();
						    index_top = order.indexOf(top);
							index_new = order.indexOf(ss[i]);
							}
							else
							{
								break;
							}
						}
					}
						stack.push(ss[i]);
					}
				}
			} else if (ss[i].equals("("))
			    {
				       stack.push(ss[i]);
			    }
		      else if (ss[i].equals(")"))
			    {
					String operator = stack.pop();
					while(!operator.equals("("))
					{
						result = result + " " + operator;
						operator = stack.pop();
					}
				}
		      else 
			    {
					result = result + " " + Integer.parseInt(ss[i]);
				}
			     System.out.println(stack);
			     System.out.println(result);
			}  

		while(stack.size() > 0)
		{
			String operator = stack.pop();
			result = result + " " + operator;
		}
		System.out.println(result);
	}
}
