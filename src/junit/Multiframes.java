package junit;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Multiframes {
	WebDriver d;
	@Test
    public void testSync() throws Exception
    {
		d=new FirefoxDriver();
    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    	d.get("http://selenium.googlecode.com/git/docs/api/java/index.html");
    	assertEquals("Overview",d.getTitle());
    	List<WebElement> f=d.findElements(By.tagName("frame"));
    	System.out.println("No of frames: "+f.size());
    	//First frame
    	d.switchTo().frame(0);
    	d.findElement(By.linkText("com.thoughtworks.selenium")).click();
    	d.switchTo().defaultContent();
    	//Second frame
    	d.switchTo().frame(1);
    	d.findElement(By.linkText("Selenium")).click();
    	d.switchTo().defaultContent();
    	//Third frame
    	d.switchTo().frame(2);
    	assertEquals("Interface Selenium",d.findElement(By.xpath("//h2[@title='Interface Selenium']")).getText());
    	Thread.sleep(4000);
    	System.out.println("@Test Method");
    }  
	@Before
	public void setUp()
	{
		System.out.println("@Before Method");
	}
	@After
	public void tearDown()
	{

		System.out.println("@After Method");
		d.quit();
	}

}
