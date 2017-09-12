import java.awt.Graphics;

import javax.swing.JFrame;

public class TreeDrawer extends JFrame
{
	  BSTree t;
	  
	public TreeDrawer()
	{
	   t = new BSTree();
	   for(int i =0 ;i<10;i++)
	   {
		   t.add((int)(Math.random()*10));
	   }
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	  setSize(1000, 1000);
   	  setVisible(true);
	}
	
  public void paint(Graphics g)
	    {
	       super.paint(g);	
	       t.draw(this.getWidth(),this.getHeight(),g);
	    }

	public static void main(String[] args) 
	{
		new TreeDrawer();
	}

}
