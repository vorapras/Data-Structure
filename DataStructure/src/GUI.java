import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel
{
	MyArrayListOfT<Particle> list = new MyArrayListOfT<Particle>(); // Create particle without limited numbers
    public GUI() // Constructor
    {
    	//Thread method is commonly used to separate working function
    	Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				while(true)
				{
					try 
					{
						Thread.sleep(50); // Stop for 50 millisecs
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					int n = (int)(Math.random() * 50); // Random numbers of particle
					
					for(int i = 0 ; i < n ; i++) // Add a number of particles to equal random numbers
					{
						list.add(new Particle());
					}
					
					for(int i = 0 ; i < list.size() ; i++) // move every particle
					{
						list.get(i).move();
					}
					
					for(int i = 0 ; i < list.size() ; i++) // move every particle
					{
						if( !list.get(i).isAlive() )
						{
							list.removeAt(i); // After removing, the size is also declined
							i--; // must be minus to avoid running to over next index
						}
					}
					
					repaint(); // draw new window again				
				}			
			}
		});
    	t.start(); // start moving
    	
    	JFrame f  = new JFrame(); // Get panel and post 
    	f.add(this); // paste ourself
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setSize(500, 500);
    	f.setVisible(true);
    }
    
    public void paint(Graphics g)
    {
    	super.paint(g); // Call JPanel to draw new background
    	for(int i = 0 ; i < list.size() ; i++)  // draw every particle in ArrayList defined by index
		{
			list.get(i).draw(g);
		}
    }
    
    public static void main(String [] args)
    {
    	new GUI(); // Show it
    }
}
