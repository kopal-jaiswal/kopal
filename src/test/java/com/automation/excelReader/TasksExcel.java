package com.automation.excelReader;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.regexp.recompile;

import net.sf.cglib.core.GeneratorStrategy;

public class TasksExcel {
String path;
FileInputStream fis;
XSSFWorkbook workbook;
XSSFSheet sheet;
XSSFRow row;

	public TasksExcel(String path) {
		this.path=path;
		try{
			fis=new FileInputStream(path);
			workbook= new XSSFWorkbook(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int getRowCount(String sheetName) {
		try{
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1){
			return 0;
		}
		else{
			sheet=workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getColumnCount(String sheetName) {
		try{
	int index=workbook.getSheetIndex(sheetName);
	if(index==-1){
		return 0;
	}
	else{
		sheet=workbook.getSheetAt(index);
		 row=sheet.getRow(0);
		return row.getLastCellNum();
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return 0;
	}
	
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try{
			int index=workbook.getSheetIndex(sheetName);
			sheet=workbook.getSheetAt(index);
			XSSFRow row=sheet.getRow(0);
			row=sheet.getRow(rowNum-1);
			XSSFCell cell=row.getCell(colNum);
			return cell.getStringCellValue();
	}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
}
	public static void main(String[] args) {
		String path = "C:\\Users\\Kopal\\eclipse_neon_work\\TodoAutomation\\src\\test\\java\\com\\automation\\utils\\TodoApplication.xlsx";
		TasksExcel obj = new TasksExcel(path);
		// System.out.println(obj.getCellData("Login", "UserName", 4));

		System.out.println(obj.getRowCount("Sheet1"));
		
		System.out.println(obj.getColumnCount("Sheet1"));
		
		System.out.println(obj.getCellData("Sheet1", 2, 3));
	}
}