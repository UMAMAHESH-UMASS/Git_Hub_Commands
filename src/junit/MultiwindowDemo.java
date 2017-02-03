package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiwindowDemo {
	 WebDriver d;
		
	    @Test
	    public void testMultiwindow() throws Exception
	    {
	    	d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	d.get("http://www.irctc.co.in/eticketing/loginHome.jsf");
	    	assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
	    	//Parent window handle
	    	String pcode=d.getWindowHandle();
	    	System.out.println("Parent window code is: "+pcode);
	    	//Click Tour Packages link
	    	d.findElement(By.linkText("Tour Packages")).click();
	    	//Getting window handles
	    	for(String code:d.getWindowHandles())
	    	{
	    		System.out.println(code);
	    		d.switchTo().window(code);
	    	}
	    	
	       	assertTrue(d.findElement(By.linkText("Login")).isDisplayed());
	       	Thread.sleep(2000);
	    	//Switch focus to parent window
	    	d.switchTo().window(pcode);
	    	assertTrue(d.findElement(By.id("usernameId")).isDisplayed());
	    	Thread.sleep(4000);
	    	
	    }
	@Before
	public void setUp()
	{
		//d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "H:\\lib\\chromedriver.exe");
		d=new ChromeDriver();
	}
	@After
	public void tearDown()
	{
		d.quit();
	}

}
