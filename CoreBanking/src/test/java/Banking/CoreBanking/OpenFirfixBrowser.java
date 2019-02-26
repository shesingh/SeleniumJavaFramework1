package Banking.CoreBanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenFirfixBrowser {

		
		String driverPath = "C:\\Users\\shefali.singh.GROUPINFRA\\03 Selenium\\Drivers\\";
		public WebDriver driver;
		
		@Test (priority =1)
		public void launchBrowser() {
			System.out.println("launching firefox browser"); 
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
		}

		@Test (priority = 2)
		public void openApplication() {
			driver.navigate().to("http://www.google.com");
		}
		
		@Test (priority = 3)
		public void closeDriver() {
			if(driver!=null) {
				driver.close();
			}
		}
	}
	

