package junit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverelDemo {
  private WebDriver d;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    d = new FirefoxDriver();
    baseUrl = "https://www.google.co.in/";
    d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    d.get(baseUrl + "/?gfe_rd=cr&ei=JB99VIWyOaTV8gfPkYCoBg&gws_rd=ssl");
    d.manage().window().maximize();
    assertEquals("Google", d.getTitle());
   // d.findElement(By.id("gbqfq")).clear();
    //ID
    //d.findElement(By.id("gbqfq")).sendKeys("selenium");
    //Name
    //d.findElement(By.name("q")).sendKeys("Selenium");
    //Class Name
    //d.findElement(By.className("gbqfif")).sendKeys("Selenium");
    //Link Text
    //d.findElement(By.linkText("+You")).click();
    //Partial Link Text
    //d.findElement(By.partialLinkText("+")).click();
    //XPath
    //d.findElement(By.xpath("//a[contains(text(),'+You')]")).click();
    //Tag Name
    List<WebElement> links=d.findElements(By.tagName("a"));
    System.out.println("No of links:"+links.size());
    //d.findElement(By.id("gbqfb")).click();
    //CSS
    d.findElement(By.cssSelector("#gbqfq")).sendKeys("Selenium");
    
    Thread.sleep(6000);
  }

  @After
  public void tearDown() throws Exception {
    d.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  
}

