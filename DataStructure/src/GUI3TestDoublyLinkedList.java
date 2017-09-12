import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI3TestDoublyLinkedList extends JPanel
{
	DoublyLinkedlist ll = new DoublyLinkedlist();
	public GUI3TestDoublyLinkedList() // Constructor
    {
		for(int i = 0 ; i < 20 ; i++)
		{
			ll.addLast(i);
		}
		ll.addFirst(5);
		ll.addLast(500);
		
		ll.removeAt(ll.size-1);
		System.out.println(ll.get(ll.size-5));
		
    	JFrame f  = new JFrame(); // Get panel and post 
    	f.add(this); // paste ourself
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setSize(500, 500);
    	f.setVisible(true);
    }
    
    public void paint(Graphics g)
    {
    	super.paint(g); // Call JPanel to draw new background
			ll.draw(g);
    }
    
    public static void main(String [] args)
    {
    	new GUI3TestDoublyLinkedList(); // show it
    }
}
