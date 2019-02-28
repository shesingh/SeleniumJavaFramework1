/*
 * This class covers:
 * Capturing screen shot for failed test case.
 * Add commons-io dependency in Maven POM file.
 * Note: This class is using 2 functions defined in Test Utilities.
 * 
 * 
 * In folder test-output, file testng-failed.xml - It put all failed test case ...just run that testng file
 */
package testNGTesing;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import library.SetupBase;
import listerners.CustomListener;


@Listeners(CustomListener.class)
public class ScreenShotForFailedTestCase_RerunFailedTest extends SetupBase {

	@BeforeMethod
	public void setup() {
		initialization();
	}

	@Test (priority =1,groups ="Regression", retryAnalyzer = listerners.RetryAnalyzer.class )
	public void test1() {
		System.out.println("test1");
		WebElement SearchBox = driver.findElement(By.xpath("//input[@title='Search']"));
		SearchBox.sendKeys("A B C D");
		SearchBox.sendKeys(Keys.RETURN);
		//Failing the test so that it can capture screen shot.
		Assert.assertEquals(false, true);
	}


	@Test (priority =2,groups ="Regression")
	public void test2() {
		System.out.println("test2");
		Assert.assertEquals(false, true);
	}

	@Ignore
	@Test (priority =3,groups ="Regression")
	public void test3() {
		System.out.println("test3");
		Assert.assertEquals(false, true);
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}


}


