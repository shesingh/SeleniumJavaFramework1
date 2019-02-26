/*
 * This class covers:
 * Act as Base Class for other test cases.
 * Have initialization module for @beforeMethod setup module.
 * Have module to capture screen shots for failed steps.
 * 
 */

package TestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SetupBase {
	
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	
	static String driverPath = projectPath+"/drivers/";
	static String browser = null;
	
	static String screenshotFilePath = projectPath+"/screenShots/";
	
	public static void initialization() {
		//System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		//driver = new ChromeDriver(); 
		PropertyFile.getProperties();
		
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
		driver.get("http://www.google.com");
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 70);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("abcs")));
		
	}
	
	
	/*
	public static void closure() {
		
	   }*/

	
	public void ScreenShotForfailedStep(String testMethodName){
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
			try {
				System.out.println("About to take screen shot");
				FileUtils.copyFile(srcFile, new File (screenshotFilePath+testMethodName+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
	
	
	
}
