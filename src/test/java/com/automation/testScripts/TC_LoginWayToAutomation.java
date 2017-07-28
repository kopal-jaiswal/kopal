package com.automation.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pagelibrary.AutoComplete;
import com.automation.pagelibrary.Draggable;
import com.automation.pagelibrary.DropDown;
import com.automation.pagelibrary.FramesAndWindows;
import com.automation.pagelibrary.Index;
import com.automation.pagelibrary.Login;
import com.automation.pagelibrary.Registration;
import com.automation.testBase.TestBase;

public class TC_LoginWayToAutomation extends TestBase {
	Registration reg;
	Login login;
	Index index;
	FramesAndWindows frameWindows;
	AutoComplete autocomplete;

	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void clickSignIn(){
		reg=new Registration(driver);
		login=new Login(driver);
		index=new Index(driver);
		frameWindows=new FramesAndWindows(driver);
		autocomplete=new AutoComplete(driver);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		reg.clickOnSignIn();
		login.EnterUserNameToLogin("Kopal");
		login.EnterPasswordToLogin("Kopalaldu28");
		login.ClickOnSubmitToLogin();
		System.out.println(index.SizeOfElementsInPage());
		System.out.println(index.sizeOfElemenetsInWidgets());
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("clicked on frame");
//open new tab and navigate
		index.clickOnFramesAndWindows();	
		String parentWindow=driver.getWindowHandle();
		System.out.println("--------Open New Window-------");
		frameWindows.switchFrame(0);
		frameWindows.clickOnNewBrowserTab();
		frameWindows.switchTabs();
		
		System.out.println("switched to different frame");
		frameWindows.switchToDefaultFrame();
		System.out.println("--------Open Seperate New Window-------");
		frameWindows.clickOnOpenSeperateWindow();
		frameWindows.switchFrame(1);
		frameWindows.clickOnNewBrowserTab();
		frameWindows.switchToDefaultFrame();
		System.out.println("-------Frameset--------");
		frameWindows.clickOnFrameSet();
		frameWindows.switchFrame(2);
		frameWindows.clickOnNewBrowserTab();
		frameWindows.switchWindow();
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println("---------Open Multiple Windows--------");
		
		frameWindows.clickOnOpenMultipleWindows();
		frameWindows.switchFrame(3);
		frameWindows.clickOnOpenMultiplePages();
		frameWindows.switchWindow();
		driver.switchTo().window(parentWindow);
		System.out.println("---------AutoWindows--------");
		index.clickOnAutoComplete();
		autocomplete.enterInTags("j","Java");
	}
	
	
	@AfterClass
	public void quitBrowser(){
//driver.close();
	}
	

}
