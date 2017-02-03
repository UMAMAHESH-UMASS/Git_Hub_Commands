package exaactproject;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exaact {
	WebDriver d;
	    
	    @Test
		public void test() throws Exception {
		
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
		d.manage().window().maximize();
		d.get("http://www.google.com");
		d.findElement(By.id("gbqfq")).sendKeys("http://www.demo.exaact.co");
		d.findElement(By.id("gbqfb")).click();
		d.findElement(By.linkText("Target")).click(); 
		d.findElement(By.id("loginusername")).sendKeys("admin@exaact.co");
		d.findElement(By.id("loginpassword")).sendKeys("123456");
		d.findElement(By.id("loginformsubmit")).click();
		d.findElement(By.className("salt")).click();
		d.findElement(By.className("setting")).click();
		
		d.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[4]/div/div[2]/div/div/div/div[7]/a")).click();
		
		//create groups
		//1st group
		d.findElement(By.id("groupCreate")).click();
		d.findElement(By.id("mainModulesId")).click();
		d.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/div/div/div[4]/form/div[2]/div[2]/select/option[2]")).click();
	  
	    Select dd=new Select(d.findElement(By.id("mainModulesId")));
		dd.selectByIndex(1);
		d.findElement(By.id("groupName")).sendKeys("SALES MANAGER");
		d.findElement(By.id("groupcode")).sendKeys("SM");
		d.findElement(By.id("groupdesc")).sendKeys("sales manager group is created");
		d.findElement(By.id("isAdminGroup_adminGroup")).click();
		d.findElement(By.id("groupSubmit")).click();
		Thread.sleep(1000);
		
		//2nd group
		d.findElement(By.id("groupCreate")).click();
		d.findElement(By.id("mainModulesId")).click();
		d.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/div/div/div[4]/form/div[2]/div[2]/select/option[2]")).click();
	  	Select dd1=new Select(d.findElement(By.id("mainModulesId")));
		dd1.selectByIndex(1);
		d.findElement(By.id("groupName")).sendKeys("SALES USER");
		d.findElement(By.id("groupcode")).sendKeys("SU");
		d.findElement(By.id("groupdesc")).sendKeys("sales user group is created");
		d.findElement(By.id("isAdminGroup_adminGroup")).click();
		d.findElement(By.id("groupSubmit")).click();
		Thread.sleep(1000);
		
		//3rd group
		d.findElement(By.id("groupCreate")).click();
		//d.findElement(By.id("mainModulesId")).click();
		//d.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/div/div/div[4]/form/div[2]/div[2]/select/option[2]")).click();
	  	Select dd2=new Select(d.findElement(By.id("mainModulesId")));
		dd2.selectByIndex(1);
		d.findElement(By.id("groupName")).sendKeys("OPERATIONAL MANAGER");
		d.findElement(By.id("groupcode")).sendKeys("OP");
		d.findElement(By.id("groupdesc")).sendKeys("operational manager group is created");
		d.findElement(By.id("isAdminGroup_adminGroup")).click();
		d.findElement(By.id("groupSubmit")).click();
		Thread.sleep(1000);
		
		//4th group
		d.findElement(By.id("groupCreate")).click();
		d.findElement(By.id("mainModulesId")).click();
		d.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[6]/div/div/div/div[4]/form/div[2]/div[2]/select/option[2]")).click();
	  	Select dd3=new Select(d.findElement(By.id("mainModulesId")));
		dd3.selectByIndex(1);
		d.findElement(By.id("groupName")).sendKeys("OPERATIONAL USER");
		d.findElement(By.id("groupcode")).sendKeys("OU");
		d.findElement(By.id("groupdesc")).sendKeys("operational user group is created");
		d.findElement(By.id("isAdminGroup_adminGroup")).click();
		d.findElement(By.id("groupSubmit")).click();
		Thread.sleep(1000);
		
		//create 1st user
		d.findElement(By.id("leftMenuUsers")).click();
		d.findElement(By.id("userCreate")).click();
		d.findElement(By.id("userFirstName")).sendKeys("        ");
		d.findElement(By.id("userLastName")).sendKeys("        ");
		d.findElement(By.id("userEmail")).sendKeys("        ");
		d.findElement(By.id("userPassword")).sendKeys("        ");
		d.findElement(By.id("userPhone")).sendKeys("        ");
		d.findElement(By.id("fax")).sendKeys("        ");
		d.findElement(By.id("officePhone")).sendKeys("        ");
		Select dd4=new Select(d.findElement(By.id("userPermissionGroupId")));
		dd4.selectByIndex(1);
		d.findElement(By.id("contactAddress1")).sendKeys("        ");
		d.findElement(By.id("contactAddress2")).sendKeys("        ");
		d.findElement(By.id("contactCity")).sendKeys("        ");
		d.findElement(By.id("contactState")).sendKeys("        ");
		d.findElement(By.id("contactZip")).sendKeys("        ");
		Select dd5=new Select(d.findElement(By.id("contactCountry")));
		dd5.selectByIndex(99);
		d.findElement(By.id("userSubmit")).click();
		d.findElement(By.id("userSubmit")).click();
		Thread.sleep(1000);
		
		//create 2nd user
				d.findElement(By.id("leftMenuUsers")).click();
				d.findElement(By.id("userCreate")).click();
				d.findElement(By.id("userFirstName")).sendKeys("        ");
				d.findElement(By.id("userLastName")).sendKeys("        ");
				d.findElement(By.id("userEmail")).sendKeys("        ");
				d.findElement(By.id("userPassword")).sendKeys("        ");
				d.findElement(By.id("userPhone")).sendKeys("        ");
				d.findElement(By.id("fax")).sendKeys("        ");
				d.findElement(By.id("officePhone")).sendKeys("        ");
				Select dd6=new Select(d.findElement(By.id("userPermissionGroupId")));
				dd6.selectByIndex(1);
				d.findElement(By.id("contactAddress1")).sendKeys("        ");
				d.findElement(By.id("contactAddress2")).sendKeys("        ");
				d.findElement(By.id("contactCity")).sendKeys("        ");
				d.findElement(By.id("contactState")).sendKeys("        ");
				d.findElement(By.id("contactZip")).sendKeys("        ");
				Select dd7=new Select(d.findElement(By.id("contactCountry")));
				dd7.selectByIndex(99);
				d.findElement(By.id("userSubmit")).click();
				d.findElement(By.id("userSubmit")).click();
				Thread.sleep(1000);
				
				//create 3rd user
				d.findElement(By.id("leftMenuUsers")).click();
				d.findElement(By.id("userCreate")).click();
				d.findElement(By.id("userFirstName")).sendKeys("        ");
				d.findElement(By.id("userLastName")).sendKeys("        ");
				d.findElement(By.id("userEmail")).sendKeys("        ");
				d.findElement(By.id("userPassword")).sendKeys("        ");
				d.findElement(By.id("userPhone")).sendKeys("        ");
				d.findElement(By.id("fax")).sendKeys("        ");
				d.findElement(By.id("officePhone")).sendKeys("        ");
				Select dd8=new Select(d.findElement(By.id("userPermissionGroupId")));
				dd8.selectByIndex(1);
				d.findElement(By.id("contactAddress1")).sendKeys("        ");
				d.findElement(By.id("contactAddress2")).sendKeys("        ");
				d.findElement(By.id("contactCity")).sendKeys("        ");
				d.findElement(By.id("contactState")).sendKeys("        ");
				d.findElement(By.id("contactZip")).sendKeys("        ");
				Select dd9=new Select(d.findElement(By.id("contactCountry")));
				dd9.selectByIndex(99);
				d.findElement(By.id("userSubmit")).click();
				d.findElement(By.id("userSubmit")).click();
				Thread.sleep(1000);				
		
				//create 1st user
				d.findElement(By.id("leftMenuUsers")).click();
				d.findElement(By.id("userCreate")).click();
				d.findElement(By.id("userFirstName")).sendKeys("        ");
				d.findElement(By.id("userLastName")).sendKeys("        ");
				d.findElement(By.id("userEmail")).sendKeys("        ");
				d.findElement(By.id("userPassword")).sendKeys("        ");
				d.findElement(By.id("userPhone")).sendKeys("        ");
				d.findElement(By.id("fax")).sendKeys("        ");
				d.findElement(By.id("officePhone")).sendKeys("        ");
				Select dd10=new Select(d.findElement(By.id("userPermissionGroupId")));
				dd10.selectByIndex(1);
				d.findElement(By.id("contactAddress1")).sendKeys("        ");
				d.findElement(By.id("contactAddress2")).sendKeys("        ");
				d.findElement(By.id("contactCity")).sendKeys("        ");
				d.findElement(By.id("contactState")).sendKeys("        ");
				d.findElement(By.id("contactZip")).sendKeys("        ");
				Select dd11=new Select(d.findElement(By.id("contactCountry")));
				dd11.selectByIndex(99);
				d.findElement(By.id("userSubmit")).click();
				d.findElement(By.id("userSubmit")).click();
				Thread.sleep(1000);		
		
		//logout
		d.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/span[6]/span/a/img")).click();
		
		System.out.println("@Text Method");
		Thread.sleep(13000);
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
