
public class MaxSubSum {

	// Version 1 BigO N^3
	public static int mss1(int[] a) {
		int max = 0;
		// Start from i end with j
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				// Find Max Sum
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum = sum + a[i];
				}
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	// Version 2 BigO N^2
	public static int mss2(int[] a) {
		int max = 0;
		// Start from i end with j
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				// Find Max Sum
				sum = sum + a[i];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}
	
	// Version 3 BigO N^1
		public static int mss3(int[] a) 
		{
			int max = 0;
			int sum = 0;
			for (int i = 0; i < a.length; i++) 
			{
					sum = sum + a[i];
					if (sum < 0) {  // Null Array is better than negative sum
						sum = 0;
					}
					if(sum>max){
						max=sum;
					}
			}
			return max;
		}	
		
		
		public static void main(String[] args) {
			int n = 10000;
			
			int [] a = new int [n];
			for(int i = 0; i<n ;i++)
			{
				a[i] = (int)(Math.random()*n-n/2);
			}
			//
			long x1,x2;
			x1 = System.currentTimeMillis();
			int m1 = mss1(a);
			x2 = System.currentTimeMillis();
			System.out.println("O(n^3) : "+m1+" "+(x2-x1));
			
			//
			for(int i = 0; i<n ;i++)
			{
				a[i] = (int)(Math.random()*n-n/2);
			}
			long x3,x4;
			x3 = System.currentTimeMillis();
			int m2 = mss2(a);
			x4 = System.currentTimeMillis();
			System.out.println("O(n^2) : "+m2+" "+(x4-x3));
			
			//
			for(int i = 0; i<n ;i++)
			{
				a[i] = (int)(Math.random()*n-n/2);
			}
			long x5,x6;
			x5 = System.currentTimeMillis();
			int m3 = mss3(a);
			x6 = System.currentTimeMillis();
			System.out.println("O(n) : "+m3+" "+(x6-x5));
		}
}
