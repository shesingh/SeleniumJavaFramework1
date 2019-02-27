/*
 * This test Covers:
 * Have test which get data from DataProvider using Excel Sheet.
 * 
 * 3 ways to use functions from TestUtility
 * 1. Use extends keyword in main class here.
 * 2. Declare the function static in TestUtility Class and use it directly with class name
 * 3. Create the object of TestUtility Class and use them with object name.
 * 
 * 
 * user path starting from project so if you move the project ...path will not break.
   use single slash as this will work in windows and mac both
	
 */

package testNGTesing;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestUtility.SetupBase;
import TestUtility.ExcelRead_Methods;
//import TestUtility.TestUtilities;

public class DDTestusingExcel_UsingExcelRead_Methods extends SetupBase {
	
	@BeforeMethod
		public void setUP() {
		//initialization();
	}
   
	
	@DataProvider(name ="data")
	 public Object[][] testData() throws Throwable {
		String projectPath = System.getProperty("user.dir");
		String filePath = projectPath+"/testData/";
		String excelFile =filePath+"TestData.xlsx";
		String sheetName ="Data";
	 
		Object data[][] = ExcelRead_Methods.excelData(excelFile,sheetName);
		return data;
	}
	
		
	 @Test(dataProvider="data")
	 public void Test1(String name, Double age) {
		   	System.out.println(name+" | "+ age ); 
		   	
		   	
		   	
		   
 		 }
	
		
	@AfterMethod
	   public void tearDown() {
		  // driver.quit();
		
	   }
}
