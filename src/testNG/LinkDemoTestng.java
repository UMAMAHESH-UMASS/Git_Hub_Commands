package testNG;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinkDemoTestng {
	    WebDriver d; 
	    @Test
	    public void testLinks() throws Exception
	    {
	    	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	    	d.manage().window().maximize();
	    	d.get("http://docs.seleniumhq.org/");
	    	assertEquals("Selenium - Web Browser Automation",d.getTitle());
	    	List<WebElement> l=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
	    	System.out.println("No of links: "+l.size());
	    	System.out.println(" ***** Link names are ***** ");
	    	//Print link names
	    	String links[]=new String[l.size()];
	    	int i=0;
	    	for(WebElement e:l)
	    	{
	    		links[i]=e.getText();
	    		System.out.println(links[i]);
	    		i++;
	    	}
	    	//Click the links
	    	for(String t:links)
	    	{
	    		d.findElement(By.linkText(t)).click();
	    		if(d.getTitle().contains("Error 404"))
	    		{
	    			System.out.println("Link: "+t+ ":is not working");
	    		}
	    		else
	    		{
	    			System.out.println("Link: "+t+ ": is working fine");
	    		}
	    	}
	    	
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
