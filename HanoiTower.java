
public class HanoiTower 
{
   int[][] x = new int[3][5];
   
   public void initial()
   {
	   for(int i = 0; i < x[0].length ; i++)
	   {
		   x[0][i] = i+1;
	   }
   }
   
   public void move(int from, int to, int n)
   {
	   if(from == to) return;
	   if(n == 1)
	   {
		   int fromindex = 0;
		   while(fromindex < x[0].length && x[from][fromindex] == 0)
		   {
			   fromindex++;
		   }
		   
		   int toindex = 0;
		   while(toindex < x[0].length && x[to][toindex] == 0)
		   {
			   toindex++;
		   }
		   toindex--;
		   x[to][toindex] = x[from][fromindex];
		   x[from][fromindex] = 0;
		   draw();
		   return;
	   }
	   
	   int anotherpole = 3-from-to;
	   move(from,anotherpole,n-1);
	   move(from,to,1);
	   move(anotherpole,to,n-1);
   }
   
   public void draw()
   {
	   for(int i = 0 ; i < x[0].length ; i++)
	   {
		   for(int j = 0 ; j < x.length ; j++)
		   {
			   for(int k = 0 ; k < x[0].length-x[j][i] ; k++)
			   {
				   System.out.print("_");
			   }
			   for(int k = 0 ; k < 2*x[j][i] ; k++)
			   {
				   System.out.print("x");
			   }
			   for(int k = 0 ; k < x[0].length-x[j][i]; k++)
			   {
				   System.out.print("_");
			   }
		   }
		   System.out.println();
	   }
   }
   
	public static void main(String[] args) 
	{
		HanoiTower h = new HanoiTower();
		h.initial();
		h.move(0, 2, 5);

	}

}
