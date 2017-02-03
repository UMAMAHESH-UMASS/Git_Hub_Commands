package testNG;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ParallelMethods {
	@Test
    public void testAjax() throws Exception
    {
		System.setProperty("webdriver.chrome.driver", "H:\\Selenium JAR Files\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
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
    	d.quit();
    }
	@Test
	public void dynamicTable()throws Exception
	{
		//System.setProperty("webdriver.chrome.driver", "H:\\Selenium JAR Files\\chromedriver.exe");
		//WebDriver d=new ChromeDriver();
		WebDriver d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
		assertEquals(":: Government Orders ::",d.getTitle());
		Select s=new Select(d.findElement(By.id("Select1")));
		s.selectByIndex(4);
		List<WebElement> tr_collection=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		List<WebElement> td_collection1=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
		System.out.println("NUMBER OF Columns IN THIS TABLE = "+td_collection1.size()/tr_collection.size());
		
		int row_num,col_num;
        row_num=1;
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            //System.out.println("NUMBER OF COLUMNS="+row_num+" "+td_collection.size());
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
                System.out.println("Row # "+row_num+", Col # "+col_num  + ", Text=" +tdElement.getText());
                col_num++;
               /* if(row_num == 4 && col_num == 1)
                {
                	assertEquals("Sri  A. Giridhar, I.A.S",tdElement.getText());
                }*/
            }
            row_num++;
        }
        Thread.sleep(4000);
        d.quit();
	}
	@Test
	public void testLinks() throws Exception
    {
		System.setProperty("webdriver.chrome.driver", "H:\\Selenium JAR Files\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
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
    	d.quit();
    }

}
