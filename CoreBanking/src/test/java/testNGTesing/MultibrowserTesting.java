/*
 * This class covers:
 * Multibrowser Testing
 * 
 *  Note - for creating testng.xml....select this class ->right click->TestNG->Convert to TestNG
 * In testng.xml file put cursor on parallel and press F2, we can see values of parallel like- true, false, tests, classes, methods etc
 */


package testNGTesing;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class MultibrowserTesting {
	
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	
	static String driverPath = projectPath+"/drivers/";
	

   @BeforeMethod
   @Parameters("browser")
	public void setup(String browser) {
	   System.out.println("Browser name is: "+browser);
	   
	   if (browser.equalsIgnoreCase("chrome")) {
		    System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		    System.out.println("Thread id: "+Thread.currentThread().getId());
		    System.out.println("Thread Name: "+Thread.currentThread().getName());
			driver = new ChromeDriver();
			}
			
		if (browser.equalsIgnoreCase("firefox")) {
			    System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
				driver = new FirefoxDriver();
			}
		
		if (browser.equalsIgnoreCase("ie")) {
		    System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer64.exe");
			driver = new InternetExplorerDriver();
			}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
   
      
   @Test 
   public void test1() {
	   System.out.println("test1");
   }
   
   /*
   @Test 
   public void test2() {
	   System.out.println("test2");
   }
   
   @Test 
   public void test3() {
	   System.out.println("test3");
   }*/
   
   @AfterMethod
   public void tearDown() {
	 driver.quit();
   }

}
