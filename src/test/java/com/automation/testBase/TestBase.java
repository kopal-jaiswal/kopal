package com.automation.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;



public class TestBase {
public static Properties repository=new Properties();
public File f;
public WebDriver driver;

public void init() throws IOException {
	 loadPropertiesFile();
	 browser(repository.getProperty("browser"));
	 driver.get(repository.getProperty("url"));
	
}

public void loadPropertiesFile() throws IOException{
 f=new File("C:\\Users\\Kopal\\eclipse_neon_work\\TodoAutomation\\src\\test\\java\\com\\automation\\config\\config.properties");
 			
	FileInputStream fis=new FileInputStream(f);
	repository.load(fis);
}

public WebDriver browser(String browser) {
	if(browser.equals("firefox")|| browser.equals("FIREFOX")){
//		System.setProperty(key, value)
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	else if(browser.equals("chrome")|| browser.equals("CHROME")){
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
//		driver.manage().window().maximize();
		return driver;
	}
	else if(browser.equals("ie")|| browser.equals("IE")){
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	return null;
	
}
}
