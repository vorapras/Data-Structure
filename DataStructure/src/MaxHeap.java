import java.util.Comparator;

public class MaxHeap <T>
{
  private T[] data;
  private int size;
  private Comparator<T> comparator;
  public MaxHeap(Comparator<T> xcomparator)
  {
	  data = (T[])new Object[50];
	  size = 0;
	  comparator = xcomparator;
  }
  
  public int getParentIndex(int index)
  {
	  return (index-1) / 2;
  }
  
  public int getChildIndex1(int index)
  {
	  return index * 2 + 1;
  }
  
  public int getChildIndex2(int index)
  {
	  return index * 2 + 2;
  }
  
  public void swap(int i , int j)
  {
	  T t = data[i];
	  data[i] = data[j];
	  data[j] = t;
  }
  public void add(T x)
  {
	  data[size] = x;
	  size++;
	  int n = size - 1;
	  int p = getParentIndex(n);
	  while(n > 0 && comparator.compare(data[p], x) < 0)
	  {
		  swap(n, p);
		  n = p;
		  p = getParentIndex(n);
	  }
  }
  
  public void print()
  {
	  System.out.println();
	  for(int i = 0 ; i < size ; i++)
	  {
		  System.out.print(data[i]+"\t");
	  }
  }
  
  public int size()
  {
	  return size;
  }
  
  public T getMax()
  {
	  T t = data[0];
	  size--;
	  int n = size ;
	  data[0] = data[n];
	  n = 0;
	 
	  
	  while(true)
	  { 
		  int l = getChildIndex1(n);
	      int r = getChildIndex2(n);
	      
		  if(l < size)
		  {
			  if(r < size)
			  {
				  int k = 0;
				  if(comparator.compare(data[l], data[r]) > 0)
				  {
					  k = l;
				  }
				  else
				  {
					  k = r;
				  }
				  if(comparator.compare(data[k], data[n]) > 0)
				  {
					  swap(n, k);
					  n = k;
				  }
				  else
				  {
					  break;
				  }
			  }
			  else
			  {
				  if(comparator.compare(data[n], data[l]) < 0)
				  {
					  swap(n, l);
					  n = l;
				  }
				  else
				  {
					  break;
				  }
			  }			  
		  }
		  else
		  {
			  break;
		  }
	  }
	  
	  return t;
  }
  
  public T getMaxNotRemove()
  {
	  return data[0];
  }
}
