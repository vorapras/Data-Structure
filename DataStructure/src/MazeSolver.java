//Dijisktar Algorithm
public class MazeSolver 
{
   public int [][] maze; // Matrix Maze
   public PointInMaze [][] Pmaze;
   public void solve(int [][] mazex)
   {
	   MyQueue<PointInMaze> q = new MyQueue<PointInMaze>(); // Create MyQueue and store PointInMaze
	   maze = mazex;
	   Pmaze = new PointInMaze[maze.length][maze[0].length];
	   for(int i = 0 ; i < 40 ; i++) // Matrix 40 x 40 
		{
			for(int j = 0 ; j < 40 ; j++)
			{ 
				//Copy All Point from the maze
				Pmaze[i][j] = new PointInMaze();
				Pmaze[i][j].x = j ;
				Pmaze[i][j].y = i ;
				Pmaze[i][j].count_walk = 0;
				Pmaze[i][j].prev = null;
				Pmaze[i][j].visited = false; // Never been there before
			    if(maze[i][j] == -10)
			    {
			    	Pmaze[i][j].isValid = false;
			    }
			    else
			    {
			    	Pmaze[i][j].isValid = true;
			    }
			}
        }
	   PointInMaze start = Pmaze[0][0];
	   PointInMaze end = Pmaze[maze.length-1][maze[0].length-1];
	   
	   q.enqueue(start); // start at Pmaze[0][0]
	   start.visited = true;
	   while(q.size() > 0) // is not null
	   {
		  System.out.print(q.size()+"\t");
		  PointInMaze now = q.dequeue(); // dequeue if it is not null
		  System.out.println(q.size());
	
		  if(now.x > 0 && Pmaze[now.y][now.x-1].isValid && !Pmaze[now.y][now.x-1].visited) //Not in left corner and we can move left and never been there before
		  {
			  Pmaze[now.y][now.x-1].prev = now;
			  Pmaze[now.y][now.x-1].count_walk = now.count_walk+1;
			  q.enqueue(Pmaze[now.y][now.x-1]);
			  PointInMaze next = Pmaze[now.y][now.x-1];
			  next.visited = true;
			  if(next == end)
			  {
				  break;
			  }
		  }
		  if(now.y > 0 && Pmaze[now.y-1][now.x].isValid && !Pmaze[now.y-1][now.x].visited) //Not in the top and we can move up and never been there before
		  {
			  Pmaze[now.y-1][now.x].prev = now;
			  Pmaze[now.y-1][now.x].count_walk = now.count_walk+1;
			  q.enqueue(Pmaze[now.y-1][now.x]);
			  PointInMaze next = Pmaze[now.y-1][now.x];
			  next.visited = true;
			  if(next == end)
			  {
				  break;
			  }
		  }
		  if(now.x < maze[0].length-1 && Pmaze[now.y][now.x+1].isValid && !Pmaze[now.y][now.x+1].visited) //Not in right corner and we can move right and never been there before
		  {
			  Pmaze[now.y][now.x+1].prev = now;
			  Pmaze[now.y][now.x+1].count_walk = now.count_walk+1;
			  q.enqueue(Pmaze[now.y][now.x+1]);
			  PointInMaze next = Pmaze[now.y][now.x+1];
			  next.visited = true;
			  if(next == end)
			  {
				  break;
			  }
		  }
		  if(now.y < maze[0].length-1 && Pmaze[now.y+1][now.x].isValid && !Pmaze[now.y+1][now.x].visited) //Not in the lowest and we can move down and never been there before
		  {
			  Pmaze[now.y+1][now.x].prev = now;
			  Pmaze[now.y+1][now.x].count_walk = now.count_walk+1;
			  q.enqueue(Pmaze[now.y+1][now.x]);
			  PointInMaze next = Pmaze[now.y+1][now.x];
			  next.visited = true;
			  if(next == end)
			  {
				  break;
			  }
		  }
			  
	   }
	   PointInMaze ee = end; // Print the Shortest Path
	   
	   while(ee.prev != null && ee != start) 
	   {
		   System.out.println(ee.y+" " +ee.x);
		   mazex[ee.y][ee.x] = 1;//If it has been visited, let it be 1
		   ee = ee.prev; // Like linkedlist
	   }
    }
}

class PointInMaze  // Constructor
{
	public int x;  // Point x
	public int y;  // Point y
	public int count_walk;  // Count
	public PointInMaze prev; // Previous position
	public boolean isValid;
	public boolean visited; // has been visited or not
}