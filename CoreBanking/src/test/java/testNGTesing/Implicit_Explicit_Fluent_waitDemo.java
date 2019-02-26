
 /* 
 * Implicit wait
 * If we use this then it is applicable for entire session.
 * default wait time for next pulling is 250 ms
 * by default implicit wait is 0
 * 
 * Explicit wait - it is set for specific element or condition (not for entire session.)
 * Try not to use both waits in same script
 * 
 * Fluent wait
 * 
 */

package testNGTesing;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Implicit_Explicit_Fluent_waitDemo {
	
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	
	static String driverPath = projectPath+"/drivers/";
	
	
	@Test
	public void test() {
		
		
		 System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			//implicit wait
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			driver.findElement(By.name("q") ).sendKeys("ABCD");
			driver.findElement(By.name("q") ).sendKeys(Keys.RETURN);
			
			Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
					.withTimeout(30,TimeUnit.SECONDS)
					.pollingEvery(5,TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			
			WebElement element = wait.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
					WebElement linkElement = driver.findElement(By.linkText("ABCD - NIMH Data"));
					if (linkElement.isEnabled()) {
						System.out.println("Element Found");
						
					}
					return linkElement;
				}
			});
					
			element.click();
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
						
			//Explicit wait
	 		//WebDriverWait wait = new WebDriverWait(driver, 70);
	 		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("abcs")));
		
			driver.close();
	}

}
