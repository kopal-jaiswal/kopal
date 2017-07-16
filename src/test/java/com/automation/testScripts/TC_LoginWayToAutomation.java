package com.automation.testScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pagelibrary.Login;
import com.automation.pagelibrary.Registration;

public class TC_LoginWayToAutomation {
	Login login;

	@BeforeClass
	public void setUp() throws IOException{
		
	}
	
	@Test
	public void clickSignIn(){
		login.EnterUserNameToLogin("Kopal");
		login.EnterPasswordToLogin("Kopalaldu28");
		login.ClickOnSubmitToLogin();
	}
	
	
	@AfterClass
	public void quitBrowser(){

	}
	

}
