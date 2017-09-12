import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

public class GUI5_maze extends JFrame
{
	int [][] maze = new int [40][40]; // Matrix 40 x 40
	public void readFile()   //Method read maze.txt file
	{
		try 
		{
			Scanner sc  = new Scanner(new File("maze.txt")); // Input maze.txt file
			int j = 0;
			while(sc.hasNext())  // As long as it has next 
			{
				String s = sc.nextLine();
				for(int i = 0 ; i < s.length() ; i++) // Loop for s.length
				{
					if(s.charAt(i) == 'x')
					{
						maze[j][i] = -10; // If there is X as an obstruct, let it be minus ten
					}
				}
				j++;
			}
			sc.close();//Close file
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
	}
    public GUI5_maze()
    {
    	readFile();//Call method readFile in GUI
    	
    	MazeSolver solver = new MazeSolver();
    	solver.solve(maze);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(1000,700);
    	setVisible(true);
    }
    public void paint(Graphics g)
    {
    	super.paint(g); // Call main method to paint background
    	int size = 15 ; // set size of square
    	for(int i = 0 ; i < 40 ; i++) // Matrix 40 x 40 
		{
			for(int j = 0 ; j < 40 ; j++)
			{
				if(maze[i][j] == -10) // Block with cannot pass 
				{
					g.setColor(Color.BLACK);
					g.fillRect(j*size+40, i*size+40, size, size);
				}
				else if(maze[i][j] == 1)  // the right path
				{
					g.setColor(Color.PINK);
					g.fillRect(j*size+40, i*size+40, size, size);
				}
				else 
				{
					g.setColor(Color.BLACK);
					g.drawRect(j*size+40, i*size+40, size, size);
				}
			}
		}
    }
	public static void main(String[] args) 
	{
		new GUI5_maze(); // Show it
	}

}
