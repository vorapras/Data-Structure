import java.util.LinkedList;

class GNode 
{
   public int data;
   public LinkedList<Edge> adj;
}

class Edge
{
	public int w;
	public GNode from,to;
}
