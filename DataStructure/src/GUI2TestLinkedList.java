import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI2TestLinkedList extends JPanel
{
	Linkedlist ll = new Linkedlist();
	public GUI2TestLinkedList() // Constructor
    {
		for(int i = 0 ; i < 2 ; i++)
		{
			ll.addFirst(i);
		}
		ll.addFirst(5);
		ll.addLast(500);
		
		ll.removeAt(ll.size-1);
		ll.insert(99, 2);
		
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
    	new GUI2TestLinkedList(); // show it
    }
}
