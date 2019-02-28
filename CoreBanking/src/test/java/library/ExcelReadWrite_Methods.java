/*
 * This class covers:
 * 7 Excel functions: 
 * Setting Excel file
 * Getting row & Column count
 * getCellData
 * setSellData
 * readExcelData
 * writeExcelData
 * 
 * 
 * TO DO - setExcelFile is not working if file is not there.
 * 1. Fix the scenario when fiel is not there.
 * 2. Once point 1 is done, call writeExcelData function with some data ex. writeExcelData("My Text", 1,1)
 */

package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;



public class ExcelReadWrite_Methods {

	private static Workbook workbook;
	private static Sheet sheet;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Row row;
	private static Cell cell;
	private static String excelpath;
	private static String sheetName;

	//This is constructor
	public ExcelReadWrite_Methods(String excelFilepath, String excelSheetName) throws Exception {

		excelpath = excelFilepath;
		sheetName = excelSheetName;

		setExcelFile(excelpath,sheetName);
	}


	public static void setExcelFile(String excelpath, String sheetName  ) throws Exception {

		try {
			File f = new File(excelpath);
			if (!f.exists()) {
				f.createNewFile();
						System.out.println("File not found so created");
			}

			fis = new FileInputStream(excelpath);
			workbook = WorkbookFactory.create(fis);
			
			sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				sheet = workbook.createSheet(sheetName);
				System.out.println("Sheet not found so created");
			}

		} catch (Exception e) {System.out.println(e.getMessage());

		}
	}


	public static void setCellData(String text, int rowno, int colno) {
		try {
			System.out.println("Calling using setCellData(\"MyData\", 1,3); ");
			row = sheet.getRow(rowno);
			if (row==null) {
				System.out.println("Row NOT found so creating row...");
				row = sheet.createRow(rowno);
			}
			cell = row.getCell(colno);
			if(cell != null) {
				System.out.println("Cell found so setting cell value ...");
				cell.setCellValue(text);
			}
			else {
				System.out.println("Cell NOT found so creating cell & setting cell value ...");
				cell = row.createCell(colno);
				System.out.println(text);
				cell.setCellValue(text);
			}

			System.out.println("Writing back to file ...");
			System.out.println(excelpath);
			fos = new FileOutputStream(excelpath);
			workbook.write(fos);
			fos.flush();
			fos.close();

		} catch (Exception e) {System.out.println(e.getMessage());
		}
	}


	@SuppressWarnings("deprecation")
	public static String getCellData(int rowno, int colno) {
		try {
			cell = sheet.getRow(rowno).getCell(colno);
			String cellData = null;
			if (cell.getCellType() == cell.CELL_TYPE_STRING) {
				//System.out.println("cell Type when cell is String : "+cell.getCellType());
				cellData = cell.getStringCellValue();
			}
			if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
				//System.out.println("cell Type when cell is Numeric : "+cell.getCellType());
				cellData = Double.toString(cell.getNumericCellValue());
				if (cellData.contains(".0")) {
					cellData =cellData.substring(0,cellData.length()-2);

				}

				//if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
				else   {
					//System.out.println("cell Type when cell is blank : "+cell.getCellType());
					System.out.println("cell is bank");
					cellData ="";
				}
			}
			return cellData;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}//getCellData Function



	public static int getRowCount() {
		//getPhysicalNumberOfRows() function will count rows starting heading row = 1 but getLastRowNum function will count rows starting heading row = 0 
		//return sheet.getPhysicalNumberOfRows();
		System.out.println("Row Count is : "+sheet.getLastRowNum());
		return sheet.getLastRowNum();
	}


	public int getColCount() {
		System.out.println("Column Count is : "+sheet.getRow(0).getLastCellNum());
		return sheet.getRow(1).getLastCellNum();
	}



	//public Object[][] readExcelData(String excelpath, String sheetName) throws Exception {
	public Object[][] readExcelData() throws Exception {
		int rowCount;
		int colCount;
		//String cellDataValue = "";

		//setExcelFile(excelpath, sheetName);
		rowCount = getRowCount();
		colCount = getColCount();

		//System.out.println("Row Count is : "+rowCount);
		//System.out.println("Column Count is : "+colCount);

		Object data[][] = new Object[rowCount][colCount];

		for (int i=0; i< rowCount; i++){
			for (int j=0; j<colCount; j++) {

				data[i][j] = getCellData(i+1,j);
				System.out.print(data[i][j]+"  !  ");
				//System.out.print("data ["+i+"]["+j+"] "+ data[i][j]+ "   ");

			} //for j closed
			System.out.println("\n");
		} //for i closed

		return data;

	} //mainTest


	public void writeExcelData(String text, int rowNo, int colNo) throws Exception {
		//setExcelFile(excelpath, sheetName);
		setCellData(text,rowNo,colNo );

	}


}// ExcelWRclass


