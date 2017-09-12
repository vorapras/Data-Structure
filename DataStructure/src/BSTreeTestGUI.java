import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BSTreeTestGUI extends JPanel
{
	BSTree t;
   public BSTreeTestGUI()
   {
	   t = new BSTree();
	   
	   t.add(50);
	   t.add(3);
	   t.add(15);
	   t.add(4);
	   t.add(40);
	   
	   t.inOrder(new VisitTreeI()
			   {

				@Override
				public void visit(BSTreeNode node) 
				{					
					System.out.println(node.data);
				}		   
			   });
	   
//	   for(int i = 0 ; i < 50 ; i++)
//	   {
//		   t.add((int)(Math.random()*100));
//	   }
//	   System.out.println(Math.pow(2, 23));
//	   System.out.println(t.height());
	   
//	   for(int i = 0 ; i < 20 ; i++)
//	   {
//		   t.add(i);
//	   }
	   
	   JFrame f = new JFrame();
	   f.add(this);
	   f.setSize(500, 500);
	   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   f.setVisible(true);
   }
   
   public void paint(Graphics g)
   {
	   super.paint(g);
	   g.setColor(Color.WHITE);
	   System.out.println();
	   g.fillRect(0, 0,this.getWidth(), this.getHeight());
	   t.draw(g, this.getWidth(), this.getHeight());
   }
   
	public static void main(String[] args) 
	{
		new BSTreeTestGUI();
	}

}
