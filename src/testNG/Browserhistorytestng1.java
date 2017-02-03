package testNG;

import static org.testng.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Browserhistorytestng1 {
	WebDriver d; 
	@Test
	    public void testBrowserHistory() throws Exception
	    {
	    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	    	d.manage().window().maximize();
	    	//Delete cookies
	    	d.manage().deleteAllCookies();
	    	d.navigate().to("http://docs.seleniumhq.org/");
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
				System.setProperty("webdriver.ie.driver","H:\\Selenium JAR Files\\IEDriverServer.exe");
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
