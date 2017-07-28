package com.automation.pagelibrary;

import java.util.Set;

import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesAndWindows {
WebDriver driver;

By NewBrowserTab=By.xpath("/html/body/div/p/a");
By OpenSeperateNewWindow= By.xpath("//*[@id='wrapper']/div/div[1]/div[1]/ul/li[2]/a");
By FrameSet=By.xpath("//*[@id='wrapper']/div/div[1]/div[1]/ul/li[3]/a");
By OpenFramesetWindow= By.xpath(".//div//p//a[contains(text(), 'Open Frameset Window')]");
By OpenMultipleWindows=By.xpath("//*[@id='wrapper']/div/div[1]/div[1]/ul/li[4]/a");
By OpenMultiplePages=By.xpath(".//div//p//a[contains(text(), 'Open multiple pages')]");
By frame1=By.xpath("/html/body");
By frame2=By.xpath("/html/body");
By frameName1=By.xpath("/html/frameset/frame[1]");
By frameName2=By.xpath("/html/frameset/frame[3]");

public FramesAndWindows(WebDriver driver) {
	this.driver=driver;
}
public void switchFrame(int index) {
	driver.switchTo().frame(index);
}
public void switchTabs() {
	Actions act=new Actions(driver);
	act.keyDown(Keys.CONTROL).sendKeys(Keys.NUMPAD1).keyUp(Keys.CONTROL).perform();
}
public void clickOnNewBrowserTab() {
	driver.findElement(NewBrowserTab).click();
}
public void switchToDefaultFrame() {
	driver.switchTo().defaultContent();
	System.out.println(driver.getTitle());
}
public void clickOnOpenSeperateWindow() {
	driver.findElement(OpenSeperateNewWindow).click();
}

public void switchParentWindow() {
	String parentWindow=driver.getWindowHandle();
	driver.switchTo().window(parentWindow);
}
public void switchWindow() {
	Set<String> window=driver.getWindowHandles();
	for(String w:window){
		driver.switchTo().window(w);
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("HTML Frames - Example 1")){
			driver.switchTo().frame(driver.findElement(frameName1));
			System.out.println(driver.findElement(frame1).getText());
//			driver.switchTo().frame(driver.findElement(frameName2));
//			System.out.println(driver.findElement(frame2).getText());
		}
	}
}
public void clickOnFrameSet() {
	driver.findElement(FrameSet).click();
}
public void clickOnFrameSetWindow() {
	driver.findElement(OpenFramesetWindow).click();
}
public void clickOnOpenMultipleWindows() {
	driver.findElement(OpenMultipleWindows).click();
}
public void clickOnOpenMultiplePages() {
driver.findElement(OpenMultiplePages).click();
}	
}
