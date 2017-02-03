package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BrowserSlider2 {
 WebDriver d;
 
 @BeforeMethod
    public void startup()
    {
      d=new FirefoxDriver();
    }
 
  @Test
    public void testScroll() throws InterruptedException{
	    d.manage().window().maximize();
        d.get("http://www.jabong.com/men/clothing/%22+%20%22?source=topnav");
      
       //Following is the code that scrolls through the page
        for (int second = 0;; second++)
         {
            if(second>=60)
            {
            	break;
            }
                ((RemoteWebDriver) d).executeScript("window.scrollBy(0,200)", "");
                Thread.sleep(3000);
         }
}
@AfterMethod
public void stop(){
    d.quit();
}
public boolean isElementPresent(WebDriver driver, By by){
    try{
        driver.findElement(by);
        return false;
    }catch(NoSuchElementException e){
        return true;
    }
}
}
