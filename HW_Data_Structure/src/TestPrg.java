
public class TestPrg 
{
	public static void xx(int m)
	{
		int[] d = new int[10000019];
		long start = System.currentTimeMillis();
		for(int k = 0; k < 50 ; k++)
		{
			int j = 0;
			for(int a, i=0; i < d.length ;i++ )
			{
				a = d[j];
				j = (j+m)%d.length;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	public static void main(String[] args) 
	{
		for(int i = 0; i <= 20; i++)
		{
			xx((int)Math.pow(2, i));
		}
	}

}
