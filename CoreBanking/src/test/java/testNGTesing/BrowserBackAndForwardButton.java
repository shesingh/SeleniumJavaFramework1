package testNGTesing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.SetupBase;

public class BrowserBackAndForwardButton extends SetupBase{

	@BeforeMethod
	public void setup() {
		SetupBase.initialization();
	}

	@Test
	public static void main() throws InterruptedException {

		driver.get("http://www.google.com/");
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.ca/");
		Thread.sleep(2000);
		
		//browser back & forward button simulation
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		
		driver.navigate().refresh();
	}

	@AfterMethod
	public void tearDown() { 
		//driver.quit();
	}

}
