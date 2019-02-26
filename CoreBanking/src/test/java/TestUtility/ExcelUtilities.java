/*
 * This class covers:
 * 4 Excel functions: getting row & Column count and getting String and Numeric data from Cell.
 * It also has main function to read excel.
 */

package TestUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	
	
	
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	FileInputStream fis;
	FileOutputStream fos;
	
	// This is  constructor with same class name.
	public ExcelUtilities(String excelFile, String sheetName) {
		
		try {
			//fis = new FileInputStream(excelFile);
			//fos = new FileOutputStream(excelFile);
			//workbook = new XSSFWorkbook(fis);
			workbook = new XSSFWorkbook(excelFile);
			sheet = workbook.getSheet(sheetName);
						
			} catch (Exception e) {
			      e.printStackTrace();
			}
		
		
	}
	
	
	public int getRowCount() {
		int rowCount =0;
		
		try {	
		rowCount = sheet.getPhysicalNumberOfRows();
		//System.out.println("No of row : "+rowCount);
		
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}
	

	public int getColCount() {
		int colCount =0;
		
		try {	
		colCount = sheet.getRow(1).getLastCellNum();
		//System.out.println("No of columns: "+colCount);
		
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}
		
	
	
	
	public String getCellDataString(int rowNum, int colNum) {
		String cellData =null;
		try {	
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println(cellData);
		
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		  }
		return cellData;
	}
		
	
	
	public double getCellDataNumeric(int rowNum, int colNum) {
		double cellData =0;
		try {
		cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		//System.out.println(cellData);
		
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		  }
		return cellData;
	}
	
	
	/*
	public void setCellData(int rowNum, int colNum, String value) {
		try {	
		sheet.getRow(rowNum).createCell(colNum).setCellValue(value);
	
		
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		  }
		
		
		
		
	}
	
	public void WriteExcelFile(String excelFile) throws FileNotFoundException {
		 FileOutputStream fos = new FileOutputStream(excelFile);
		try {
		workbook.write(fos);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public void closeFileInputStream() {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeFileOutputStream() {
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	
	public static Object[][] excelData(String excelFile, String sheetName) throws FileNotFoundException {
		ExcelUtilities excelSheet = new ExcelUtilities(excelFile, sheetName);
		int rowCount = excelSheet.getRowCount();
		int colCount = excelSheet.getColCount();
		int k = colCount+1;
		//System.out.println("Row Count "+rowCount);
		//System.out.println("Column Count "+colCount);
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i=1; i< rowCount; i++){
			for (int j=0; j<colCount; j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);
				
				
				String cellData = "";
				
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					//System.out.println("Value is String");
					cellData = excelSheet.getCellDataString(i,j);
					//System.out.print(cellData+ "  ___  ");
					data[i-1][j] = cellData;
				}
				
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					//System.out.println("Value is Numeric");
					cellData = String.valueOf(excelSheet.getCellDataNumeric(i,j));
					//System.out.print(cellData+ "  ___  ");
					data[i-1][j] = Double.parseDouble(cellData);
					
				}
				else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
					//System.out.println("Value is blank");
					cellData = "";
					//System.out.print(cellData+ "  ___  ");
					data[i-1][j] = cellData;
				}
				
				
				
			}//for j end
			
			//excelSheet.setCellData(i, k, "Major");
		} //for i end
		
			
		//excelSheet.closeFileInputStream();
		//excelSheet.WriteExcelFile(excelFile);
		
		//excelSheet.closeFileOutputStream();
		return data;
		} //function end
	
	
	
}

