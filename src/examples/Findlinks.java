package examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Findlinks {
 
	@Test
	public void links() throws InterruptedException
	{
		
	WebDriver d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(6, TimeUnit.MINUTES);
	d.get("http://newtours.demoaut.com/");
	String underConsTitle="Under Construction: Mercury Tours";
	assertEquals("Welcome: Mercury Tours",d.getTitle());
	System.out.println("the title is:"+d.getTitle());
	List<WebElement> l=	d.findElements(By.tagName("a"));
	System.out.println("no of links are:"+l.size());		
	String s[]=new String[l.size()];
	int i=0;
	for(WebElement e:l)
	{
		s[i]=e.getText();
		System.out.println(s[i]);
		i++;
	}
	System.out.println("The working links are :...............");
	
	for(String s2:s)
	{
		d.findElement(By.linkText(s2)).click();;
		if(d.getTitle().equals(underConsTitle))
		{
			System.out.println("\""  +s2+  "\"" + "is under construction.");
		}
		else
		{
			System.out.println("\""  +s2+  "\"" +"is working.");
		}
		d.navigate().back();
    	Thread.sleep(2000);
    	
	}
	//d.quit();
	
	}
}
