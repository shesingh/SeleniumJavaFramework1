/* 
 * This Test covers:
 * Running Chrome headless. Means running test in chrome without launching it to save resources.
 */

package testNGTesing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessChromeDemo {

	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");

	static String driverPath = projectPath+"/drivers/";

	@Test
	public static void test() {

		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1280,800");

		driver = new ChromeDriver(options); 

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();


		System.out.println("Started");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q") ).sendKeys("ABCD");
		driver.findElement(By.name("q") ).sendKeys(Keys.RETURN);
		System.out.println("Completed");
		driver.close();
		driver.quit();


	}

}
