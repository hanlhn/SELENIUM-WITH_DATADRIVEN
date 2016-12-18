package com.ElementController;

import org.openqa.selenium.WebElement;

import com.Utils.Actions;
import com.Utils.Constants;

public class ActionOnElement {
//	static WebDriver driver;
	
	public static String Action(WebElement element, String action, String getBy, String target, String value){
		String log;
		try{
			element = GetElementBy.getElementTarget(getBy, target);
			switch (action) {
			case Actions.ACT_CLOSE:
				Constants.CONST_DRIVER.quit();
				break;
			case Actions.ACT_OPEN:
				Constants.CONST_DRIVER.get(target);
				break;
			case Actions.ACT_SENDKEY:
				element.sendKeys(value);
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
