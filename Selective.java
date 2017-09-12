
public class Selective {

	public static void main(String[] args) {
		int n = 50;
		int i = 0;
		int k_max = 0;
		int max_count = 0;
		int[] count = new int[n];
        
		// Simulate 1000 times
		for (int l = 1; l < 1000; l++) 
		{
			// create n array and store
			int[] x = new int[n];
			for (i = 1; i <= n; i++) 
			{
				x[i-1] = i;
			}
			// swap number in array randomly
			for (i = 0; i < n * 100; i++) 
			{
				int a = (int) (Math.random() * n);
				int b = (int) (Math.random() * n);
				int t = x[a];
				x[a] = x[b];
				x[b] = t;
			}
            
			// Find maximum number in array
			for (int k = 1; k < n; k++) {
				int max = 0;
				for (i = 0; i < k; i++) {
					if (x[i] > max) {
						max = x[i];
					}
				}
				
           // Find that how many k to reach max and then store in count
				for (; i < n; i++) {
					if (x[i] > max) {
						if (x[i] == n) {
							count[k]++;
						}
						break;
					}
				}

			}
		}
          // Find k_max from count array
			for (i = 0; i < n; i++) {
				if (max_count < count[i]) {
					max_count = count[i];
					k_max = i;
				}
			}
			System.out.println(k_max);
		}
	}

