import java.awt.Graphics;

public class Stack<T>
{
   private MyArrayListOfT<T> data; 
   
   public Stack()   // Constructor
   {
	   data = new MyArrayListOfT<T>(); 
   }
   
   public void push(T x) // Insert X in data with any kind of object
   {
	   data.add(x); // O(1)
   }
   
   public T pop()   // Show the top data and delete
   {
	  T t = data.get(data.size()-1);  // get top data // O(1)
	   data.removeAt(data.size()-1);  // remove the top data  // O(1)
	   return t;
   }
   
   public T top() // Show the top data and  not delete
   {
	   T t = data.get(data.size()-1);  // get top data // O(1)
	   return t;

   }
   
   public int size()
   {
	   return data.size();
   }
   
   public void draw(Graphics g)
   {
	   for(int i = 0 ; i < data.size(); i++) // draw loop number of image equal to size of data
	   {
	   g.drawRect(50, 500-40*i, 40, 40); // draw rectangle from bottom up
	   g.drawString(""+data.get(i), 60, 500-40*i+30); // input number in the rectangle
	   }
   }
   
   public String toString()
   {
	   return data.toString();
   }
}
