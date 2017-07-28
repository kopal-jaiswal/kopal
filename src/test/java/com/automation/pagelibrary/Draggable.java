package com.automation.pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Draggable {
	WebDriver driver;
	
	By draggableElement=By.id("draggable");
	
	public Draggable(WebDriver driver) {
		this.driver=driver;
	}

	public void switchFrames(int index) {
		driver.switchTo().frame(index);
	}
	
	public void DragElementAnywhere() {
		WebElement element=driver.findElement(draggableElement);
		Actions act=new Actions(driver);
		act.dragAndDropBy(element, 400, 150).build().perform();
	}

}
