package selenium;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class LoginStatus {
	WebDriver d; 
	@Test
	public void testLinks() throws Exception
	{
		d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    	d.manage().window().maximize();
    	d.get("http://192.168.1.7:8080/abc-v01/");
    	assertEquals("ABC Bank Login",d.getTitle());
    	//Read user name and password from xl-sheet
    	FileInputStream fis=new FileInputStream("H:\\lib\\Uma\\LoginTestData.xls");
    	Workbook wb=Workbook.getWorkbook(fis);
    	Sheet s=wb.getSheet("Sheet1");
    	//Data write
    	FileOutputStream fos=new FileOutputStream("H:\\lib\\Uma\\LoginResults.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws=wwb.createSheet("Results", 0);
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
    		d.findElement(By.name("userName")).clear();
        	d.findElement(By.name("userName")).sendKeys(s.getCell(0, i).getContents());
        	//Store username
        	String uname=d.findElement(By.name("userName")).getAttribute("value");
        	d.findElement(By.name("password")).clear();
        	d.findElement(By.name("password")).sendKeys(s.getCell(1, i).getContents());
        	//Store password
        	String password=d.findElement(By.name("password")).getAttribute("value");
        	d.findElement(By.cssSelector("input.button")).click();
        	//Blank user name and password
        	if(uname.equals("") && password.equals(""))
        	{
        		assertEquals("User Name is required.",d.findElement(By.xpath("//div[@id='main']/div/form/font")).getText());
        		assertEquals("Password is required.",d.findElement(By.xpath("//div[@id='main']/div/form/font[2]")).getText());
        		Label l=new Label(2,i,"Fail");
        		ws.addCell(l);
        	}
        	//Blank user name
        	else if(uname.equals(""))
        	{
        		assertEquals("User Name is required.",d.findElement(By.xpath("//div[@id='main']/div/form/font")).getText());
        		Label l=new Label(2,i,"Fail");
        		ws.addCell(l);
        	}
        	//Blank password
        	else if(password.equals(""))
        	{
        		assertEquals("Password is required.",d.findElement(By.xpath("//div[@id='main']/div/form/font[2]")).getText());
        		Label l=new Label(2,i,"Fail");
        		ws.addCell(l);
        	}
        	//Valid user name and password
        	else if(isElementPresent(d,By.linkText("Log Out")))
        	{
        		d.findElement(By.linkText("Log Out")).click();
        		Label l=new Label(2,i,"Pass");
        		ws.addCell(l);
        	}
        	//invalid user name and password
        	else
        	{
        		assertEquals("Invalid UserName and Password.",d.findElement(By.xpath("//div[@id='main']/div/div/font")).getText());
        		Label l=new Label(2,i,"Fail");
        		ws.addCell(l);
        	}
        	
        	    	
        	Thread.sleep(1000);
    	}
    		
    	wwb.write();
    	wwb.close();
    
	}
	   
	private boolean isElementPresent(WebDriver driver,By by)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
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
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Nov14\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
