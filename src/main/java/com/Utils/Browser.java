package com.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static WebDriver OpenBrowser(){
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",".//references//chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get(url);
		return driver;
	}
}
