package testNG;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class FacebookLogin {
	 
	WebDriver d;
	
	@Test
	public  void testSync() throws InterruptedException {
		
	    d=new FirefoxDriver();
	    d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
		d.get("http://www.google.com");
		assertEquals("Google",d.getTitle());
		System.out.println(d.getTitle());
		d.findElement(By.id("gbqfq")).sendKeys("http://www.facebook.com");
		d.findElement(By.id("gbqfb")).click();
		d.findElement(By.linkText("Welcome to Facebook - Log In, Sign Up or Learn More")).click();
		assertEquals("http://www.facebook.com - Google Search",d.getTitle());
		System.out.println(d.getTitle());
		d.findElement(By.id("email")).sendKeys("dirisalauma@gmail.com");
		d.findElement(By.id("pass")).sendKeys("umasukku");
		d.findElement(By.id("u_0_n")).click();
		assertEquals("Facebook",d.getTitle());
		System.out.println(d.getTitle());
		d.navigate().refresh();
		
		//sending a post..........
		//d.findElement(By.xpath("//form/div/div/ul/li/a/span")).click();
		//d.findElement(By.id("u_0_w")).sendKeys("Hai Friends.........");
		//d.findElement(By.xpath("//form[@id='u_0_s']/div/div[6]/div/ul/li[2]/button")).click();
		
		d.findElement(By.cssSelector("#userNavigationLabel")).click();
		d.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div/div[1]/ul/li[6]/div/div[2]/ul/li[10]/form/label/input")).click();
		
		Select s=new Select(d.findElement(By.cssSelector("label.uiLinkButton.navSubmenu")));
		s.selectByIndex(7);
		
			
		Thread.sleep(20000);
		System.out.println("@Test Method");
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
	@After
	public void tearDown()
	{
		System.out.println("@After Method");
	

	}
}
	