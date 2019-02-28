/*
 * This class covers:
 * Act as Base Class for other test cases.
 * Have initialization module for @beforeMethod setup module.
 * Have module to capture screen shots for failed steps.
 * 
 */

package library;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SetupBase {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	static String driverPath = projectPath+"/drivers/";
	static String browser = null;


	public static void initialization() {

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
		//driver.get("http://www.google.com");
	}



}
