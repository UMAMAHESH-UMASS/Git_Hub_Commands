package testNG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTabDemo {
	WebDriver d; 
	@Test
	    public void testNewTab() throws Exception
	    {
	    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	    	d.manage().window().maximize();
	    	d.get("http://www.google.co.in/");
	    	assertEquals("Google",d.getTitle());
	    	//open new page
	    	Actions a=new Actions(d);
	    	WebElement link1=d.findElement(By.linkText("Images"));
	    	a.moveToElement(link1).keyDown(Keys.CONTROL).click(link1).build().perform();
	    	System.out.println("@Test Method");
	    	Thread.sleep(4000);
	    	
	    }
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		System.out.println("@Before Method");
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.println("@After Method");
		d.quit();
	}

}
