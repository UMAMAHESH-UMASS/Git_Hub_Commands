package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {
	WebDriver d;

	@Test
	public  void testSync() throws InterruptedException {
		
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
		d.manage().window().maximize();
		d.get("http://www.google.com");
		assertEquals("Google",d.getTitle());
		d.findElement(By.id("gbqfq")).sendKeys("www.gmail.com");
		d.findElement(By.linkText("Gmail - Google")).click();
		assertEquals("Gmail",d.getTitle());
		d.findElement(By.id("Email")).sendKeys("uvrkponnur@gmail.com");
		d.findElement(By.id("Passwd")).sendKeys("9701689945");
		d.findElement(By.id("signIn")).click();
		d.findElement(By.xpath("//div[@id=':81']/div/div")).click();
		d.findElement(By.xpath("//div[@id=':kx']")).click();
		d.navigate().refresh();
		
		d.findElement(By.xpath("//textarea[@id=':i7']")).sendKeys("dirisalauma@gmail.com");
		d.findElement(By.xpath("//div[@id=':il']/input")).sendKeys("Hai");
		d.findElement(By.xpath("//div[@id=':hf']/div")).sendKeys("Hi This is Ramkrishna");
		d.findElement(By.xpath("//div[@id=':kr']/div[2]")).click();
		
		
		d.findElement(By.linkText("uvrkponnur@gmail.com")).click();
		d.findElement(By.id("gb_71")).click();		
		d.findElement(By.className("gb_C gb_Sa")).click();
		System.out.println("@Text Method");
		Thread.sleep(1000);
		
			
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
	

	}

}


