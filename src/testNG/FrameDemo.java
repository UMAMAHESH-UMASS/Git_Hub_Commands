package testNG;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class FrameDemo {

WebDriver d;
	
    @Test
    public void testFrame() throws Exception
    {
    	d=new FirefoxDriver();
    	d.manage().window().maximize();
    	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	d.get("http://jqueryui.com/autocomplete/");
    	assertEquals("Autocomplete | jQuery UI",d.getTitle());
    	//switch focus to frame
    	d.switchTo().frame(0);
    	d.switchTo().frame(d.findElement(By.className("demo-frame")));
    	d.findElement(By.id("tags")).sendKeys("Selenium");
    	
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
	@After
	public void tearDown()
	{
		System.out.println("@After Method");
		d.quit();
	}

}
