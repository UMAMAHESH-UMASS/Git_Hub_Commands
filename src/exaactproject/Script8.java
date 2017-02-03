package exaactproject;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

	public class Script8 {
		WebDriver d;
		    
		    @Test
			public void test() throws Exception {
		    
		    d=new FirefoxDriver();	
		    System.setProperty("webdriver.chrome.driver", "H:\\lib\\chromedriver.exe");
			//d=new ChromeDriver();
			
			d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
			d.manage().window().maximize();
			d.get("http://www.google.com");
			d.findElement(By.id("gbqfq")).sendKeys("http://www.demo.exaact.co");
			d.findElement(By.id("gbqfb")).click();
			d.findElement(By.linkText("Target")).click(); 
			d.findElement(By.id("loginusername")).sendKeys("admin@exaact.co");
			d.findElement(By.id("loginpassword")).sendKeys("123456");
			d.findElement(By.id("loginformsubmit")).click();
			
			//click salt module
			d.findElement(By.className("salt")).click();
			d.findElement(By.className("setting")).click();
			d.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[4]/div/div[2]/div/div/div/div[1]/a")).click();
			Thread.sleep(1000);
			
			//create Task
			d.findElement(By.id("tasks")).click();
			d.findElement(By.id("taskCreate")).click();
			d.findElement(By.id("taskAddaTask")).sendKeys(" ");
			Select s=new Select(d.findElement(By.id("taskFor")));
			s.selectByIndex(1);
			d.findElement(By.id("name")).sendKeys("9010720710");
			Select s1=new Select(d.findElement(By.id("taskTaskCategory")));
			s1.selectByIndex(1);
			Select s2=new Select(d.findElement(By.id("taskStatusId")));
			s2.selectByIndex(6);
			Select s3=new Select(d.findElement(By.id("taskAssignedTo")));
			s3.selectByValue("114");
			d.findElement(By.id("description")).sendKeys("hai task created");
			
			
			
			Thread.sleep(2000);
			//create Deal
			d.findElement(By.id("deals")).click();
			//d.findElement(By.id("dealCreate")).click();
			
			//create quotation
			d.findElement(By.id("quotation")).click();
			d.findElement(By.id("quotationCreate")).click();
			d.findElement(By.id("qtnGeneralName")).click();
			Select dd=new Select(d.findElement(By.id("qtnGeneralQuatationStatus")));
			dd.selectByIndex(1);
			d.findElement(By.id("dealId")).click();
			d.findElement(By.id("defaultImage")).click();
			Select dd1=new Select(d.findElement(By.id("qtnGeneralQuatationType")));
			dd1.selectByIndex(3);
			Select dd2=new Select(d.findElement(By.id("qtnGeneralQuatationRequestedService")));
			dd2.selectByIndex(4);
			
			
			
			System.out.println("@Test method executed");
			Thread.sleep(10000);
			
		    }
		    
		    @Before
		    public void setup()
		    {
		    	System.out.println("@Before Method");
		    }
		    
		    @After
		    public void teardown()
		    {
		    	System.out.println("@After Method Exucted");
		    	d.quit();
		    	d.close();
		    }
}