package com.automation.HomePage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_001_EnterDetails {
	WebDriver driver;
	@BeforeTest
	public void setup(){
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
	driver= new ChromeDriver(options);
//		log.info("navigate To:-" OR.getProperty("url"));
		driver.get("https://www.redbus.in/");	
	}
	@Test
	public void enterDetails(){
		driver.findElement(By.xpath(".//*[@id='src']")).sendKeys("Chennai");
		driver.findElement(By.xpath(".//*[@id='dest']")).sendKeys("Lucknow");
		String selectDate="15-July-2017";
		Date d=new Date(selectDate);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MMMM/yyyy");
		String date=sdf.format(d);
		System.out.println(date);
		String [] arr=date.split("/");
		String month=arr[1].substring(0, 4);
		String monthYr= month+" "+ arr[2];
		System.out.println(monthYr);
		driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/div/label")).click();
		
				try{
//					WebElement ele=driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
//					System.out.println(ele.getText());
			driver.findElement(By.xpath(".//div[@id='rb-calendar_onward_cal']//table//tbody//tr//td[contains(text(), 'July 2017')]")).isDisplayed();
			System.out.println("element Displayed");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			for(int row=3; row<9;row=row+1){
				for (int column=1; column<8; column++){
					WebElement datepicker=driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr["+row+"]/td["+column+"]"));
//					WebElement sample=driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[3]/td[6]"));
//					System.out.println(sample.getText());
					String calDate=datepicker.getText();
						if(calDate=="17"){
							System.out.println("success");
							break;
						}
					}
//					System.out.println("good till now");
				
				}
				}
			
//			WebElement datepicker=driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody"));
//			List<WebElement> dates= datepicker.findElements(By.tagName("td"));
//			System.out.println("date added in list");
//			for(WebElement Pdate:dates){
//				String calDate=Pdate.getClass();
//				if(calDate==arr[0]){
//					System.out.println("success");
//					break;
//				}
//			}
//			System.out.println("good till now");
//			break;
//		}
		
		catch(Exception e){
			driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button")).click();
			System.out.println("next clicked");
		}
			}
		
		 	
		
	
	@AfterTest
	public void endTest(){
		
	}
}
