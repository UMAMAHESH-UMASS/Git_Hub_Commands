package testNG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class AjaxDemoTestng {
WebDriver d;
	
    @Test
    public void testAjax() throws Exception
    {
    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
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
