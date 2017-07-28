package com.automation.pagelibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;

public class Index {
	WebDriver driver;
	static Logger log=Logger.getLogger(Login.class);

	By listOfElements = By.tagName("figure");
	By listOfWidgets= By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li");
	By dropDown= By.xpath(".//a//h2[contains(text(), 'Dropdown')]");
	By draggableElement=By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[1]/a/figure");
	By FramesAndWindows= By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[3]/ul/li/a/figure");
	By AutoComplete=By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[2]/a/figure");
	 
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
	
	public void openDropDownInNewTab() {
		log.info("Click on Dropdown");
		Actions act=new Actions(driver);
		act.contextClick(driver.findElement(dropDown)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
		System.out.println("right clicked");
//		act.sendKeys("T").perform();
	}                                 
	
	public void switchToDefaultFrame() {
		driver.switchTo().parentFrame();
	}

	public void clickOnDraggableElement() {
		driver.findElement(draggableElement).click();
	}
	public void clickOnFramesAndWindows() {
		driver.findElement(FramesAndWindows).click();
	}
	public void clickOnAutoComplete() {
		driver.findElement(AutoComplete).click();
	}
	
}
