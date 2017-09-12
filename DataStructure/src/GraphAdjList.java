import java.awt.Graphics;

public class GraphAdjList<T> 
{
    MyArrayListOfT<GraphNode<T>> all;
    public GraphAdjList()
    {
    	all = new MyArrayListOfT<GraphNode<T>>();
    }
    
    public void addNode(T x)
    {
    	GraphNode<T> n = new GraphNode<T>(x);
    	all.add(n);
    }
    
    public void addEdge(T x,T y, double weight)
    {
       int index_a = -1;
 	   int index_b = -1;
 	   for(int i = 0; i < all.size() ; i++)
 	   {
 		   if(all.get(i).data.equals(x))
 		   {
 			   index_a = i;
 			   break;
 		   }
 	   }
 	   for(int i = 0; i < all.size() ; i++)
 	   {
 		   if(all.get(i).data.equals(y))
 		   {
 			   index_b = i;
 			   break;
 		   }
 	   }
    	
 	   if(index_a == -1 || index_b == -1) return;
 	   GraphEdge<T> e = new GraphEdge<T>();
 	   e.from = all.get(index_a);
 	   e.to = all.get(index_b);
 	   e.weight = weight;
 	   GraphEdge<T> f = new GraphEdge<T>();
 	   f.from = all.get(index_b);
 	   f.to = all.get(index_a);
 	   f.weight = weight;
 	   
 	   all.get(index_a).adj.add(e);
 	   all.get(index_b).adj.add(f);
 	  
    }	  
 	public void draw(Graphics g)
 	{
      for(int i = 0; i < all.size() ; i++)
    	{
    	  all.get(i).draw(g);
    	}
 	}
 	
 	public void updatePos(int screenwidth,int screenheight)
 	{		
 		for(int i = 0; i < all.size() ; i++)
  	   {
 			//Force from other node
 			Vector sum = new Vector(0,0);
 			for(int j = 0; j < all.size() ; j++)
 	 	   {
 				if(i == j) continue;
 				Vector t = all.get(i).pos.sub(all.get(j).pos);
 				Vector dir = t.unit();
 				double s = t.size();
 				
 				Vector f = dir.mul(0.001 / (s*s));
 				System.out.println(">>>>"+f.size());
 				sum = sum.add(f);
 	 	   }
 			
 			System.out.println(">>>>>>>"+sum.size());
 			//Force from spring 
 			Vector sum2 = new Vector(0,0);
 			for(int j = 0; j < all.get(i).adj.size() ; j++)
 	 	   {
 				// f = kx
 				// f = k*(l-l0)
 				Vector t = all.get(i).pos.sub(all.get(i).adj.get(j).to.pos);
 				Vector dir = t.unit();
 				double s = t.size();
 				
 				double l0 = 5*all.get(i).adj.get(j).weight;
 				s = 0.001 * (s-l0) * -1;
 				System.out.println(s);
 				if(Math.abs(s) < 0.0001)
 				{
 					s = 0.0001*(s > 0 ? 1 : -1);
 				}
 							
 				Vector f = dir.mul(s);
 				
 				//System.out.println("f = "+f.size());
 				
 				sum2 = sum2.add(f);
 	 	   }
 			System.out.println("2 >>>>>>>>>>>"+sum2.size());
 			
 			Vector sumall = sum.add(sum2);
 			all.get(i).vel = all.get(i).vel.mul(0.98);
 			all.get(i).vel = all.get(i).vel.add(sumall);
 			all.get(i).pos = all.get(i).pos.add(all.get(i).vel);
  	   }
 		double pos_x_min = Double.POSITIVE_INFINITY; 
 		double pos_y_min = Double.POSITIVE_INFINITY;
 		
 		double pos_x_max = Double.NEGATIVE_INFINITY;
 		double pos_y_max = Double.NEGATIVE_INFINITY;
 
 		for(int i = 0 ; i < all.size() ; i++)
 		{
 			if(all.get(i).pos.x > pos_x_max)
 			{
 				pos_x_max = all.get(i).pos.x;
 			}
 			if(all.get(i).pos.y > pos_y_max)
 			{
 				pos_y_max = all.get(i).pos.y;
 			}
 			if(all.get(i).pos.x < pos_x_min)
 			{
 				pos_x_min = all.get(i).pos.x;
 			}
 			if(all.get(i).pos.y < pos_y_min)
 			{
 				pos_y_min = all.get(i).pos.y;
 			}
 		}
 		
 	  double w = pos_x_max - pos_x_min;
 	  double h = pos_y_max - pos_y_min;
 	  
 	  double step_x = screenwidth / w;
 	  double step_y = screenheight / h;	
 	  
 	   for(int i = 0 ; i < all.size() ; i++)
		{
 		all.get(i).pos_toshow.x = (all.get(i).pos.x - pos_x_min) * step_x;
 		all.get(i).pos_toshow.y = (all.get(i).pos.y - pos_y_min) * step_y;
		}
 	   
 	  for(int i = 0 ; i < all.size() ; i++)
		{
		all.get(i).pos.x = (all.get(i).pos.x - pos_x_min);
		all.get(i).pos.y = (all.get(i).pos.y - pos_y_min);
		}
 	   
 	  System.out.println(pos_x_min+" "+pos_y_min+" "+pos_x_max+" "+pos_y_max);
 	  
 	 for(int i = 0 ; i < all.size() ; i++)
		{
 		 System.out.println(all.get(i).vel.size());
		}	  
 	}
}

