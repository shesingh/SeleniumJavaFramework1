/*
 * This class covers:
 * Methods using POM - Where objects & methods both are coming from separate package "pageElements"
 * Note: It is important call "page object & method class" constructor after driver object is initialized.
 * that is why I declared the object at class level & called the constructor in before Method after initialization is done
 */

package testNGTesing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestUtility.SetupBase;
import pageElements_POM.GoogleSearchPgElementsAndMethods;

public class GoogleSearch_POM2 extends SetupBase{
	
	GoogleSearchPgElementsAndMethods searchPageOb;
	
	@BeforeMethod
	public void setUP() {
		SetupBase.initialization();
		
		//driver object is set so now calling constructor to pass driver object.	
		searchPageOb = new GoogleSearchPgElementsAndMethods(driver);
		}
	
	@Test 
	   public void performSearch() {
		searchPageOb.setTextInSearchBox("Step by Step Automation");
		searchPageOb.clickSearchButton();		
		}
	
	@AfterMethod
	   public void tearDown() {
			//SetupBase.closure();
		driver.close();   
		driver.quit();
		}

}
