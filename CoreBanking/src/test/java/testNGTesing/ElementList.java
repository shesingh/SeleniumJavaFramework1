/*
 * This class covers:
 * Setup & tearDown methods for Chrome Browser launch
  * Using Assert method test google title & logo
  * find elements method
  * 
  */

package testNGTesing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ElementList {
	
		WebDriver driver;
		String driverPath = "/Users/shefali.singh.GROUPINFRA/03 Selenium/Drivers/";

   @BeforeMethod
	public void setUP() {
	   System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
   
   
   @Test(enabled =false)
      public void noOfInputElements() {
	   List<WebElement> ListOfInputElements = driver.findElements(By.xpath("//input"));
	   int count = ListOfInputElements.size();
	   System.out.println("No of Input Elements: "+count);
   }
   
   @Test 
   public void performSearch() {
	   driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation step by step");
	   driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
   }
   
   @Test  (priority =1,groups ="Home Page", enabled =false)
   public void googleTittleTest() {
	   String title = driver.getTitle();
	   System.out.println(title);
	   
	   Assert.assertEquals(title, "Google", "title is not matched");
   }
   
   
   @Test (priority =2, groups ="Home Page",enabled =false)
   public void googleLogoTest() {
	   boolean b = driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
	   System.out.println(b);
	   Assert.assertTrue(b);
	   //Another way below
	   //Assert.assertEquals(b, true);
	  
   }
   
         
   @AfterMethod
   public void tearDown() {
	   driver.quit();
   }

}

