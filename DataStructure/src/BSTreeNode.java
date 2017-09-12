import java.awt.Color;
import java.awt.Graphics;

public class BSTreeNode 
{
	public int data; // Node to store integer
	public BSTreeNode left; // Pointer to the left position
	public BSTreeNode right; // Pointer to the right position
	
	public BSTreeNode() //In JAVA, it does not need to do that but it is a must in C++ (Constructor)
	{
		data = 0;
		left = null; // Left Node is null
		right = null; // Right Node is null 
	}
	
	public BSTreeNode(int x) // Constructor with integer x
	{
		this(); // Call the above constructor
		data = x; // let data = x
	}
	
	public void draw(Graphics g,int x,int y,int num_x)
	{
		g.setColor(Color.green);
		g.fillOval(x-15, y-15, 30, 30);
		g.setColor(Color.black);
		g.drawString(""+data, x, y);
		//g.drawString(""+num_x, x, y-20);
	}
}
