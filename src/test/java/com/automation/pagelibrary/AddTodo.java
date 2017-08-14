package com.automation.pagelibrary;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

public class AddTodo {
	WebDriver driver;
static Logger log=Logger.getLogger(AddTodo.class);

By todoTextBox = By.xpath("//h1[text()='todos']/following::input[1]");
By listOfTasks= By.xpath("//*[@class='todo-list']/li");
By expectedItemsLeft= By.xpath("//*[@class='footer']/span");
By linkActive= By.xpath("//a[@href='#/active']");
By linkCompleted=By.xpath("//a[@href='#/completed']");
By clearCompleted=By.xpath("//*[text()='Clear completed']");

int count,listCount=0, elementsInListCount;
String actual;
public AddTodo(WebDriver driver) {
	this.driver=driver;  // Driver should not be sliced before calling, Global driver is mapped to local driver
}

public void EnterTask(String task){
	log.info("Entering Task");
	WebElement textBox=driver.findElement(this.todoTextBox);
	textBox.sendKeys(task);
	textBox.sendKeys(Keys.ENTER);
}
public void CountItemsLeft() {
	count=0;
	log.info("Count Tasks");
	List<WebElement> li=driver.findElements(this.listOfTasks);
	for(WebElement list:li){
		count++;
	}
	String Expectedelements= driver.findElement(expectedItemsLeft).getText();
	System.out.println(Expectedelements);
	if(count>1){
		actual=count+" "+"items left";
	}
	else{
		 actual=count+" "+"item left";	
	}
	Assert.assertEquals(Expectedelements, actual);
}

public int CountListOfElements() {
	elementsInListCount=0;
	log.info("Count Tasks");
	List<WebElement> li=driver.findElements(this.listOfTasks);
	for(WebElement list:li){
		elementsInListCount++;
	}
	return elementsInListCount;
}

public void ClickToComplete(String element) {
	String list1="//*[@class='todo-list']/li[";
	String list2="]/div/input";
	List<WebElement> li=driver.findElements(this.listOfTasks);
	for(WebElement list:li){
		listCount++;
		if(list.getText().equals(element)){
			driver.findElement(By.xpath(list1+ listCount+list2)).click();
		}
	}
}

public void clickOnActive() {
	driver.findElement(linkActive).click();
}

public void clickOnCompleted() {
	driver.findElement(linkCompleted).click();
}
public boolean clearCompletedLinkDisplay() {
	return driver.findElement(clearCompleted).isDisplayed();
}
public void clickOnClearCompeleted() {
	driver.findElement(clearCompleted).click();
}

public void DeleteDuplicateData() {
	count=0;
	List<WebElement> li=driver.findElements(this.listOfTasks);
	Set<WebElement> duplicates=new HashSet<WebElement>();
	Set<WebElement> unique= new HashSet<WebElement>();
	for(WebElement element:li){
		if(!unique.add(element)){
			System.out.println(duplicates.add(element));
		}
	}
}

public void ClickToCompleted(String element) {
	// TODO Auto-generated method stub
	String list1="//*[@class='todo-list']/li[";
	String list2="]/div/input";
	List <WebElement> li=driver.findElements(this.listOfTasks);
	for(WebElement list:li){
		listCount++;
		if(list.getText().equals(element)){
			driver.findElement(By.xpath(list1+ listCount+list2)).click();
		}
	}
}

}
