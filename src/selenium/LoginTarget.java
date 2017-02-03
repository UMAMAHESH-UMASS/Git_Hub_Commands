package selenium;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTarget {
	WebDriver d; 
	@Test
	public void testLinks() throws Exception
	{
		d.manage().timeouts().implicitlyWait(6, TimeUnit.MINUTES);
    	d.manage().window().maximize();
    	d.get("http://demo.exaact.co");
    	assertEquals("Target",d.getTitle());
    	d.findElement(By.id("loginusername")).clear();
    	d.findElement(By.id("loginusername")).sendKeys("admin@exaact.co");
    	//Store username
    	String loginusername=d.findElement(By.id("loginusername")).getAttribute("value");
    	d.findElement(By.id("loginpassword")).clear();
    	d.findElement(By.id("loginpassword")).sendKeys("123456");
    	//Store password
    	String loginpassword=d.findElement(By.id("loginpassword")).getAttribute("value");
    	d.findElement(By.id("loginformsubmit")).click();
		System.out.println("@Test method ");
    	//Blank user name and password
    	if(loginusername.equals(" ") && loginpassword.equals(" "))
    	{
    		assertEquals("Field is Required",d.findElement(By.cssSelector("span.hint")).getText());
    		assertEquals("Field is Required",d.findElement(By.cssSelector("span.hint")).getText());
    		System.out.println("Blank method ");
    	}
    	//Blank user name
    	else if(loginusername.equals(""))
    	{
    		assertEquals("Field is Required",d.findElement(By.cssSelector("span.hint")).getText());
    	}
    	//Blank password
    	else if(loginpassword.equals(""))
    	{
    		assertEquals("Field is Required.",d.findElement(By.cssSelector("span.hint")).getText());
    	}
    	//Valid user name and password
    	else if(isElementPresent(d,By.cssSelector("a.logoutpic > img")))
    	{
    		d.findElement(By.cssSelector("a.logoutpic > img")).click();
    	}
    	//invalid user name and password
    	else
    	{
    		assertEquals("Invalid email address and password",d.findElement(By.cssSelector("div.alert")).getText());
    	}
    	
    	    	
    	Thread.sleep(8000);
    
	}
	   
	private boolean isElementPresent(WebDriver driver,By by)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
		System.out.println("@before method ");
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.println("@After method ");
		d.quit();
	}

}
