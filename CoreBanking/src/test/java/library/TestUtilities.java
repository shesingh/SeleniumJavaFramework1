/*
 * This class covers:
 * Returning data from Excel Sheet.
 * To DO --- Fix function to get numeric value from the cell count.
 */


package TestUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtilities {
	
	
	/*public static Object[][] excelData(String excelFile, String sheetName) {
		ExcelUtilities excelSheet = new ExcelUtilities(excelFile, sheetName);
		int rowCount = excelSheet.getRowCount();
		int colCount = excelSheet.getColCount();
			
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i=1; i< rowCount; i++){
			for (int j=0; j<colCount; j++) {
				
			String cellData = excelSheet.getCellDataString(i,j);
			//System.out.print(cellData+ "  ___  ");
			data[i-1][j] = cellData;
			}
			
			//System.out.println();
		}
		
		return data;
		}*/
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	public void ScreenShotForfailedStep(String testMethodName){
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
			try {
				System.out.println("About to take screen shot");
				FileUtils.copyFile(srcFile, new File (screenshotFilePath+testMethodName+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}*/
	
	
}