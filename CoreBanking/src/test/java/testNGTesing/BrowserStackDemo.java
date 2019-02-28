/* This class covers:
 * Web Site is https://browserstack.com.
 * It provide multibrowser testing on various operating system. Mobile simulator, real device testing plateform.
 * 
 * For this we need Browser stack account user name & Access key.
 * we are going to specify the test url using above information.
 * 
 * After that we have to set the DesiredCapabilities of chosen browser. For this we can even take help of "Capability generator"
 * available on browser stack.
 */

package testNGTesing;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackDemo {

	  public static final String USERNAME = "YOUR USER NAME";
	  public static final String AUTOMATE_KEY = "YOUR ACCESS KEY";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  public static void main(String[] args) throws Exception {

	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "62.0");
	    caps.setCapability("project", "Test");
	    caps.setCapability("build", "Build1");
	    caps.setCapability("name", "Test1");
	    caps.setCapability("browserstack.local", "false");
	    caps.setCapability("browserstack.networkLogs", "true");
	    caps.setCapability("browserstack.selenium_version", "3.5.2");
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();

	  }
}
