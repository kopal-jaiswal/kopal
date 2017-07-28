package com.automation.pagelibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoComplete {
WebDriver driver;

By defaultFunctionality=By.xpath("/html/body/div/label/input");
By listElements=By.xpath("/html/body/span/div");

public AutoComplete(WebDriver driver) {
	this.driver=driver;
}

public void switchFrames(int index) {
	driver.switchTo().frame(index);
}
public void enterInTags(String s, String word) {
	driver.findElement(defaultFunctionality).sendKeys(s);
	List<WebElement> list=driver.findElements(listElements);
	for(WebElement li:list){
	if(li.equals(word)){
		li.click();
	}
	}
}
}
