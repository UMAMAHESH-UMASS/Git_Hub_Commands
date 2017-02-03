package testNG;

import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DragenDroptestng1 {
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
	 @Parameters({"browser"})
		@BeforeMethod
		public void setUp(String browser) throws Exception
		{
			if(browser.equals("FF"))
			{
				DesiredCapabilities b = DesiredCapabilities.firefox();
				d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
				
			}
			else if(browser.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver","H:\\Lib\\IEDriverServer.exe");
				DesiredCapabilities b = DesiredCapabilities.internetExplorer();
				d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
	    	}
			else if(browser.equals("GC"))
			{
				System.setProperty("webdriver.chrome.driver", "H:\\Selenium JAR Files\\chromedriver.exe");
				DesiredCapabilities b = DesiredCapabilities.chrome();
				d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),b);
			}
				
			d.manage().deleteAllCookies();
			d.manage().window().maximize();
		}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
