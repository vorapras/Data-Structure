import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI4_TestStack_Queue extends JFrame 
{
	private MyPanel contentPane;
	private JTextField textField;
//Launch the application
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI4_TestStack_Queue frame = new GUI4_TestStack_Queue();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

//Create the frame
	public GUI4_TestStack_Queue() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new MyPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.stack = new Stack<Integer>();  // Declare Stack
		contentPane.stack.push(1);
		contentPane.stack.push(2);
		contentPane.stack.push(3);
		contentPane.stack.push(4);

		contentPane.q = new MyQueue<Integer>();  // Declare Queue
		contentPane.q.enqueue(1);
		contentPane.q.enqueue(2);
		contentPane.q.enqueue(3);

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(29, 61, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				contentPane.stack.push(Integer.parseInt(textField.getText())); // Call push method
				repaint(); // Load new data again and again
			}
		});
		btnPush.setBounds(184, 61, 117, 29);
		contentPane.add(btnPush);
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				contentPane.stack.pop(); // Call pop method
				repaint(); // Load new data again and again
			}
		});
		btnPop.setBounds(184, 102, 117, 29);
		contentPane.add(btnPop);
		
		JButton btnEnqueue = new JButton("Enqueue");
		btnEnqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.q.enqueue(Integer.parseInt(textField.getText())); // Call enqueue method
				repaint(); // Load new data again and again
			}
		});
		btnEnqueue.setBounds(313, 61, 117, 29);
		contentPane.add(btnEnqueue);
		
		JButton btnDequeue = new JButton("Dequeue");
		btnDequeue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.q.dequeue(); // Call dequeue method
				repaint(); // Load new data again and again
			}
		});
		btnDequeue.setBounds(313, 102, 117, 29);
		contentPane.add(btnDequeue);
	}
}

class MyPanel extends JPanel // Override Method
{
	public Stack<Integer> stack;
	public MyQueue<Integer> q;
	
	public void paint(Graphics g)
	{
		super.paint(g);     //Call main class and draw new background
		if(stack != null)   // Check whether stack is null or not
		stack.draw(g);  //If not, please draw
		
		if(q != null)   // Check whether queue is null or not
			q.draw(g);  //If not, please draw
	}
}
