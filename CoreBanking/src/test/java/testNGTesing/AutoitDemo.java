/* 
 * This Test covers:
 * AutoIT Object finder is Au3Info_x64.exe
 * SciTE editor to write script is C:\Program Files (x86)\AutoIt3\SciTE SciTE.exe
 * 
 */
package testNGTesing;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class AutoitDemo {
	
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	
	static String driverPath = projectPath+"/drivers/";
	
	@Test
	public void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");	
		driver = new ChromeDriver(); 
						
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("Started");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.tinyupload.com/");
		driver.findElement(By.name("uploaded_file")).click();
		
		Runtime.getRuntime().exec(projectPath+"/autoITScripts/FileUloadScript.exe");
		Thread.sleep(3000);
		//driver.close();
		
	}

}
