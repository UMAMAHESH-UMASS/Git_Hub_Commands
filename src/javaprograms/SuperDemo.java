package javaprograms;

class M
{
	M()
	{
		System.out.println("This is parent default constructor");
	}
	M(int x)
	{
		System.out.println("This is parent param constructor:"+x);
	}
	int x,y;
	public void sum()
	{
		System.out.println("Sum of x & y is:"+(x+y));
	}
	public void show()
	{
		System.out.println("This is parent class method");
	}
}
class N extends M
{
	N()
	{
		super(10);
		System.out.println("Child class constructor");
		
	}
	public void show()
	{
		super.x=10;
		super.y=20;
		super.show();
		System.out.println("This is child class method");
	}
}
public class SuperDemo {

	public static void main(String[] args) {
		N b=new N();
		b.show();
		b.sum();
		

	}

}

