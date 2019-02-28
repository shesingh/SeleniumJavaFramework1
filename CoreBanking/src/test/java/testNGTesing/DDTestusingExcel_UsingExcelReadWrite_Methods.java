/*
 * This test Covers:
 * Have test which get data from DataProvider using Excel Sheet.
 * Have test which set (write) data in Excel Sheet.
 * Have test which get data from DataProvider using Excel Sheet and write data in excel sheet.
 * 
 * PRECONDITIONS:
 * Note - The test corresponding to this data provider in this sheet (name ="data") can take 2 columns as input
 * 1. Have Excel sheet at path C:\Users\shefali.singh.GROUPINFRA\git\SeleniumJavaFramework1\CoreBanking\testData
 * 2. Excel Sheet Name = TestData
 * 3. Sheet Name = Data
 * 4. 2 columns (Because test corresponding to data provider can take 2 inputs.)
 * 5. Each row should have some data because test cann't take NULL input.
 */

package testNGTesing;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import library.ExcelReadWrite_Methods;
import library.ExcelRead_Methods;
import library.SetupBase;

public class DDTestusingExcel_UsingExcelReadWrite_Methods extends SetupBase {

	String projectPath = System.getProperty("user.dir");
	String filePath = projectPath+"/testData/";
	String excelFile =filePath+"TestData.xlsx";
	String sheetName ="Data";
	ExcelReadWrite_Methods excelObj;


	@BeforeMethod
	public void setUP() {
		//initialization();
	}

	//The function corresponding to this data provider can take 2 columns as input
	
	@DataProvider(name ="data")
	public Object[][] testData() throws Throwable {
		excelObj = new ExcelReadWrite_Methods(excelFile,sheetName);

		//excelObj.readExcelData(excelFile, sheetName);
		excelObj.readExcelData();
		
		Object data[][] = ExcelRead_Methods.excelData(excelFile,sheetName);
		return data;
	}

	@Ignore
	//In ExcelReadWrite_Methods class in getColCount method in line return sheet.getRow(0).getLastCellNum(); 
	//change 0 to 1 so that it return just 2 column and we we are having 2 columns here.
	@Test(dataProvider="data")
	public void testForEachDataRow(String name, Double age) {
		System.out.println(name+" | "+ age ); 
		
	}
	
	int rowNoToWrite=0;
	
	@Test(dataProvider="data")
	//public void TestReadWriteForEachDataRow(@Optional("A") String name, @Optional("A") Double age){
		
	public void TestReadWriteForEachDataRow(String name, Double age) throws Exception{
		//
		
		System.out.println(name+" ____ "+ age); 
		int colNoToWrite = 2;
		String cellText = "";
		rowNoToWrite = rowNoToWrite+1;
		System.out.println("rowNoToWrite"+rowNoToWrite+"  colNoToWrite"+colNoToWrite);
		if (age>18) {
			cellText = "Major";
			
		}else cellText = "Minor";
		
		excelObj.writeExcelData(cellText, rowNoToWrite, colNoToWrite);
		
	}

	@Ignore
	@Test
	public void testWriteExcelDataOnSpecificCell() throws Exception {
		ExcelReadWrite_Methods excelObj = new ExcelReadWrite_Methods(excelFile,sheetName);
			excelObj.writeExcelData("MyData2", 1, 2);
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}
}
