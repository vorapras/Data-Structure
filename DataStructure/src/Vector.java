
public class Vector 
{
	double x, y;
	
	public Vector()
	{
		x = 0;
		y = 0;
	}

	public Vector(double x, double y)
	{

		this.x = x;
		this.y = y;
	}
	
	public Vector(Vector v)
	{

		x = v.x;
		y = v.y;
	}


	public Vector add(Vector v)
	{
		Vector result = new Vector();// new = '���ҧ
		result.x = this.x + v.x;// x�ͧv
		result.y = this.y + v.y;
		return result;

	}
	public Vector sub(Vector v)
	{
		Vector result = new Vector();// new = '���ҧ
		result.x = this.x - v.x;// x�ͧv
		result.y = this.y - v.y;
		return result;

	}
	public Vector mul(double m)
	{
		Vector result = new Vector();// new = '���ҧ
		result.x = this.x *m;// x�ͧv
		result.y = this.y *m;
		return result;

	}
	public double dot(Vector v)
	{
		double result = this.x * v.x+this.y*v.y;// x�ͧv
		return result;
	}
	public double size()
	{
		double result = Math.sqrt(x*x+y*y);// x�ͧv
		return result;
	}
	public Vector unit()
	{
		double s=size();
		return new Vector(x/s,y/s);
	}
}
