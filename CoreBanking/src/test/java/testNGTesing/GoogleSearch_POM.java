/*
 * This class covers:
 * Methods using POM - Where objects are coming from separate package "pageElements"
 * 
 */

package testNGTesing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.SetupBase;
import pageElements_POM.GoogleSearchPage;

public class GoogleSearch_POM extends SetupBase{
	
	
	
	@BeforeMethod
	public void setUP() {
		SetupBase.initialization();
		}
	
	@Test 
	   public void performSearch() {
		//driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation step by step");
		GoogleSearchPage.textBox_search(driver).sendKeys("Automation step by step");
		//driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
		GoogleSearchPage.textBox_search(driver).sendKeys(Keys.RETURN);
		   }
	
	@AfterMethod
	   public void tearDown() {
		   driver.quit();
	   }

}
