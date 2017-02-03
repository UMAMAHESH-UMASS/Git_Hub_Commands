package testNG;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataImport {
	WebDriver d; 
	@Test
	public void dataImport() throws Exception
	{
	d.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    	d.manage().window().maximize();
    	d.get("http://www.google.com");
    	assertEquals("Google",d.getTitle());
    	FileInputStream fis=new FileInputStream("H:\\lib\\Uma\\Dataimport.xls");
    	Workbook wb=Workbook.getWorkbook(fis);
    	Sheet s=wb.getSheet(0);
    	for(int i=0;i<s.getRows();i++)
    	{
    		d.findElement(By.name("q")).clear();
    		d.findElement(By.name("q")).sendKeys(s.getCell(0,i).getContents());
    		Thread.sleep(2000);
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
