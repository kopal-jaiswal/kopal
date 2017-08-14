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


public class TC_UsingExcel extends TestBase {
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
	public Object[][] enterTask(){
		Object[][] data=getData("TodoApplication.xlsx","Sheet1");
		System.out.println("method called");
		System.out.println(data);
		return data;
	}
	
	@Test(priority=1, dataProvider="enterTask")
	public void EnterSingleTask(String TestCases,String TasksToBeAdded, String TasksCompleted) throws InterruptedException{
		System.out.println(TestCases);
		if(TestCases.equals("TC_01")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.CountItemsLeft();
	}
}

	@Test(priority=2, dataProvider="enterTask")
	public void EnterMultipleTasks(String TestCases,String TasksToBeAdded, String TasksCompleted) throws InterruptedException{
		if(TestCases.equals("TC_02")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.CountItemsLeft();
	}
}
	
	@Test(priority=3, dataProvider="enterTask")
	public void EnterDuplicateTsks(String TestCases,String TasksToBeAdded, String TasksCompleted) throws InterruptedException{
		if(TestCases.equals("TC_03")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.CountItemsLeft();
	}
}
	
	@Test(priority=3, dataProvider="enterTask")
	public void DeleteDuplicateTsks(String TestCases,String TasksToBeAdded, String TasksCompleted) throws InterruptedException{
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.EnterTask(TasksToBeAdded);
		addTodo.CountItemsLeft();
		addTodo.DeleteDuplicateData();
	}

//@Test(priority=4, dataProvider="enterTask")
//public void ClearCompletedLinkBeforeCompletingTasks(String TestCases,String TasksToBeAdded, String TasksCompleted) throws InterruptedException{
//	addTodo=new AddTodo(driver);
//	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//	addTodo.EnterTask(TasksToBeAdded);
//	addTodo.CountItemsLeft();
//	addTodo.DeleteDuplicateData();
//}
//}
	@Test(priority=5, dataProvider="enterTask")
	public void MoveTasksToCompleted(String TestCases,String TasksToBeAdded, String TasksCompleted) throws InterruptedException{
		if(TestCases.equals("TC_04")){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.ClickToCompleted(TasksCompleted);
		addTodo.clickOnActive();
		addTodo.CountItemsLeft();
		addTodo.clickOnCompleted();
		}
}

	@Test(priority=6)
	public void ClearCompletedTasks() throws InterruptedException{
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addTodo.clickOnCompleted();
		try{
			Boolean linkDisplayed=addTodo.clearCompletedLinkDisplay();
			System.out.println(linkDisplayed);
			if(linkDisplayed==true){
				addTodo.clickOnClearCompeleted();
				int countElementAfterClear=addTodo.CountListOfElements();
				if(countElementAfterClear==0){
					System.out.println("Completed Elements cleared");
				}
				else{
					System.out.println("Completed Elements not cleared");
				}
			}
		}
		catch(Exception e){
			System.out.println("Elements not Found");
		}
		}
}
