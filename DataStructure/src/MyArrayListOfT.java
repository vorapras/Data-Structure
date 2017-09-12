import java.security.InvalidParameterException;
import java.util.Arrays;

public class MyArrayListOfT <T> // Make it generic (T is a symbol for any type of input)
{
	private T[] data; // Array to store integer
	private int size;   // size of array now

	public MyArrayListOfT()  // constructor
	{
		size = 0;
		data = (T[])(new Object[10]);
	}

	public void add(T x) 
	{
		if (size >= data.length)  // check whether it is full or not
		{
			T[] data2 = (T[])(new Object[data.length * 2]); // create and expand size of original array for 2 times
			for (int i = 0; i < data.length; i++) 
			{
				data2[i] = data[i]; // Copy previous information and paste into new array
			}
			data = data2; //The previous array will be removed by garbage collector
		}
		data[size] = x; // add x in the last index of array
		size++;  // increase size to know that how many array.lenghth right now
	}

	public T get(int index) 
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		return data[index];
	}
	
	public void set(T x, int index)
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		       data[index] = x; // Set x in array
	}
	
	public T [] toArray() // Transform MyArrayList to array
	{
		T[] x = (T[])(new Object[size]); // create new array that has exactly the same size after adding numbers 
		for (int i = 0; i < size; i++) 
		{
			x[i] = data[i]; // Copy previous information and paste into new array
		}
		return x; // return array
	}
	
	public String toString()
	{
		T [] x = toArray(); // Call method toArray with x array to show numbers in array
		return Arrays.toString(x); // change into String data
	}
	
	public int size()
	{
		return size; // Show size of the current ArrayList
	}
	
	public void removeAt(int index)
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		for(int i = index ; i < size - 1 ; i++) // remove start from index
		{
			data[i] = data[i+1];   // bring data[i+1] to store into data[i]
		}
		size--;
	}
}
