import java.awt.Graphics;
import java.lang.reflect.Array;

/*
 * Separate Chain Hashing
 */
public class Hash<T>
{
  int size ;
  int capacity ;
  Linkedlist<T>[] data;

public Hash()
  {
	  size = 0;
	  capacity = 13;
//	  data = (Linkedlist<T>[])(new Object[capacity]);
	  data = (Linkedlist<T>[])Array.newInstance(Linkedlist.class, capacity);
  }
  
  public int hashFunction(T t)
  {
	  return t.hashCode() % capacity;
  }
  
  public void add(T t)
  {
	  int hc = hashFunction(t);
	  if(data[hc] == null)
	  {
		  data[hc] = new Linkedlist<T>();
	  }
	  data[hc].addFirst(t);
  }
  
  public boolean isContain(T t)
  {
	  int hc = hashFunction(t);
	  if(data[hc] == null)
	  {
		  return false;
	  }
	  return data[hc].isContain(t);
  }
  
  public void draw(Graphics g)
  {
	  for(int i = 0 ; i < data.length ; i++)
	  {
		  if(data[i] != null)
		  {
			  data[i].draw(g,i*50);
		  }
	  }
  }
  
}
