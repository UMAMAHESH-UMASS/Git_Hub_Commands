package testNG;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserHistoryTestng {
	WebDriver d; 
	@Test
	    public void testBrowserHistory() throws Exception
	    {
	    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	    	d.manage().window().maximize();
	    	//Delete cookies
	    	d.manage().deleteAllCookies();
	    	d.navigate().to("http://docs.seleniumhq.org/");
	    	//d.get("http://docs.seleniumhq.org/");
	    	assertEquals("Selenium - Web Browser Automation",d.getTitle());
	    	//Click download tab
	    	d.findElement(By.linkText("Download")).click();
	    	Thread.sleep(2000);
	    	//click browser back button
	    	d.navigate().back();
	    	Thread.sleep(2000);
	    	//click browser forward button
	    	d.navigate().forward();
	    	Thread.sleep(2000);
	    	//Refresh
	    	d.navigate().refresh();

			System.out.println("@Text Method");
	    	Thread.sleep(4000);
	    	
	    }
	//Reading browse name from XML
  	@Parameters("browser")
  	@BeforeMethod
  	public void setUp(String browser)
  	{
  		
  		if(browser.equalsIgnoreCase("FF"))
  		{
  			d=new FirefoxDriver();
  		}
  		else if(browser.equalsIgnoreCase("IE"))
  		{
  			System.setProperty("webdriver.ie.driver", "H:\\Selenium JAR Files\\IEDriverServer.exe");
  			d=new InternetExplorerDriver();
  		}
  		else if(browser.equalsIgnoreCase("GC"))
  		{
  			System.setProperty("webdriver.chrome.driver", "H:\\Selenium JAR Files\\chromedriver.exe");
  			d=new ChromeDriver();
  		}
  		
  	}
	@AfterMethod
	public void tearDown()
	{

		System.out.println("@After Method");
		d.quit();
	}

}
