import java.awt.Graphics;

public class MyQueue<T>
{
   DoublyLinkedlist<T> list ;
   public MyQueue() //Constructor
   {
	   list = new DoublyLinkedlist<T>();
   }
   
   public void enqueue(T x) // Input data
   {
	   list.addFirst(x); // O(1)
   }
   
   public T dequeue() // Remove data
   {
	   T t = list.get(list.size-1);
	   list.removeAt(list.size-1);
	   return t;
   }
   
   public T peek() // Pick up the last information but no remove
   {
	   T t = list.get(list.size-1);
	   return t;
   }
   
   public int size()
   {
	   return list.size;
   }
   
   public void draw(Graphics g)
   {
	   for(int i = 0 ; i < list.size; i++) // draw loop number of image equal to size of data
	   {
	   g.drawRect( 250+40*i, 300, 40, 40); // draw rectangle from bottom up
	   g.drawString(""+list.get(i), 250+40*i+10, 330); // input number in the rectangle
	   }
   }
}
