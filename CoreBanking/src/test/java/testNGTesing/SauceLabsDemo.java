/* This class covers:
 * Web Site is https://saucelabs.com.
 * It provide multibrowser testing on various operating system. Mobile simulator, real device testing plateform.
 * Check all the options on https://saucelabs.com/platforms
 * 
 * For this we need Sauce lab account user name & Access key.
 * we are going to specify the test url using above information.
 * 
 * After that we have to set the DesiredCapabilities of chosen browser. For this we can even take help of "Plateform Configurator"
 * available on sauce lab.
 */

package testNGTesing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {
	
	public static final String USERNAME = "YOUR_USERNAME";
	public static final String ACCESS_KEY = "YOUR ACCESS KEY";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "GoogleTest1");
		caps.setCapability("extendedDebugging", "true");
		caps.setCapability("buildNumber", "3.0");

		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);

//		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());
		
		driver.quit();
		System.out.println("Test Completed");
	}

}


