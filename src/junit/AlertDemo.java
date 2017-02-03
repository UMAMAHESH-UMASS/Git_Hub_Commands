package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertDemo {

	    WebDriver d;
		
	    @Test
	    public void TestAlert () throws Exception
	    {
	    	d=new FirefoxDriver();
	    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	    	d.get("https://retail.onlinesbi.com/retail/login.htm#");
	    	assertEquals("State Bank of India",d.getTitle());
	    	d.findElement(By.cssSelector("img.phisingcontinueButton")).click();
	    	//Click Login button
	    	d.findElement(By.id("Button2")).click();
	    	//Alert
	    	Alert al=d.switchTo().alert();
	    	assertEquals("Enter username",al.getText());
	    	al.accept();
	    	//Enter UserName
	    	d.findElement(By.id("username")).sendKeys("Selenium");
	    	//Again, Click Login button
	    	d.findElement(By.id("Button2")).click();
	    	//Alert
	    	assertEquals("Enter password",al.getText());
	    	al.accept();
	    	//Enter pwd
	    	d.findElement(By.id("label2")).sendKeys("Selenium");
	    	Thread.sleep(4000);
	    	System.out.println("@Text Method");
	    	   
	    	
	    }
	    
		@Before
		public void setUp()
		{
			//System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\chromedriver.exe");
			//d=new ChromeDriver();
			
			System.out.println("@Before method");
		}
		@After
		public void tearDown()
		{
			System.out.println("@After method");
			d.quit();
		}

}


