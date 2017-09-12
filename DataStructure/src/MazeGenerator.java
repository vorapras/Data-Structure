import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MazeGenerator 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		PrintWriter pw = new PrintWriter(new File("maze.txt")); // Create maze file and store it in text file
		for(int i = 0 ; i < 40 ; i++) // Matrix 40 x 40 
		{
			for(int j = 0 ; j < 40 ; j++)
			{
				if( i == 0 && j == 0 || i == 39 && j == 39 )
				{
					pw.print(" ");
				}
				else
				{
				if( Math.random() < 0.27 )
				{
					pw.print("x");
				}
				else
				{
					pw.print(" ");
				}
			   }
			}
			pw.println();//space bar
		}
		pw.close();//Close file
	}
}
