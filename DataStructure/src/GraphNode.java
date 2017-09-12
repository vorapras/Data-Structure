import java.awt.Color;
import java.awt.Graphics;

public class GraphNode<T> 
{
  public T data;
  public MyArrayListOfT<GraphEdge<T>> adj;
  
  public GraphNode()
  {
	  data = null;
	  adj = new MyArrayListOfT<GraphEdge<T>>();
	  initPos();
  }
  
  public GraphNode(T x)
  {
	  data = x;
	  adj = new MyArrayListOfT<GraphEdge<T>>();
	  initPos();
  }
  
  public void initPos()
  {
	  color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	  pos = new Vector((int)(Math.random()*255),(int)(Math.random()*255));
	  vel = new Vector(0,0);
	  pos_toshow = new Vector(pos);
  }
  
  public Color color;
  public Vector pos;
  public Vector pos_toshow;
  public Vector vel;
  
  public void draw(Graphics g)
  {	  
	  for(int i = 0; i < adj.size() ; i++)
	  {
		  GraphEdge<T> e = adj.get(i);
		  g.drawLine((int)(pos_toshow.x),(int)(pos_toshow.y), (int)(e.to.pos_toshow.x),(int)(e.to.pos_toshow.y));
		  g.drawString(""+e.weight,(int)(pos_toshow.x + e.to.pos_toshow.x) / 2, (int)(pos_toshow.y + e.to.pos_toshow.y) / 2);
	  }
	  
      g.setColor(color);
	  g.fillOval((int)(pos_toshow.x-15),(int)(pos_toshow.y-15) , 30, 30);
	  g.setColor(Color.BLACK);
	  g.drawString(""+data,(int)(pos_toshow.x),(int)(pos_toshow.y));	  
    } 
}
