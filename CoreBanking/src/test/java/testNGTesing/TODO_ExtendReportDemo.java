/*
 * This class covers:
 * ExtendReport functions
 * All statements are available http://extentreports.com/docs/versions/4/java/
 * Please see To DO comments:
 * 
 */

package testNGTesing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import library.SetupBase;
import pageElements_POM.GoogleSearchPage;
import pageElements_POM.GoogleSearchPgElementsAndMethods;


public class TODO_ExtendReportDemo {
	
	static String projectPath = System.getProperty("user.dir");
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	
	
	@BeforeSuite
	public void startReport() {
		
		
		/*
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(projectPath+"/extendReports/extentReport.html");
	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    //Send them to @Test 
	    ExtentTest test1 = extent.createTest("Google Search Test 1", "This is test to validate google search functionality.");
		test1.log(Status.INFO, "Starting test case");
		//Send this to @After
		extent.flush();
		
		*/
    }
	
	
	@BeforeMethod
	public void setup() {
		SetupBase.initialization();
		}
	
	@Test
	public static void main() {
		
	    /*
		test1.pass("Navigated to google.com");
		test1.pass("Entered text in search box");
		test1.pass("Pressed Enter Key from Keyboard.");
		test1.pass("Browser closed");
		test1.info("Test Completed");
		*/
		
	}
	
	@AfterMethod
	   public void tearDown() {
			//SetupBase.closure();
		//driver.close();   
		//driver.quit();
		}

	
	@AfterSuite
	public void end() {
		
    }
}
