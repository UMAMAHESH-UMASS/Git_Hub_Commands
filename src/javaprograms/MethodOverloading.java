package javaprograms;

class K
{
	void sum()
	{
		System.out.println("This is default method");
	}
	void sum(int x,int y)
	{
		System.out.println("Sum of x & y is: "+(x+y));
	}
	void sum(int x,int y,int z)
	{
		System.out.println("Sum of x, y & Z is: "+(x+y+z));
	}
}

public class MethodOverloading {

	public static void main(String[] args) {
		K b=new K();
		b.sum();
		b.sum(10, 20);
		b.sum(10, 20, 30);

	}

}
