package javaprograms;


  class A
  {
	int x,y;
	A(int a,int b)
	{
		x=a;
		y=b;
		System.out.println("sum of double parameter is:"+(a+b));
	}
	 void sum()
	{
		System.out.println("Sum:"+(x +y));
		System.out.println("umasukku");

	}
	 A(int c)
		{
			System.out.println("Sum of single parameter is:"+(c));
		}
		
}

public class ConstructorDemo {

	public static void main(String[] args) {
		A b1=new A(103,203);
		b1.sum();
		A b2=new A(201,304);
		b2.sum();
		A b3=new A(800);
		b3.sum();
		


	}

}

