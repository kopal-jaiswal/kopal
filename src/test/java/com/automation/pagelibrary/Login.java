package com.automation.pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

public class Login {
	WebDriver driver;
static Logger log=Logger.getLogger(Login.class);

By userName = By.xpath("//*[@class='ajaxlogin']/fieldset[1]/input");
By password= By.xpath("//*[@class='ajaxlogin']/fieldset[2]/input");
By submit= By.xpath("//*[@class='ajaxlogin']/div/div[2]/input");

public Login(WebDriver driver) {
	this.driver=driver;  // Driver should not be sliced before calling, Global driver is mapped to local driver
}

public void EnterUserNameToLogin(String username){
	log.info("Entering Username");
	driver.findElement(this.userName).sendKeys(username);
}
public void EnterPasswordToLogin(String password) {
	log.info("Entering Password");
	driver.findElement(this.password).sendKeys(password);
}
public void ClickOnSubmitToLogin() {
	log.info("Clicking on login button");
	driver.findElement(submit).click();
}
}
