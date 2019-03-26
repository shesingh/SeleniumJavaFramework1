/* 
 * This Test covers:
 * 1. Running Chrome headless. Means running test in chrome without launching it to save resources.
 * 
 * 2. Using selenium-htmlunit-driver; for this just download respective maven dependency.
 * HtmlUnitDriver() was available in selenium till version below selenium 3.X now we need to download it seperately.
 *
 * Headless Browser
 * 1. Testing is fast as no browser is launched.
 * 2. Not suitable for Action class...user action....like mousemovement, doubleclick, drag and drop
 * 3. Also called ghost browsers....ex. HtmlUnitDriver (Java), PhantomJS  (JavaScript)
 *
 */

package testNGTesing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessChromeOrHtmlUnitDriver {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");

	static String driverPath = projectPath+"/drivers/";

	@Test
	public static void test() {

		//1. Using Chrome headless browser
		/*
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1280,800");
		driver = new ChromeDriver(options);
		*/


		//2. Using Selenium HtmlUnitDriver browser
		System.out.println("Declaring HTML headless driver");
		WebDriver driver = new HtmlUnitDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		System.out.println("Started");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q") ).sendKeys("ABCD");
		driver.findElement(By.name("q") ).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());
		System.out.println("Completed");
		driver.close();
		driver.quit();

	}

}
