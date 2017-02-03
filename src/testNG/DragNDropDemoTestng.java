package testNG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DragNDropDemoTestng {
	WebDriver d; 
	@Test
	    public void testDragNDrop() throws Exception
	    {
	    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	    	d.manage().window().maximize();
	    	d.get("http://jqueryui.com/droppable/");
	    	assertEquals("Droppable | jQuery UI",d.getTitle());
	    	d.switchTo().frame(0); 	
	    	Actions a=new Actions(d);
	    	a.dragAndDrop(d.findElement(By.id("draggable")), d.findElement(By.id("droppable"))).perform();	    	
	    	
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
		d.quit();
	}

}
