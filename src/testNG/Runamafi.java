package testNG;


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

public class Runamafi {
	WebDriver d;
	@Test
    public void testRunamafi() throws Exception
    {
	
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(4,TimeUnit.MINUTES);
		d.get("http://www.google.com");
		d.findElement(By.id("gbqfq")).sendKeys("runamafi");
		d.findElement(By.id("gbqfb")).click();
		d.findElement(By.linkText("AP Loan Waiver Selcted,Rejected List 2014 For Runa Mafi ...")).click();
	    d.findElement(By.linkText("AP Crop Loan/Gold Loan Waiver Selected/Rejected List 2014 Now Available")).click();
	    	
	
	
	    Thread.sleep(2000);
	    d.quit();
	
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
			public void teardown()
			{
				System.out.println("@AfterMethod");
			}
			
}