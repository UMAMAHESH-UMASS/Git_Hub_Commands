package junit;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class AutocompleteDemo {
		WebDriver d; 
		@Test
		 public void testAutocomplete() throws Exception
	    {
		    	d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
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
		    	d.findElement(By.id("tags")).clear();
		    	d.findElement(By.id("tags")).sendKeys(suggestions[2]);
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
		@BeforeMethod
		public void setUp()
		{
			d=new FirefoxDriver();
		}
		@AfterMethod
		public void tearDown()
		{
			d.quit();
		}

	}

