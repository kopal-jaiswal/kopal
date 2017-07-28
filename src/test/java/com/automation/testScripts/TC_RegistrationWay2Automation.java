package com.automation.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pagelibrary.Draggable;
import com.automation.pagelibrary.DropDown;
import com.automation.pagelibrary.Index;
import com.automation.pagelibrary.Login;
import com.automation.pagelibrary.Registration;
import com.automation.testBase.TestBase;

public class TC_RegistrationWay2Automation extends TestBase {
	Registration reg;
	Login login;
	Index index;
	DropDown dropdown;
	Draggable drag;

	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void clickSignIn(){
		reg=new Registration(driver);
		login=new Login(driver);
		index=new Index(driver);
		dropdown=new DropDown(driver);
		drag=new Draggable(driver);
		
		reg.clickOnSignIn();
		login.EnterUserNameToLogin("Kopal");
		login.EnterPasswordToLogin("Kopalaldu28");
		login.ClickOnSubmitToLogin();
		System.out.println(index.SizeOfElementsInPage());
		System.out.println(index.sizeOfElemenetsInWidgets());
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
//DROPDOWN FEATURE (Select Element from DD & Enter Element into DD)
		index.openDropDownInNewTab();
		dropdown.switchToDDFrame(0);
		dropdown.SelectElementFromDropDown("India");
		dropdown.switchToDefaultFrame();
		dropdown.clickOnEnterCOuntryButton();
		dropdown.switchToDDFrame(1);
		dropdown.clickOnEnterCOuntryTextBox();
		dropdown.EnterTextInEnterCountryTextBox("India");
		index.switchToDefaultFrame();
		
//DRAGGABLE FEATURE
//		index.clickOnDraggableElement();
		dropdown.clickOnInteraction();
//		drag.switchFrames(0);
		drag.DragElementAnywhere();
		
	}
	
	
	@AfterClass
	public void quitBrowser(){
driver.close();
	}
	
}
