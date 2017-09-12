import java.security.InvalidParameterException;
import java.util.Arrays;

public class MyArrayList 
{
	private int[] data; // Array to store integer
	private int size;   // size of array now

	public MyArrayList()  // constructor
	{
		size = 0;
		data = new int[10];
	}

	public void add(int x) 
	{
		if (size >= data.length)  // check whether it is full or not
		{
			int[] data2 = new int[data.length * 2]; // create and expand size of original array for 2 times
			for (int i = 0; i < data.length; i++) 
			{
				data2[i] = data[i]; // Copy previous information and paste into new array
			}
			data = data2; //The previous array will be removed by garbage collector
		}
		data[size] = x; // add x in the last index of array
		size++;  // increase size to know that how many array.lenghth right now
	}

	public int get(int index) 
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		return data[index];
	}
	
	public void set(int x, int index)
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		       data[index] = x; // Set x in array
	}
	
	public int [] toArray() // Transform MyArrayList to array
	{
		int [] x = new int[size]; // Create new array that has exactly the same size after adding numbers 
		for (int i = 0; i < size; i++) 
		{
			x[i] = data[i]; // Copy previous information and paste into new array
		}
		return x; // return array
	}
	
	public String toString()
	{
		int [] x = toArray(); // Call method toArray with x array to show numbers in array
		return Arrays.toString(x); // change into String data
	}
}
