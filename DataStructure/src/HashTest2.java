import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HashTest2 extends JPanel
{
	Hash<Cat> h ;
	private JTextField textField;
	public HashTest2()
	{
		h = new Hash<Cat>();
		for(int i = 0 ; i < 20 ; i++)
		{
    	  h.add(new Cat((int)(Math.random()*100),(int)(Math.random()*100)));
		}	
		JFrame f  = new JFrame(); // Get panel and post 
    	f.getContentPane().add(this); // paste ourself
    	setLayout(null);
    	
    	textField = new JTextField();
    	textField.setBounds(290, 6, 82, 26);
    	add(textField);
    	textField.setColumns(10);
    	
    	JButton btnOk = new JButton("OK");
    	btnOk.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			int x = Integer.parseInt(textField.getText());
    			h.add(new Cat(x,(int)(Math.random()*100)));
    			repaint();
    		}
    	});
    	btnOk.setBounds(377, 6, 117, 29);
    	add(btnOk);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setSize(500, 500);
    	f.setVisible(true);
	}
	
	  public void paint(Graphics g)
	{
	    	super.paint(g); // Call JPanel to draw new background
	    	h.draw(g);
			
    }
	public static void main(String[] args) 
	{
		new HashTest2();
	}
}
class Cat
{
	public int x;
	public int y;
	public Cat(int gg,int hh)
	{
		x = gg;
		y = hh;
	}
	public boolean equals(Object xs)
	{
		if(xs instanceof Cat)
		return  x == ((Cat)xs).x;
		return false;
	}
	
	public int hashCode()
	{
		return x*x+y*y*x*19;
	}
}

