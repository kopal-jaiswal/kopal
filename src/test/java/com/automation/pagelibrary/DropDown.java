package com.automation.pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

public class DropDown {
WebDriver driver;
static Logger log=Logger.getLogger(Login.class);

By dropDownElement = By.xpath("/html/body/select");
By EnterCountryButton=By.xpath("//*[@class='responsive-tabs']/li[2]");
By EnterCountryTextBox=By.xpath("/html/body/div[1]/span/input");
//By frame=By.name("dropdown/default.html");
 
 public DropDown(WebDriver driver) {
	this.driver=driver;  // Driver should not be sliced before calling, Global driver is mapped to local driver
}

 public void switchToDDFrame(int index){
//	 WebElement frame1=driver.findElement("frame");
	 driver.switchTo().frame(index);
 }
 
 public void switchToDefaultFrame() {
	 driver.switchTo().defaultContent();
}
 
	public void SelectElementFromDropDown(String text){
		log.info("Select Element From Drop Down");
	WebElement dropdwn=driver.findElement(dropDownElement);
	Select sel=new Select(dropdwn);
	sel.selectByVisibleText(text);	
	}
	public void clickOnEnterCOuntryButton() {
		driver.findElement(EnterCountryButton).click();
	}
	public void clickOnEnterCOuntryTextBox(){
		driver.findElement(EnterCountryTextBox).click();
		driver.findElement(EnterCountryTextBox).clear();
	}
	
	public void EnterTextInEnterCountryTextBox(String country){
		driver.findElement(EnterCountryTextBox).sendKeys(country);
		
	}
}
