package com.automation.pagelibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

public class Index {
	WebDriver driver;
	static Logger log=Logger.getLogger(Login.class);

	By listOfElements = By.tagName("figure");
	By listOfWidgets= By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li");
	By dropDown= By.xpath(".//a//h2[contains(text(), 'Dropdown')]");
	 
	public Index(WebDriver driver) {
		this.driver=driver;  // Driver should not be sliced before calling, Global driver is mapped to local driver
	}

	public int SizeOfElementsInPage(){
		log.info("Storing elements in List");
		List<WebElement> li=driver.findElements(listOfElements);
		return(li.size());
	}
	public int sizeOfElemenetsInWidgets() {
		log.info("Storing widgets in List");
		List<WebElement> liWidget=driver.findElements(listOfWidgets);
		return (liWidget.size()); 
	}
	
	public void clickDropDown() {
		log.info("Click on Dropdown");
		driver.findElement(dropDown).click();;
		 
	}

}
