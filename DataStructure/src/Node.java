
public class Node<T> // Make it generic
{
	public T data; // Node to store integer
	public Node<T> next; // Pointer to the next position
	public Node<T> prev; // Pointer to the previous position (for doublylinkedlist)
	
	public Node() //In JAVA, it does not need to do that but it is a must in C++ (Constructor)
	{
		data = null;
		next = null; // Next Node is null
		prev = null; // Previous Node is null (for doublylinkedlist)
	}
	
	public Node(T x) // Constructor with integer x
	{
		this(); // Call the above constructor
		data = x; // let data = x
	}
}
