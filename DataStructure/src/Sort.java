import java.util.Arrays;

public class Sort {

	public static int[] BubbleSort(int[] a) {
		for (int j = 0; j < a.length - 1; j++) {
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					int t = a[i];
					a[i] = a[i + 1];
					a[i + 1] = t;
				}
			}
		}
		return a;

	}

	public static int[] SelectionSort(int[] a) {
		for (int j = 0; j < a.length; j++) {
			int last = a.length - j - 1;
			int max_index = 0;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= last; i++) {
				if (a[i] > max) {
					max = a[i];
					max_index = i;
				}
			}
			int t = a[last];
			a[last] = max;
			a[max_index] = t;
		}
		return a;
	}

	public static int[] InsertionSort(int[] a) {

		for (int i = 0; i < a.length; i++) 
		{
			int j;
			int temp = a[i];
			for (j = i - 1; j >= 0; j--) 
			{
				if (temp > a[j]) 
				{
					break;
				}
				a[j + 1] = a[j]; // shift
			}
			a[j + 1] = temp;
		}
		return a;
	}

	public static int[] MergeSort(int[] a, int l, int r) // l is starting point
															// of left hand
															// side, r
															// is starting point
															// of
															// right hand side
	{
		if (l == r) {
			return a;
		}
		int m = (l + r) / 2;
		MergeSort(a, l, m);
		MergeSort(a, m + 1, r);
		int[] b = new int[r - l + 1];
		int k = 0, i = l, j = m + 1;
		while (i <= m && j <= r) {
			if (a[i] < a[j]) {
				b[k] = a[i];
				k++;
				i++;
			} else {
				b[k] = a[j];
				k++;
				i++;
			}
		}
		while (i <= m) {
			b[k] = a[i];
			k++;
			i++;
		}
		while (j <= r) {
			b[k] = a[j];
			k++;
			j++;
		}
		for (k = 0; k < b.length; k++) {
			a[l + k] = b[k];
		}
		return a;
	}

	public static int[] QuickSort(int[] a, int l, int r) {
		if (l >= r) return a;
		int temp = a[l];
		int i = l;
		int j = r + 1;
		while (i < j) {
			do {
				j--;
			} while (temp < a[j]);
			i++;
			while (a[i] < temp) {
				if (i == r)
					break;
				i++;
			}
			if (i < j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}

		int t2 = a[j];
		a[j] = a[l];
		a[l] = t2;
		QuickSort(a, l, j - 1);
		QuickSort(a, j + 1, r);
		return a;
	}



	public static void main(String[] args) {

		int n = 20000;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = (int) (Math.random() * n - n / 2);
		}
		//
		long x1, x2;
		x1 = System.currentTimeMillis();
		int[] m1 = BubbleSort(a);
		x2 = System.currentTimeMillis();
		System.out.println("Bubble Sort : " + (x2 - x1));
//		System.out.println(Arrays.toString(m1));
		//
		for (int i = 0; i < n; i++) {
			a[i] = (int) (Math.random() * n - n / 2);
		}
		long x3, x4;
		x3 = System.currentTimeMillis();
		int[] m2 = SelectionSort(a);
		x4 = System.currentTimeMillis();
		System.out.println("Selection Sort : " + (x4 - x3));
//		System.out.println(Arrays.toString(m2));
		//
		for (int i = 0; i < n; i++) {
			a[i] = (int) (Math.random() * n - n / 2);
		}
		long x5, x6;
		x5 = System.currentTimeMillis();
		int[] m3 = InsertionSort(a);
		x6 = System.currentTimeMillis();
		System.out.println("Insertion Sort : " + (x6 - x5));
//		System.out.println(Arrays.toString(m3));
		//
		for (int i = 0; i < n; i++) {
			a[i] = (int) (Math.random() * n - n / 2);
		}
		long x7, x8;
		x7 = System.currentTimeMillis();
		int[] m4 = MergeSort(a, 0, n - 1);
		x8 = System.currentTimeMillis();
		System.out.println("Merge Sort : " + (x8 - x7));
//		System.out.println(Arrays.toString(m4));
		//
		for (int i = 0; i < n; i++) {
			a[i] = (int) (Math.random() * n - n / 2);
		}
		long x9, x10;
		x9 = System.currentTimeMillis();
		int[] m5 = QuickSort(a, 0, n - 1);
		x10 = System.currentTimeMillis();
		System.out.println("Quick Sort : " + (x10 - x9));
//		System.out.println(Arrays.toString(m5));
	}

}
