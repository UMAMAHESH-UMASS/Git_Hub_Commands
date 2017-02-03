package javaprograms;

class X
{
	public void show()
	{
		System.out.println("This is parent class method");
	}
}
class Y
{
	public void show()
	{
		System.out.println("This is Child class method");
	}
}
public class Methodoverriding {

	public static void main(String[] args) {
		Y b=new Y();
		b.show();

	}

}
