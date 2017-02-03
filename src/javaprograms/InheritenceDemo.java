package javaprograms;

class Parent
	{
		Parent()
		{
			System.out.println("This parent class constructor");
		}
		void meth1()
		{
			System.out.println("This is parent class method");
		}
	}
class Child extends Parent
	{
		Child()
		{
			System.out.println("This child class constructor");
		}
		void meth2()
		{
			System.out.println("This is child class method");
		}
	}

	public class InheritenceDemo {

		public static void main(String[] args) {
			Child b=new Child();
			b.meth1();
			b.meth2();

		}

	}