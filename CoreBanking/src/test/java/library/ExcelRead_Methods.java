/*
 * This class covers:
 * 4 Excel functions: getting row & Column count and getting String and Numeric data from Cell.
 * It also has main function to read excel.
 */

package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead_Methods {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	FileInputStream fis;
	FileOutputStream fos;

	// This is  constructor with same class name.
	public ExcelRead_Methods(String excelFile, String sheetName) {

		try {
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




	public static Object[][] excelData(String excelFile, String sheetName) throws FileNotFoundException {
		ExcelRead_Methods excelSheet = new ExcelRead_Methods(excelFile, sheetName);
		int rowCount = excelSheet.getRowCount();
		int colCount = excelSheet.getColCount();
		
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

