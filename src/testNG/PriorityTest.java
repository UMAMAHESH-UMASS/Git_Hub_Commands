package testNG;

import org.testng.annotations.Test;

public class PriorityTest {
	@Test(priority=3)
	public void meth1()
	{
		System.out.println("This is meth1");
	}
	@Test(priority=4)
	public void meth2()
	{
		System.out.println("This is meth2");
	}
	@Test(priority=2)
	public void meth3()
	{
		System.out.println("This is meth3");
	}
	@Test(priority=1)
	public void meth4()
	{
		System.out.println("This is meth4");
	}

}
