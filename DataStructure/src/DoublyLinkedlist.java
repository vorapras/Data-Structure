import java.awt.Color;
import java.awt.Graphics;
import java.security.InvalidParameterException;

public class DoublyLinkedlist<T> 
{
	
	public Node<T> header; // dummy head node
	public Node<T> tail; // dummy tail node
	public int size; // size of LinkedList
	
	public DoublyLinkedlist() //Constructor
	{	
		header = new Node<T>(); // Create new Node with header
		tail = new Node<T>(); // Create new Node with tail
		size = 0; // Set size = 0 at the beginning
		
		// Linked together
		header.next = tail; // Connect tail to header.next
		tail.prev = header ; // Connect header to tail.prev
	}
	
	public void addFirst(T x)  // addFirst O(1), addLast O(n)
	{
		Node<T> n = new Node(x); // Create new node first and input x in the node
		//For Header
		n.next = header.next; // Point from header.next to n.next (same position)
		header.next = n;
		//For Tail
		n.next.prev = n; // The same position
		n.prev = header;
		
		size++;//increase size more
	}
	
	public void addLast(T x)  // addFirst O(1), addLast O(n)
	{
		Node<T> n = new Node(x);
		//For Tail
		n.prev = tail.prev ;
		tail.prev = n;
		//For Header
		n.prev.next = n;
		n.next = tail;
		size++; // increase size more
	}
	
//	public void insert(int x,int index)
//	{
//		int i =0 ;
//		Node p = header;
//		while(p.next != null && i < index)
//		{
//			p = p.next;
//			i++;
//		}
//		Node m = p.next;
//		p.next = new Node();
//		p.next.data = x;
//		p.next.next = m;		
//	}
	
	public void removeAt(int index)
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		
		int i= 0;
		Node<T> p = header;
		while(p.next != tail && i < index)
		{
			p = p.next; // Shift backward p[i] = p[i+1] until the chosen index
			i++;
		}
		p.next = p.next.next; // Pointer will point to the next of the next pointer and then the Garbage Collector will remove number in between automatically
		p.next.prev = p;
		size--;
	}
		
	
	public T get(int index) 
	{
		if (index < 0 || index >= size) // last index = size -1 in array
		{
			throw new InvalidParameterException("index out of range : "+ index); // Is it out of range or not ?
		}
		//Loop from header
		if(index < size / 2)
		{
		int i= 0;
		Node<T> p = header;
		while(p.next != null && i <= index) // must equal index to get number
		{
			p = p.next; // Shift backward p[i] = p[i+1] until the chosen index
			i++;
		}
		return (T) p.data;
	 }
		//Loop from tail
		int i= size;
		Node<T> p = tail;
		while(p.prev != null && i != index) // must equal index to get number
		{
			p = p.prev; 
			i--;
		}
		return (T) p.data;
	}
		
	
	public void draw(Graphics g)
	{
		int i = 0;
		Node<T> n = header;
		while(n!=null) // As long as there is a number in the array
		{
			g.setColor(Color.PINK);
			g.fillOval(i*50+50, 200, 30, 30); //(far from left,far from above,width size of circle,height size of circle)
			
			g.setColor(Color.BLACK);
			g.drawString(""+n.data, i*50+50+7,220);//(String data,far from previous left + a little bit move,far from above + a little bit move)
			
			g.drawLine(i*50+50+30, 215, i*50+50+50, 215); // draw straight line
			
			g.drawLine(i*50+50+40, 215-10, i*50+50+50, 215); // draw adjacent line
			g.drawLine(i*50+50+40, 215+10, i*50+50+50, 215); // draw adjacent line
			
		    i++;
			n=n.next;
	     }
	}
}
