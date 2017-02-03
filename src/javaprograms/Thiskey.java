package javaprograms;

class D
{
	int x,y;
	D(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	D()
	{
		this(10,20);
		System.out.println("This is default constructor");
	}
	void sum()
	{
		
		System.out.println("Sum of x & y is: "+(x+y));
		this.show();
	}
	void show()
	{
		System.out.println("This is show method");
	}
}

public class Thiskey {

	public static void main(String[] args) 
	{
		//D b1=new D(10,20);
		D b2=new D();
		b2.sum();
		//b2.show();

	}

}
