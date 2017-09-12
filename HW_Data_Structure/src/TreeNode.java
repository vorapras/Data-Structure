import java.awt.Color;
import java.awt.Graphics;

public class TreeNode 
{
   public int data;
   public TreeNode left,right;
   public TreeNode(){}
   public TreeNode(int xdata, TreeNode xleft, TreeNode xright)
   {
	    data = xdata;
	    left = xleft;
	    right = xright;
   }
   
   public void draw(Graphics g, int x, int y, int stepwidth, int stepheight )
   {
	   g.setColor(Color.pink);
	   g.fillOval(x*stepwidth-20, y*stepheight-20, 40, 40);
	   g.setColor(Color.black);
	   g.drawString(""+data, x*stepwidth, y*stepheight);   }
}
