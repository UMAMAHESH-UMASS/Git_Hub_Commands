package junit;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ScreenshotOnFailure {
WebDriver d;
	
    @Test
    public void testScreenshotOnFailure() throws Exception
    {
    	
    	assertEquals("Pass",getScreenshot());
    	
    }
    
    public String getScreenshot() throws Exception
    {
    	try
    	{
    		d.manage().window().maximize();
    		d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        	d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
        	assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
        	Select bank=new Select(d.findElement(By.id("selBank")));
        	bank.selectByIndex(4);
        	Select state=new Select(d.findElement(By.id("selState")));
        	state.selectByVisibleText("Andhra Pradesh");
        	Select city=new Select(d.findElement(By.id("selCity")));
        	city.selectByVisibleText("Hyderabad");
        	Select branch=new Select(d.findElement(By.id("selBranch")));
        	branch.selectByVisibleText("Sanjeeva Reddy Nagar");
        	Thread.sleep(2000);
        	return "Pass";
    	}
    	catch(Exception e)
    	{
    		//Current Date
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm");
    		Date date = new Date();
    		//System.out.println(dateFormat.format(date));
            
            // then Augmenter will add the TakesScreenshot methods to the instance
            File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("H:\\"+dateFormat.format(date)+".png"));
            return "Fail";
    	}
    	
    }
	@Before
	public void setUp()
	{
		//d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "H:\\lib\\Chromedriver.exe");
		d=new ChromeDriver();
	}
	@After
	public void tearDown()
	{
		d.quit();
	}

}
