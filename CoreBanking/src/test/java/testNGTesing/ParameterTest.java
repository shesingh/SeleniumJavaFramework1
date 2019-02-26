/*
 * This class covers:
 * Parameterization
 * Parameters are coming from testng.xml file, parameter tag.
 */

package testNGTesing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	String driverPath = "/Users/shefali.singh.GROUPINFRA/03 Selenium/Drivers/";

	@BeforeMethod
	@Parameters("browser")
	public void setUP(String browser) {
		
		if (browser.contentEquals("chrome")) {
	    System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		if (browser.contentEquals("firefox")) {
		    System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
   
	
	@Test
	@Parameters({"url","email"})
	public void login(String url, String emailID ) {
		driver.get(url);
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(emailID);
		
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
	}
	
	
	@AfterMethod
	   public void tearDown() {
		   driver.quit();
	   }


}
