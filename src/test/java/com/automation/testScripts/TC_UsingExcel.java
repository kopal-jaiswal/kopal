package com.automation.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.excelReader.TasksExcel;
import com.automation.pagelibrary.AddTodo;
import com.automation.testBase.TestBase;

public class TC_UsingExcel extends TestBase {
	AddTodo addTodo;

	@BeforeClass
		public void setUp() throws IOException{
		init();
	}
	public Object[][] getData(String excelName, String testCase) {
		TasksExcel excelSheet=new TasksExcel("C:\\Users\\Kopal\\eclipse_neon_work\\TodoAutomation\\src\\test\\java\\com\\automation\\utils\\TodoApplication.xlsx");
		System.out.println("excel loaded");
		int row=excelSheet.getRowCount(testCase);
		System.out.println(row);
		int column=excelSheet.getColumnCount(testCase);
		System.out.println(column);
		Object sampleData[][]=new Object[row-1][column];
		for(int i=2; i<row; i++){
			for(int j=0; j<column; j++){
				System.out.println(excelSheet.getCellData(testCase, j, i));
				sampleData[i-1][j]=excelSheet.getCellData(testCase, j, i);
//				System.out.println(sampleData[i-1][j]);
			}
		}
		return sampleData;
	}
	
	@DataProvider()
	public Object[][] enterTask(){
		Object[][] data=getData("TodoApplication.xlsx","Sheet1");
		System.out.println("method called");
		System.out.println(data);
		return data;
	}
	
	@Test(dataProvider="enterTask")
	public void EnterTaskWithDataProvider(String TasksToBeAdded, String CompletedTasks) throws InterruptedException{
		
		getData("TodoApplication.xlsx","Sheet1");
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
//		getData(excelName, testCase)
		addTodo.CountItemsLeft();
//		String expected=count+" "+"item left";
//		assert.assertEquals(elements, expected);
		
	}
}
