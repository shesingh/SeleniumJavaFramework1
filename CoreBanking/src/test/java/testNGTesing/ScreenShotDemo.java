package testNGTesing;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.SetupBase;
import library.TestUtilities;

public class ScreenShotDemo extends SetupBase{

	@BeforeMethod
	public void setup() {
		SetupBase.initialization();
	}

	@Test
	public static void mainTest() {

		System.out.println("DONE");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		String testName= Thread.currentThread().getStackTrace()[1].getMethodName();
		TestUtilities.captureScreenShot(driver,testName);
		//TestUtilities.captureScreenShot(driver,"EnterSearchText");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();   

	}

} //main class
