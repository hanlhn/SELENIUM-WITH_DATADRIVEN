package com.Utils;

import java.util.ArrayList;
import java.util.List;

public class Common {
	public static List<String> returnResult(String strException){
		List<String> lsResult = new ArrayList<String>();
		if (strException == null || "".equals(strException)){
			lsResult.add(Constants.CONST_PASSED);
			lsResult.add("");
		} else {
			lsResult.add(Constants.CONST_FAILED);
			lsResult.add(strException);
		}
		return lsResult;
	}
}
