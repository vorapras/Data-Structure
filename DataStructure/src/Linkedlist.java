import java.awt.Color;
import java.awt.Graphics;
import java.security.InvalidParameterException;

public class Linkedlist <T>
{
	
	public Node<T> header; // dummy head node
	public int size; // size of LinkedList
	
	public Linkedlist() //Constructor
	{	
		header = new Node<T>(); // Create new Node with header
		size = 0; // Set size = 0 at the beginning
	}
	
	public void addFirst(T x)  // addFirst O(1), addLast O(n)
	{
		Node<T> n = new Node<T>(x); // Create new node first and input x in the node
		n.next = header.next; // Point from header.next to n.next (same position)
		header.next = n;
		size++;//increase size more
	}
	
	public void addLast(T x)  // addFirst O(1), addLast O(n)
	{
		Node<T> n = new Node<T>(x);
		Node<T> p = header; // Let p = header position
		while(p.next != null) // As long as there is a number in the next array
		{
			p = p.next; // Shift back p[i] = p[i+1] until p[i+1/last] = null
		}
		p.next = n; // Then p[last] = x with node n
		size++; // increase size more
	}
	
	public void insert(T x,int index)
	{
		int i =0 ;
		Node<T> p = header;
		while(p.next != null && i < index)
		{
			p = p.next;
			i++;
		}
		Node<T> m = p.next;
		p.next = new Node<T>();
		p.next.data = x;
		p.next.next = m;		
	}
	
	public boolean isContain(T t)
	{
		Node<T> p = header; // Let p = header position
		while(p.next != null) // As long as there is a number in the next array
		{
			
			p = p.next; // Shift back p[i] = p[i+1] until p[i+1/last] = null
			if(p.data.equals(t))
			{
				return true;
			}
		}
		return false;
	}
	
	public void removeAt(int index)
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		
		int i= 0;
		Node<T> p = header;
		while(p.next != null && i < index)
		{
			p = p.next; // Shift backward p[i] = p[i+1] until the chosen index
			i++;
		}
		p.next = p.next.next; // Pointer will point to the next of the next pointer and then the Garbage Collector will remove number in between automatically
	}
		
	
	public T get(int index) 
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		
		int i= 0;
		Node<T> p = header;
		while(p.next != null && i <= index) // must equal index to get number
		{
			p = p.next; // Shift backward p[i] = p[i+1] until the chosen index
			i++;
		}
		return  p.data;
	}
	
	public void draw(Graphics g)
	{
		int i = 0;
		Node<T> n = header;
		while(n != null) // As long as there is a number in the array
		{
		    i++;
			g.setColor(Color.PINK);
			g.fillOval(i*50+50, 200, 30, 30); //(far from left,far from above,width size of circle,height size of circle)
			
			g.setColor(Color.BLACK);
			g.drawString(""+n.data, i*50+50+20,220);//(String data,far from previous left + a little bit move,far from above + a little bit move)
			
			g.drawLine(i*50+50+30, 215, i*50+50+50, 215); // draw straight line
			
			g.drawLine(i*50+50+40, 215-10, i*50+50+50, 215); // draw adjacent line
			g.drawLine(i*50+50+40, 215+10, i*50+50+50, 215); // draw adjacent line
			
			n=n.next;
	     }
	}
	
	public void draw(Graphics g,int y_offset)
	{
		int i = 0;
		Node<T> n = header;
		while(n != null) // As long as there is a number in the array
		{
		    i++;
		    
			g.setColor(Color.PINK);
			g.fillOval(i*50+50, y_offset, 30, 30); //(far from left,far from above,width size of circle,height size of circle)
			
			g.setColor(Color.BLACK);
			g.drawString(""+n.data, i*50+50+20,20 + y_offset);//(String data,far from previous left + a little bit move,far from above + a little bit move)			
			g.drawLine(i*50+50+30, 15 + y_offset, i*50+50+50, 15 + y_offset); // draw straight line
			
			g.drawLine(i*50+50+40, 15-10 + y_offset, i*50+50+50, 15 + y_offset); // draw adjacent line
			g.drawLine(i*50+50+40, 15+10 + y_offset, i*50+50+50, 15 + y_offset); // draw adjacent line
			
			n=n.next;
	     }
	}
}
