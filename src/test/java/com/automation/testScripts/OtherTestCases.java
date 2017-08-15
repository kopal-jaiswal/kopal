package com.automation.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.excelReader.TasksExcel;
import com.automation.pagelibrary.AddTodo;
import com.automation.testBase.TestBase;

import junit.framework.TestCase;


public class OtherTestCases extends TestBase {
	AddTodo addTodo;

	@BeforeClass
		public void setUp() throws IOException{
		init();
	}
	public Object[][] getData(String excelName, String testCase) {
		TasksExcel excelSheet=new TasksExcel("C:\\Users\\mom\\git\\kopal\\src\\test\\java\\com\\automation\\utils\\TodoApplication.xlsx");
		System.out.println("excel loaded");
		int row=excelSheet.getRowCount(testCase);
		System.out.println(row);
		int column=excelSheet.getColumnCount(testCase);
		System.out.println(column);
		Object sampleData[][]=new Object[row-2][column];
		for(int i=2; i<row; i++){
			for(int j=0; j<column; j++){
				System.out.println(excelSheet.getCellData(testCase, j, i));
				sampleData[i-2][j]=excelSheet.getCellData(testCase, j, i);
//				System.out.println(sampleData[i-1][j]);
			}
		}
		return sampleData;
	}
	
	@DataProvider()
	public Object[][] enterTaskRandomly(){
		Object[][] data=getData("TodoApplication.xlsx","Sheet2");
		System.out.println("method called");
		System.out.println(data);
		return data;
	}
	
	@Test(priority=1, dataProvider="enterTaskRandomly")
	public void TaskCheckForLowerAndUpperCase(String TestCases,String TasksToBeAdded) throws InterruptedException{
		System.out.println(TestCases);
		if(TestCases.equals("TC_07")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.CountItemsLeft();
	}
}

	@Test(priority=2, dataProvider="enterTaskRandomly")
	public void TaskCheckForAlphaNumericCharacters(String TestCases,String TasksToBeAdded) throws InterruptedException{
		if(TestCases.equals("TC_08")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.CountItemsLeft();
	}
}
	
	@Test(priority=3, dataProvider="enterTaskRandomly")
	public void TaskCheckForSymbols(String TestCases,String TasksToBeAdded) throws InterruptedException{
		if(TestCases.equals("TC_09")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.CountItemsLeft();
	}
}
	
	@Test(priority=4, dataProvider="enterTaskRandomly")
	public void CheckForLengthyTask(String TestCases,String TasksToBeAdded) throws InterruptedException{
		if(TestCases.equals("TC_10")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.CountItemsLeft();
	}
}

	@Test(priority=5, dataProvider="enterTaskRandomly")
	public void EnterMoreThanFiftyTasks(String TestCases,String TasksToBeAdded) throws InterruptedException{
		if(TestCases.equals("TC_11")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.clickOnActive();
		addTodo.CountItemsLeft();
		}
}
}
