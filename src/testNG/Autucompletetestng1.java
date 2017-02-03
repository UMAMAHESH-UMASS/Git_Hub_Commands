package testNG;
import static org.testng.Assert.assertEquals;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Autucompletetestng1 {
		WebDriver d; 
		@Test
	    public void testAutocomplete() throws Exception
	    {
	    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	    	d.manage().window().maximize();
	    	d.get("http://jqueryui.com/autocomplete/");
	  	    assertEquals("Autocomplete | jQuery UI",d.getTitle());
	    	d.switchTo().frame(0);
	    	d.findElement(By.id("tags")).sendKeys("b");
	    	List<WebElement> s=d.findElements(By.className("ui-menu-item"));
	    	System.out.println("No of suggestions:"+s.size());
	    	String suggestions[]=new String[s.size()];
	    	System.out.println("Suggestions are:");
	    	System.out.println("***********************************");
	    	int i=0;
	    	for(WebElement e:s)
	    	{
	    		suggestions[i]=e.getText();
	    		System.out.println(suggestions[i]);
	    		i++;
	    	}
	    	/*d.findElement(By.id("tags")).clear();
	    	d.findElement(By.id("tags")).sendKeys(suggestions[2]);*/
	    	if(s.size()>=3)
	    	{
	    		
	    		for(int j=0;j<3;j++)
	    		{
	    			d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
	    			Thread.sleep(1000);
	    		}
	    		d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
	    		
	    	}
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
