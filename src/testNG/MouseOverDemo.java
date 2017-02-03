package testNG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOverDemo {
	WebDriver d; 
	@Test
	    public void testMouseOver() throws Exception
	    {
		
	    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	    	d.manage().window().maximize();
	    	d.get("http://www.policybazaar.com/");
	    	assertEquals("Compare: Life |Car |Health |Travel Insurance, Child |Pension |Investment Plans, Credit Cards |Loans Online",d.getTitle());
	    	Actions a=new Actions(d);
	    	a.moveToElement(d.findElement(By.cssSelector("span.catLink"))).pause(2000).moveToElement(d.findElement(By.linkText("Life Insurance"))).click().build().perform();
	    	assertEquals("Compare Life Insurance Policies in India",d.findElement(By.cssSelector("h1")).getText());
	    	Thread.sleep(4000);
	    }
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
	}
	@AfterMethod
	public void tearDown()
	{
		//d.quit();
	}

}
