package testNG;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class LoginStatus {
	WebDriver d; 
	@Test
	public void testLinks() throws Exception
	{
		d.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
    	d.manage().window().maximize();
    	d.get("http://demo.exaact.co");
    	assertEquals("Target",d.getTitle());
    	//Read user name and password from xl-sheet
    	FileInputStream fis=new FileInputStream("H:\\lib\\Uma\\LoginTestData.xls");
    	Workbook wb=Workbook.getWorkbook(fis);
    	Sheet s=wb.getSheet("uma");
    	System.out.println("Row1:"+s.getCell(0, 0));
    	//Data write
    	FileOutputStream fos=new FileOutputStream("H:\\lib\\Uma\\LoginResults.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws=wwb.createSheet("LoginResult",0);
    	//copy old ---> new sheet
		for(int i=0;i<s.getRows();i++)
		{
			for(int j=0;j<s.getColumns();j++)
			{
				Label l=new Label(j,i,s.getCell(j, i).getContents());
				ws.addCell(l);
			}
		}
    	     	
    	
    	for(int i=1;i<s.getRows();i++)
    	{
    		d.findElement(By.xpath("//*[@id='loginusername']")).clear();
        	d.findElement(By.xpath("//*[@id='loginusername']")).sendKeys(s.getCell(1, i).getContents());
        	//Store username
        	String uname=d.findElement(By.xpath("//*[@id='loginusername']")).getAttribute("value");
        	System.out.println("Username is :"+uname);
        	d.findElement(By.id("loginpassword")).clear();
        	d.findElement(By.id("loginpassword")).sendKeys(s.getCell(1, i).getContents());
        	//Store password
        	String password=d.findElement(By.id("loginpassword")).getAttribute("value");

        	System.out.println("password is :"+password);
        	d.findElement(By.xpath("//*[@id='loginformsubmit']")).click();
        	System.out.println("enter the loop");
        	//Blank user name and password
        	if(uname.equals("") && password.equals(""))
        	{
        		assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginusername_error']/span")).getText());
        		assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginpassword_error']/span")).getText());
        		Label l=new Label(2,i,"Fail");
        		System.out.println("enter the 1 st loop............");
            	ws.addCell(l);
        	}
        	//Blank user name
        	else if(uname.equals(""))
        	{
        		assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginusername_error']/span")).getText());
        		Label l=new Label(2,i,"Fail");
        		ws.addCell(l);
        		System.out.println("enter the 2nd loop............");
            	
        	}
        	//Blank password
        	else if(password.equals(""))
        	{
        		assertEquals("Field is Required",d.findElement(By.xpath("//div[@id='loginpassword_error']/span")).getText());
        		Label l=new Label(2,i,"Fail");
        		ws.addCell(l);
        		System.out.println("enter the 3rd loop............");
            	
        	}
        	//Valid user name and password
        	else if(isElementPresent(d,By.xpath("//*[@id='logout']/a/img")))
        	{
        		d.findElement(By.xpath("//*[@id='logout']/a/img")).click();
        		Label l=new Label(2,i,"Pass");
        		ws.addCell(l);
        		System.out.println("enter the 4th loop............");
            	
        		
        	}
        	//invalid user name and password
        	else
        	{
        		assertEquals("x" + "\nAuthentication Failed!",d.findElement(By.xpath("//*[@id='serverErrors']/div")).getText());
        		Label l=new Label(2,i,"Fail");
        		ws.addCell(l);
        		System.out.println("enter the 5th loop............");
            	
        	}
        	
        	    	
        	Thread.sleep(11000);
    	}
    		
    	wwb.write();
    	wwb.close();
    
	}
	   
	private boolean isElementPresent(WebDriver driver,By by)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium JAR Files\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "H:\\Selenium JAR Files\\chromedriver.exe");
		//d=new ChromeDriver();
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
