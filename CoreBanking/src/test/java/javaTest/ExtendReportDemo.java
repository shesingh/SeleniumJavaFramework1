/*
 * This class covers:
 * ExtendReport functions
 * All statements are available http://extentreports.com/docs/versions/4/java/
 */

package javaTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageElements_POM.GoogleSearchPage;


public class ExtendReportDemo {
	
	static WebDriver driver = null;
	static String projectPath = System.getProperty("user.dir");
	static String driverPath = projectPath+"/drivers/";
			
	public static void main(String args[]) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(projectPath+"/extendReports/extentReport.html");
		    
	    // create ExtentReports and attach reporter(s)
	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	     
	    ExtentTest test1 = extent.createTest("Google Search Test 1", "This is test to validate google search functionality.");
		
	    System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		test1.log(Status.INFO, "Starting test case");
		driver.get("http://www.google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation step by step");
		test1.pass("Entered text in search box");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
		test1.pass("Pressed Enter Key from Keyboard.");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close(); 
		driver.quit();
		test1.pass("Browser closed");
		
		test1.info("Test Completed");
		
		extent.flush();
		
	}

}
