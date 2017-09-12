
public class Algo_Performance {

	public static void test1()
	{
		int i=0;
		int n=Integer.MAX_VALUE;
		String output = null;
		while(i<n)
		{
//			System.out.println("i = "+i);
			i++;
		}
	}
	
	public static void test2()
	{
		int i=0;
		int n=Integer.MAX_VALUE;
		String output = null;
		for(i = n; i>=0; i--)
		{
//			System.out.println("i = "+i);
		}
	}
	
	public static void test3(int[] theArray, int n)
	{
		int temp;
		for(int j=1; j<=n-1;++j)
		{
			int i=j+1;
			do{
				if(theArray[i] < theArray[j])
				{
					temp = theArray[i];
					theArray[i] = theArray[j];
					theArray[j] = temp;
				}
				++i;
			}while(i<=n);					
		}
	}
	
	public static void main(String[] args) 
	{
		long x1,x2;
		x1 = System.currentTimeMillis();
		test1();
		x2 = System.currentTimeMillis();
		System.out.println("test1 : "+(x2-x1));
		
		long x3,x4;
		x3 = System.currentTimeMillis();
		test2();
		x4 = System.currentTimeMillis();
		System.out.println("test2 : "+(x4-x3));
		
		long x6,x5;
		int n=Integer.MAX_VALUE;
		int[] a = new int[n];
		x5 = System.currentTimeMillis();
		test3(a,n);
		x6 = System.currentTimeMillis();
		System.out.println("test3 : "+(x6-x5));
		
	}

}
