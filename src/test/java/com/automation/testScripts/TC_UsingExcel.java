package com.automation.testScripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

import com.automation.excelReader.TasksExcel;
import com.automation.pagelibrary.AddTodo;
import com.automation.testBase.TestBase;

public class TC_UsingExcel extends TestBase {
	AddTodo addTodo;

	@BeforeClass
		public void setUp() throws IOException{
		init();
	}
	public Object getData(String excelName, String testCase) {
		TasksExcel excelSheet=new TasksExcel("C:\\Users\\Kopal\\eclipse_neon_work\\TodoAutomation\\src\\test\\java\\com\\automation\\utils\\TodoApplication.xlsx");
		int row=excelSheet.getRowCount(testCase);
		int column=excelSheet.getColumnCount(testCase);
		Object data[][]=new Object[row-1][column];
		for(int i=1; i<row; i++){
			for(int j=0; j<column; j++){
				data[i-1][j]=excelSheet.getCellData(testCase, j, i);
			}
		}
		return data;
	}
}
