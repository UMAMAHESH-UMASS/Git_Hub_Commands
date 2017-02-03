package junit;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JunitAnnotationsDemo { 
	
	static WebDriver rk;

	@BeforeClass
	public static void oneTimeSetup()
	{
		System.out.println("@BeforeClass method");
		 rk= new FirefoxDriver();
		
	}
	@AfterClass
	public static void oneTimeTeardown()
	{
		System.out.println("@AfterClass method");
		rk.quit();
	}
	@Before
	public void setUp()
	{
		System.out.println("@Before method");
		
	}
	@After
	public void tearDown()
	{
		System.out.println("@After method");
	}
	@Test
	public void testMeth1()
	{
		System.out.println("@Test1 method");
		rk.get("https://www.google.com");
	}

	@Test
	public void testMeth2()
	{
		System.out.println("@Test2 method");
		rk.get("www.yahoo.com");
		assertEquals("Yahoo India", rk.getTitle());
		
	}
	@Test
	public void testMeth3()
	{
		System.out.println("@Test3 method");
		rk.get("facebook.com");
	}
	@Test
	public void testMeth4() throws InterruptedException
	{
		System.out.println("@Test4 method");
		rk.get("http://www.yahoomail.com");
		assertEquals("Sign in to Yahoo", rk.getTitle());
		Thread.sleep(10000);
	}
 }
