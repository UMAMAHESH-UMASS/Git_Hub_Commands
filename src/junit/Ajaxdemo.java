package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Ajaxdemo {
         WebDriver d;
 
		    @Test
		    public void testSync() throws Exception
		    {
		    	//System.setProperty("webdriver.ie.driver", "C:\\Users\\nagini\\Downloads\\IEDriverServer_Win32_2.44.0.exe");
				//d=new InternetExplorerDriver();
				
		    	System.setProperty("webdriver.Chrome.driver","H:\\lib\\IE DRIVER\\chromedriver_win32");
		    	d=new FirefoxDriver();
		    	
		    	d.manage().window().maximize();
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
		    	System.out.println("@Text Method");
		    	d.quit();   
		    }
		    
			@Before
			public void setUp()
			{
				System.out.println("@Before method");
				
			}
			@After
			public void tearDown()
			{
				System.out.println("@After method");
				
				
			}

}


