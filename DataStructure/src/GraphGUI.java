import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphGUI extends JPanel
{
	GraphAdjList<Integer> gg;
	public GraphGUI() // Constructor
    {
		gg = new GraphAdjList<Integer>();
		
//		for(int i = 0 ; i < 30 ; i++)
//		{
//			gg.addNode(i);
//		}
//		
//		for(int i = 0 ; i < 90 ; i++)
//		{
//			int a = (int)(Math.random()*31);
//			int b = (int)(Math.random()*31);
//			if(a != b)
//			{
//				gg.addEdge(a,b,1);
//			}
//		}
			
		gg.addNode(1);
		gg.addNode(2);
		gg.addNode(3);
		gg.addNode(4);
		gg.addNode(5);
		gg.addNode(6);
		gg.addNode(7);
		gg.addNode(8);
		gg.addNode(9);
		gg.addNode(10);
		
		gg.addEdge(1, 2, 1);
		gg.addEdge(2, 3, 1);
		gg.addEdge(3, 1, 1.44);
		gg.addEdge(3, 4, 0.5);
		gg.addEdge(5, 4, 0.5);
		gg.addEdge(2, 4, 8.5);
		
		gg.addEdge(6, 4, 1);
		gg.addEdge(7, 4, 1);
		gg.addEdge(8, 4, 1);
		gg.addEdge(6, 7, 1);
		gg.addEdge(7, 8, 1);
		gg.addEdge(8, 9, 1);
		gg.addEdge(9, 10,1);
		gg.addEdge(10, 7,1);
		
	Thread t = new Thread(new Runnable()
	{
		
		@Override
		public void run() 
		{
		    while(true)
		    {
		    	try 
		    	{
					Thread.sleep(20);
				} 
		    	catch (InterruptedException e) 
		    	{
					e.printStackTrace();
				}
		    	gg.updatePos(getWidth(),getHeight());
		    	repaint();
		    }			
		}
	});
		t.start();
		
		JFrame f  = new JFrame();// Get panel and post 
    	f.add(this); // paste ourself
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setSize(500, 500);
    	f.setVisible(true);
    }
    
    public void paint(Graphics g)
    {
    	super.paint(g); // Call JPanel to draw new background
			gg.draw(g);
    }
    
    public static void main(String [] args)
    {
    	new GraphGUI(); // show it
    }
}
