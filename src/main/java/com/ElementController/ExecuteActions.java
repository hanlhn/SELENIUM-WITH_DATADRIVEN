package com.ElementController;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.Utils.Actions;
import com.Utils.Common;

public class ExecuteActions {
	
	static WebElement element = null;
	
	public static List<String> DoStep(List<String> ActionsOfStep){
		List<String> lsResult = new ArrayList<String>();
		String strAction = ActionsOfStep.get(2).toUpperCase();
		String strTarget = "";// = ActionsOfStep.get(3);
		String strValue = ""; // = ActionsOfStep.get(4);
		if (ActionsOfStep.size() > 3){
			strTarget = ActionsOfStep.get(3);
			strValue = ActionsOfStep.get(4);
		}
		
		switch(strAction) {
		case Actions.ACT_CLEAR:
			String strExceptionClear = ActionOnElement.Action(element, strAction, "", "", "");
			lsResult = Common.returnResult(strExceptionClear);
			break;
		case Actions.ACT_CLICK:
			String [] arrTargetClick = strTarget.split("=");
			String strExceptionClick = ActionOnElement.Action(element, strAction, arrTargetClick[0], arrTargetClick[1], "");
			lsResult = Common.returnResult(strExceptionClick);
			break;
		case Actions.ACT_CLOSE:
			String strExceptionClose = ActionOnElement.Action(element, strAction, "", "", "");
			lsResult = Common.returnResult(strExceptionClose);
			break;
		case Actions.ACT_DELAY:
			String strExceptionDelay = ActionOnElement.Action(element, strAction, "", strTarget, "");
			lsResult = Common.returnResult(strExceptionDelay);
			break;
		case Actions.ACT_OPEN:
			String strExceptionOpen = ActionOnElement.Action(element, strAction, "", strTarget, "");
			lsResult = Common.returnResult(strExceptionOpen);
			break;
		case Actions.ACT_SENDKEY:
			String [] arrTargetSendKey = strTarget.split("=");
			String strExceptionSendKey = ActionOnElement.Action(element, strAction, arrTargetSendKey[0], arrTargetSendKey[1], strValue);
			lsResult = Common.returnResult(strExceptionSendKey);
			break;
		case Actions.ACT_SUBMIT:
			String [] arrTargetSubmit = strTarget.split("=");
			String strExceptionSubmit = ActionOnElement.Action(element, strAction, arrTargetSubmit[0], arrTargetSubmit[1], "");
			lsResult = Common.returnResult(strExceptionSubmit);
			break;
		default:
			break;
		}
		return lsResult;
	}

}
