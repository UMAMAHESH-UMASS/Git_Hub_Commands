package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementsDemo {

		WebDriver d;
		
		@Before
		public void setUp()
		{
		 d = new FirefoxDriver();
		}
		@Test
		public void testWebElements() throws Exception
		{
			d.get("http://book.theautomatedtester.co.uk/");
			assertEquals("Selenium: Beginners Guide",d.getTitle());
			WebElement tfield=d.findElement(By.id("q"));
			tfield.sendKeys("Selenium");
			System.out.println("Text field value is:"+(tfield.getAttribute("value")));
			assertEquals("Selenium",tfield.getAttribute("value"));
			d.findElement(By.linkText("Chapter1")).click();
				//Radio button
				WebElement radio=d.findElement(By.id("radiobutton"));
				if(radio.isSelected())
				{
					System.out.println("Radio button is already selected");
				}
				else
				{
					radio.click();
				}
				//Check box
				WebElement checkbox=d.findElement(By.name("selected(1234)"));
				if(checkbox.isSelected())
				{
					System.out.println("Check box is already selected");
				}
				else
				{
					checkbox.click();
				}
				d.findElement(By.id("html5div")).clear();
				d.findElement(By.id("html5div")).sendKeys("Selenium");
				//DD
				Select dd=new Select(d.findElement(By.id("selecttype")));
				dd.selectByIndex(2);
				WebElement selectedoption=dd.getFirstSelectedOption();
				System.out.println("The selected option name:"+selectedoption.getText());
				assertTrue(d.getPageSource().contains("Selenium"));
				/*if(d.getPageSource().contains("Selenium"))
				{
					System.out.println("Selenium text available in the webpage");
				}
				else
				{
					System.out.println("Selenium text io not available in the webpage");
				}*/
				Thread.sleep(6000);
		}
		@After
		public void tearDown()
		{
			d.quit();
		}
			
		
		

	}

