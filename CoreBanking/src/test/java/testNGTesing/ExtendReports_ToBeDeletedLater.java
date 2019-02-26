package testNGTesing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import TestUtility.SetupBase;
import pageElements_POM.GoogleSearchPgElementsAndMethods;

public class ExtendReports_ToBeDeletedLater extends SetupBase{
	
	GoogleSearchPgElementsAndMethods searchPageOb;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void createReport() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(projectPath+"/extendReports/extentReport.html");
	    
	    // create ExtentReports and attach reporter(s)
	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	}
	
	
	@BeforeMethod
	public void setUP() {
		SetupBase.initialization();
					
		//driver object is set so now calling constructor to pass driver object.	
		searchPageOb = new GoogleSearchPgElementsAndMethods(driver);
		}
	
	@Test (priority =1)
	   public void performSearch() throws Exception {
		ExtentTest test1 = extent.createTest("Google Search Test 1", "This is test to validate google search functionality.");
		
		searchPageOb.setTextInSearchBox("Step by Step Automation");
		searchPageOb.clickSearchButton();	
		
		// log(Status, details)
        test1.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test1.info("This step shows usage of info(details)");
        
        // log with snapshot
        test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test1.addScreenCaptureFromPath("screenshot.png");
				
		}
	
	/*
	@Test (priority =2)
	  public void dummyFailTest() throws Exception {
		ExtentTest test2 = extent.createTest("Google Search Test 1", "This is test to validate google search functionality.");
		
		
		// log(Status, details)
     test2.log(Status.INFO, "This step shows usage of log(status, details)");

     // info(details)
     test2.info("This step shows usage of info(details)");
     
     // log with snapshot
     test2.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
     
     // test with snapshot
     test2.addScreenCaptureFromPath("screenshot.png");
				
		}*/
	
	@AfterMethod
	   public void tearDown() {
			//SetupBase.closure();
		driver.close();   
		driver.quit();
			
		}

	@AfterSuite
	   public void flushReport() {
			
			extent.flush();
		}
	
	
}
