import java.awt.Graphics;

public class BSTree 
{
    public TreeNode root;
 /////////////////////////////////////   
    public void add(int x)
    {
    	if(root == null)
    	{
    		root  = new TreeNode(x,null,null);
    		return;
    	}
    	TreeNode n = root;
    	while(true)
    	{
    		if(n.data == x)
    		{
    			return;
    		}
    		if(n.data < x)
    		{
    			if(n.right == null)
    			{
    				n.right = new TreeNode(x,null,null);
    				return;
    			}
    			else
    			{
    				n = n.right;
    			}
    		}
    		else
    		{
    			if(n.left == null)
    			{
    				n.left = new TreeNode(x,null,null);
    				return;
    			}
    			else
    			{
    				n = n.left;
    			}
    		}
    	}// end while
    }// end method
 //////////////////////////////////////////////////// 
    //Recursive Method
    public void add2(int x)
    {
    	if(root == null)
    	{
    		root = new TreeNode(x, null, null);
    		return;
    	}
    	add3(x,root);
    }
 /////////////////////////////////////////////////////
    private void add3(int x, TreeNode n)
    {
    	if(n == null)
    	{
    		return;
    	}
    	if(n.data == x)
    	{
    		return;
    	}
    	if(n.data > x)
    	{
    		if(n.left == null)
    		{
    			n.left = new TreeNode(x, null, null);
    		}
    		else
    		{
    			add3(x,n.left);
    		}
    	}
    	else
    	{
    		if(n.right == null)
    		{
    			n.right = new TreeNode(x, null, null);
    		}
    		else
    		{
    			add3(x,n.right);
    		}
    	}
    }
 ////////////////////////////////////////////////////   
    public int height()
    {
    	return height(root);
    }
    
    private int height(TreeNode n)
    {
    	if(n == null)
    	{
    		return -1;
    	}
    	
    	if(n.left == null && n.right == null)
    	{
    		return 0;
    	}
    	
    	int nl,nr;
    	nl = height(n.left);
    	nr = height(n.right);
    	int max = nl > nr ? nl:nr ; 
    	
    	return max+1;
    }
  ////////////////////////////////  
    public int Leaves()
    {
    	return Leaves(root);
    }
    
    private int Leaves(TreeNode n)
    {
    	if(n == null)
    	{
    		return 0;
    	}
    	
    	if(n.left == null && n.right == null)
    	{
    		return 1;
    	}
    	
    	int nl,nr;
    	nl = Leaves(n.left);
    	nr = Leaves(n.right);
    	return nl+nr;
    }
 ////////////////////////////////////   
    public int size()
    {
    	return size(root);
    }
    
    private int size(TreeNode n)
    {
    	if(n == null)
    	{
    		return 0;
    	}
    	
    	if(n.left == null && n.right == null)
    	{
    		return 1;
    	}
    	
    	int nl,nr;
    	nl = size(n.left);
    	nr = size(n.right);
    	return nl+nr+1;
    }
/////////////////////////////////////////////////////////    
    int stepwidth, stepheight;
    public void draw(int swidth, int sheight, Graphics g)
    {
    	int h = height();
    	int s = size();
    	stepwidth = swidth/(s+1);
    	stepheight = sheight/(h+2);
    	draw2(g,root,1,1);
    }
 //////////////////////////////////////////////////////////
    //Tree Travasel
    public void preorder()
    {
 	   preorder(root);
    }
    
    private void preorder(TreeNode n)
    {
 	   if(n == null) return;
 	   System.out.println(n.data); // Above level
 	   preorder(n.left);
 	   preorder(n.right);
    }
    
    public void inorder()
    {
    	inorder(root);
    }
    
    private void inorder(TreeNode n)
    {
    	if(n == null) return;
    	inorder(n.left);
  	   System.out.println(n.data); // Middle Level
  	    inorder(n.right);
    }
    
    public void postorder()
    {
    	postorder(root);
    }
    
    private void postorder(TreeNode n)
    {
    	if(n == null) return;
    	postorder(n.left);
  	    postorder(n.right);
  	  System.out.println(n.data); // Below Level
    }

    
 //////////////////////////////////////////////////////////   
    public int draw2(Graphics g, TreeNode n, int y, int x)
    {
    	if(n == null)
    	{
    		return x;
    	}
    	//   	
    	if(n.left != null)
    	{
    		int centerleft = x;
        	if(n.left.left != null)
        	{
        		centerleft = size(n.left.left)+x;
        	}
    	   x = draw2(g, n.left, y+1, x);
    	   g.drawLine(centerleft*stepwidth,(y+1)*stepheight, x*stepwidth, y*stepheight);
    	}
    	n.draw(g, x, y, stepwidth, stepheight);
    	//
    	if(n.right != null)
    	{
    		int centerright = x+1;
        	if(n.right.left != null)
        	{
        		centerright = size(n.right.left)+x+1;
        	}
    	   x = draw2(g, n.right, y+1, x+1)-1;
    	   g.drawLine(centerright*stepwidth,(y+1)*stepheight, x*stepwidth, y*stepheight);
    	}
    	return x+1;
    }
    
}
