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
//			row=sheet.getRow(row)
			for(int i=0; i<row.getLastCellNum();i++){
//				if(row.getCell(i).getStringCellValue().equals(colNum))
				row=sheet.getRow(i);
				XSSFCell cell=row.getCell(colNum);
				if(cell.getStringCellValue().equals("Tasks To Be Added")){
					return cell.getStringCellValue();
				}
			}
	}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
}
}