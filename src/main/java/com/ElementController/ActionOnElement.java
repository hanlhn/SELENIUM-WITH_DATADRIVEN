package com.ElementController;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Utils.Actions;
import com.Utils.Constants;

public class ActionOnElement {
//	static WebDriver driver;
	
	public static String Action(WebElement element, String action, String getBy, String target, String value){
		WebDriver driver = Constants.CONST_DRIVER;
		String log;
		try{
			element = GetElementBy.getElementTarget(getBy, target);
			switch (action) {
			case Actions.ACT_CLEAR:
				element.clear();
				break;
			case Actions.ACT_CLICK:
				element.click();
				break;
			case Actions.ACT_CLOSE:
				driver.quit();
				break;
			case Actions.ACT_DELAY:
				Thread.sleep((int) Float.parseFloat(target) * 1000);
				break;
			case Actions.ACT_OPEN:
				driver.get(target);
				break;
			case Actions.ACT_SENDKEY:
				element.sendKeys(value);
				break;
			case Actions.ACT_SUBMIT:
				element.submit();
				break;
			}
			
			log = "";
		}
		catch(Exception ex){
			log = ex.toString();
		}
		return log;
	}
}
