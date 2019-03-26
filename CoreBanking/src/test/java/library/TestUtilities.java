/*
 * This class covers:
 * Method for taking screen shot.
 * 
 *
 */


package library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestUtilities
{

	public static void captureScreenShot(WebDriver driver, String screenShotName){
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);

			//In below line .jpg extension was not working for me but this png worked.
			FileUtils.copyFile(srcFile, new File ("./screenShots/"+screenShotName+".png"));

			System.out.println("Screen shot taken");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screen shot."+e.getMessage());
			e.printStackTrace();
		}
		//System.out.println("screen shot captured");

	}//ScreenShotForfailedStep function


	//Explicit wait  - ClickOn Element when it is available
	//there are lots of conditions and elementToBeClickable is one of them.
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}












