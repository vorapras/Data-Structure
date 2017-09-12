
public class BinarySearch 
{
   public static int binarySearch(int[] a, int x)
   {
	   int left = 0, right = a.length-1;
	   int mid = (left+right)/2;
	   while(true)
	   {
		   if(a[mid] == x)
		   {
			   return mid;
		   }
		   if(a[mid] > x)
		   {
			   right = mid-1;
		   }
		   else
		   {
			   left = mid+1;
		   }
		   if(right < left)
		   {
			   return -1;
		   }
		   mid = (left+right)/2;
	   }
   }
   public static void main(String[] args) 
	{
	   int [] arr = {1,2,3,4,5,6,7,8,9};
	   int index;
	   index = binarySearch(arr,3);
	   System.out.println(index);
	}
}
