package com.Utils;

import org.openqa.selenium.WebDriver;

public class Constants {
	
	//COLUNM INDEX OF DATA DRIVEN FILE
	public static final Integer CONST_ID_INDEX					=	0;
	public static final Integer CONST_STEPS_INDEX				=	1;
	public static final Integer CONST_ACTION_INDEX				=	2;
	public static final Integer CONST_TARGET_INDEX				=	3;
	public static final Integer CONST_VALUE_INDEX				=	4;
	public static final Integer CONST_STATUS_INDEX				=	5;
	public static final Integer CONST_LOG_INDEX					=	6;
	
	//INPUT DATA FILE
	public static final String CONST_DATA_DRIVEN_PATH			=	".//inputdata//template.xlsx";
	public static final String CONST_CONFIG_PATH				=	"";
	
	//STEP STATUS
	public static final String CONST_PASSED						=	"PASSED";
	public static final String CONST_FAILED						=	"FAILED";
	
	//WEBDRIVER
	public static final WebDriver CONST_DRIVER					=	Browser.OpenBrowser();
	
	//SELECTOR
	public static final String CONST_ELEMENT_ID					=	"id";
	public static final String CONST_ELEMENT_NAME				=	"name";
	public static final String CONST_ELEMENT_CSS				=	"css";
	public static final String CONST_ELEMENT_XPATH				=	"xpath";
}
