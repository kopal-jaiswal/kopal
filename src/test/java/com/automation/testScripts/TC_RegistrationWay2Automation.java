package com.automation.testScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
		
		reg.clickOnSignIn();
		login.EnterUserNameToLogin("Kopal");
		login.EnterPasswordToLogin("Kopalaldu28");
		login.ClickOnSubmitToLogin();
		System.out.println(index.SizeOfElementsInPage());
		System.out.println(index.sizeOfElemenetsInWidgets());
		index.clickDropDown();
		dropdown.switchToDDFrame(0);
		dropdown.SelectElementFromDropDown("India");
		dropdown.switchToDefaultFrame();
		dropdown.clickOnEnterCOuntryButton();
		dropdown.switchToDDFrame(1);
		dropdown.clickOnEnterCOuntryTextBox();
		dropdown.EnterTextInEnterCountryTextBox("India");
	}
	
	
	@AfterClass
	public void quitBrowser(){

	}
	
}
