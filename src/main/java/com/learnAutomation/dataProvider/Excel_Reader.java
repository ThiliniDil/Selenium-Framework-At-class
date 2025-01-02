package com.learnAutomation.dataProvider;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * This method is user to read the  different type type of data in a cell from excel
 * @param: Test data Sheet name
 * @return: Object array of data  
 */
public class Excel_Reader {
	
	static XSSFWorkbook wb;
	public static Object[][] ExcelReader(String sheetName)   {
		
		
		
		try {
			wb = new XSSFWorkbook(new File("./TestData/LoginDetails.xlsx"));
		} catch (IOException e) {
			System.out.println("The file has an error..please check..."+e.getMessage());
		} 
		
		catch (InvalidFormatException e) {
			System.out.println("The File Format is incorrect..."+e.getMessage());
		}
		XSSFSheet sh=wb.getSheet(sheetName);
		int row=sh.getPhysicalNumberOfRows();
		int column=sh.getRow(0).getPhysicalNumberOfCells();
		Object[][] arr=new Object[row-1][column];
		for(int i=1;i<row;i++) {
			for (int j=0;j<column;j++) {
				arr[i-1][j]=getDiffDataType(sheetName, i, j);
			}
		}
		return arr;
		
}
	

	public static String getDiffDataType(String sheetName,int row,int column) {
		
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		String data="";
		
		if(cell.getCellType()==CellType.STRING) { 
			data=cell.getStringCellValue();
		}
		
		else if(cell.getCellType()==CellType.BOOLEAN) {
			boolean cellValue= cell.getBooleanCellValue();
			data=String.valueOf(cellValue);
		}
		
		else if(cell.getCellType()== CellType.NUMERIC) {
			double NumCell=cell.getNumericCellValue();
			data=String.valueOf(NumCell);
		}
		
		else if(cell.getCellType()==CellType.BLANK) {
			data="";
		}
		
		return data;
		
	}
}
