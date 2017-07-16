package com.automation.pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class Registration {
WebDriver driver;
// java.util.logging.Logger log=LogManager.getLogger(Registration.class.getName());
static Logger log=Logger.getLogger(Registration.class);
By signIn=By.xpath(".//a[contains(text(), 'Signin')]");

public Registration(WebDriver driver) {
	this.driver=driver;  // Driver should not be sliced before calling, Global driver is mapped to local driver
}

public void clickOnSignIn(){
	log.info("Clicking on Sigin Link");
	driver.findElement(signIn).click();
}
}
