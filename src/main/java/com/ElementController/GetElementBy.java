package com.ElementController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Utils.Constants;

public class GetElementBy {
	
	public static WebElement getElementTarget(String getBy, String target){
		WebDriver driver = Constants.CONST_DRIVER;
		if (getBy.isEmpty() || getBy == null) return null;
		
		WebElement element = null;
		switch (getBy){	
		case Constants.CONST_ELEMENT_ID:
			element = driver.findElement(By.id(target));
			break;
		case Constants.CONST_ELEMENT_NAME:
			element = driver.findElement(By.name(target));
			break;
		case Constants.CONST_ELEMENT_CSS:
			element = driver.findElement(By.cssSelector(target));
			break;
		case Constants.CONST_ELEMENT_XPATH:
			element = driver.findElement(By.xpath(target));
			break;		
		default:
			break;
		}
		return element;
	}
}
