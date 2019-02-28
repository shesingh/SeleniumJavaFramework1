/*
 * This class covers:
 * Method for taking screen shot.
 */


package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

}
