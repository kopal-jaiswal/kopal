package com.automation.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.internal.ElementScrollBehavior;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.automation.pagelibrary.AddTodo;
import com.automation.testBase.TestBase;



public class TC_AddingTask extends TestBase {
	AddTodo addTodo;

	@BeforeClass
		public void setUp() throws IOException{
		init();
	}
	@Test(priority=1)
//	@Test(dataProvider="enterTask")
	public void EnterTask(){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		addTodo.EnterTask("Testing");
		addTodo.CountItemsLeft();
//		String expected=count+" "+"item left";
//		assert.assertEquals(elements, expected);
		
	}
	
	@Test(priority=2,dataProvider="enterTask")
	public void EnterMultipleTasks(){
		addTodo=new AddTodo(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		addTodo.EnterTask("Testing");
		addTodo.EnterTask("Development");
		addTodo.EnterTask("Reporting");
		addTodo.CountItemsLeft();
		try{
		Boolean linkDisplyed=addTodo.clearCompletedLinkDisplay();
		System.out.println(linkDisplyed);
		}
		catch(Exception e){
			System.out.println("link is not displayed");
		}
//		Assert.assertEquals(false, linkDisplyed);
		
		addTodo.ClickToComplete("Testing");
		addTodo.clickOnActive();
		addTodo.CountItemsLeft();
		addTodo.clickOnCompleted();
		addTodo.CountItemsLeft();
		try{
			Boolean linkDisplyed=addTodo.clearCompletedLinkDisplay();
			System.out.println(linkDisplyed);
			if(linkDisplyed==true){
				addTodo.clickOnClearCompeleted();
				int countElementsAfterClear=addTodo.CountListOfElements();
				if(countElementsAfterClear==0){
					System.out.println("Completed elements cleared");
				}
				else{
					System.out.println("Completed Elements not cleared");
				}
			}
			}
			catch(Exception e){
				System.out.println("Elements not found");
			}
	}
	
	
	@AfterClass
	public void quitBrowser(){
//driver.close();
	}
	
}
