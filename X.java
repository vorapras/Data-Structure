
public class X {
    public int a;
    
	public static void main(String[] args) 
	{
		X x = new X();
		System.out.println(x.hashCode());
		x.a = 10;
		System.out.println(x.hashCode());

	}
}
