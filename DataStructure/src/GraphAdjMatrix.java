
public class GraphAdjMatrix 
{
   int[][] edge;
   String [] name;
   int count_name;
   
   public GraphAdjMatrix(int n)
   {
	   name = new String [n];
	   edge = new int[n][n];
	   count_name = 0;
   }
   
   public void addNodeName(String xname)
   {
	   name[count_name] = xname;
	   count_name++;
   }
   
   public void addEdge(String a, String b, int weight)
   {
	   int index_a = 0;
	   int index_b = 0;
	   for(int i = 0; i < count_name ; i++)
	   {
		   if(name[i].equals(a))
		   {
			   index_a = i;
			   break;
		   }
	   }
	   for(int i = 0; i < count_name ; i++)
	   {
		   if(name[i].equals(b))
		   {
			   index_b = i;
			   break;
		   }
	   }
	   
	   edge[index_a][index_b] = weight;
	   edge[index_b][index_a] = weight;
   }
}
