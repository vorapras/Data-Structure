import java.awt.Graphics;

public class BSTree 
{
   BSTreeNode root;
   
   public void add(int x)
   {
	  if(root == null) //If there is no data
	  {
		  root = new BSTreeNode(x);
		  return;
	  }
	  add(root,x);
   }
   
 //Recursive Method 
   private void add(BSTreeNode n, int x)
   {
	   if(n == null) return;
	   if(n.data > x)
	   {
		   if(n.left == null)
		   {
			   n.left = new BSTreeNode(x);
			   return;
		   }
		   add(n.left, x);
	   }
	   else if(n.data < x)
	   {
		   if(n.right == null)
		   {
			   n.right = new BSTreeNode(x);
			   return;
		   }
		   add(n.right, x);
	   }
   }
   
//Loop Method    
   public void add2 (int x)
   {
	   if(root == null)
	   {
		  root = new BSTreeNode(x);
		  return;
	   }
	   BSTreeNode n = root ;
	   while(true)
	   {
		   if(n.data > x)
		   {
			   if(n.left == null)
			   {
				   n.left = new BSTreeNode(x);
				   return;
			   }
			     n = n.left;
		   }
		   else if(n.data < x)
		   {
			   if(n.right == null)
			   {
				   n.right = new BSTreeNode(x);
				   return;
			   }
			     n = n.right;
		   } 
		   else
		   {
			   break;
		   }
	   }
   }
   
  public int num()
  {
	  if(root == null) return 0;
	  return num(root);
  }
  
  private int num(BSTreeNode n)
  {
	  if(n == null) return 0;
	  return num(n.left) + num(n.right) + 1; //Count left and right and itself
  }
  
  public int height()
  {
	  if(root == null) return -1;
	  return height(root);
  }
  
  private int height(BSTreeNode n)
  {
	  if(n == null) return -1;
	  int l = height(n.left);
	  int r = height(n.right);
	  return (l > r ? l : r)+ 1; //Compare between left and right
  }
  
  public void draw(Graphics g,int screen_width,int screen_height)
  {
	 int n = num(); 
	 int h = height();
	 
	 double sw = (double)screen_width / (n+2);
	 double sh = (double)screen_height / (h+2);
	 
	 draw(g,root,sw,sh,1,1,-1,-1);
  }
  
  private int draw(Graphics g,BSTreeNode n,double step_width,double step_height,int x,int y,int x_parent,int y_parent)
  {
	  if(n == null)
	  {
		  return 0;
	  }
	  int num_current = 0;
	  int num_left = num(n.left);
	  num_current += draw(g,n.left,step_width,step_height,x,y+1,num_left+x,y);  //draw left hand side
//	  System.out.println(step_width + " " + num());
	  
	  n.draw(g, (int)((x+num_current)*step_width), (int)(y*step_height),x+num_current); //draw itself
	  
	  if(x_parent != -1 && y_parent != -1)
	  {
		  g.drawLine((int)((x+num_current)*step_width),(int)( y*step_height),(int)((x_parent)*step_width), (int)((y_parent)*step_height) );
	  }
	  
	  num_current += 1;
	  num_current += draw(g,n.right,step_width,step_height,x+num_current,y+1,x+num_current-1,y); // draw right hand side
	  
	  return num_current;
  }
  
  public void inOrder(VisitTreeI x)
  {
	  if(root == null) return;
	  inOrder(root,x);
  }
  
  private void inOrder(BSTreeNode n, VisitTreeI x)
  {
	  if(n == null) return;
	  inOrder(n.left,x);
	  x.visit(n);
	  inOrder(n.right,x);
  } 
  
  public void preOrder(VisitTreeI x)
  {
	  if(root == null) return;
	  preOrder(root,x);
  }
  
  private void preOrder(BSTreeNode n, VisitTreeI x)
  {
	  if(n == null) return;
	  x.visit(n);
	  preOrder(n.left,x);
	  preOrder(n.right,x);
  }   
  
  public void postOrder(VisitTreeI x)
  {
	  if(root == null) return;
	  postOrder(root,x);
  }
  
  private void postOrder(BSTreeNode n, VisitTreeI x)
  {
	  if(n == null) return;
	  postOrder(n.left,x);
	  postOrder(n.right,x);
	  x.visit(n);
  }   
  
}

interface VisitTreeI
{
	public void visit(BSTreeNode node);
}
