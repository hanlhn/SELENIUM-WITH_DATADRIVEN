package com.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ElementController.ActionOnElement;
import com.ElementController.GetElementBy;
import com.Utils.*;

public class Draft {
	static WebElement element = null;
	public static void ReadXLSX() throws IOException{
		FileInputStream input_document = new FileInputStream(new File(Constants.CONST_DATA_DRIVEN_PATH)); //Read XLSX document - Office 2007, 2010 format     
        @SuppressWarnings("resource")
		XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document); //Read the Excel Workbook in a instance object    
        XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0); //This will read the sheet for us into another object
        Iterator<Row> rowIterator = my_worksheet.iterator(); // Create iterator object
        List<String> lstRowValue;
        List<String> lsGetResult;
        Row row;
        Cell cell;
//        XlsxWriting xlsxWriting = new XlsxWriting();
        while(rowIterator.hasNext()) {
       	 	lstRowValue = new ArrayList<String>();
            row = rowIterator.next(); //Read Rows from Excel document 
            
            if (row.getRowNum() < 1) continue;
            
            for (int i =0; i<row.getLastCellNum(); i++) {
            	cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
           	 	lstRowValue.add(cell.toString());
            }
            if (lstRowValue.size() < 1) continue;
            lsGetResult = DoStep(lstRowValue);
            WriteXLSX("Sheet1", row.getRowNum(), Constants.CONST_STATUS_INDEX, lsGetResult.get(0), lsGetResult.get(1));
            System.out.println(Arrays.toString(lstRowValue.toArray())); // To iterate over to the next row
        }
        input_document.close(); //Close the XLS file opened for printing
	}
	public static List<String> DoStep(List<String> ActionsOfStep){
//		ActionsOfStep = Arrays.asList(new String[6]);
		List<String> lsResult = new ArrayList<String>();
		String strAction = ActionsOfStep.get(2).toUpperCase();
		String strTarget = "";// = ActionsOfStep.get(3);
		String strValue = ""; // = ActionsOfStep.get(4);
		if (ActionsOfStep.size() > 3){
			strTarget = ActionsOfStep.get(3);
			strValue = ActionsOfStep.get(4);
	}
		
		switch(strAction) {
		case Actions.ACT_CLOSE:
			String strExceptionClose = ActionOnElement.Action(element, strAction, "", "", "");
			lsResult = Common.returnResult(strExceptionClose);
			break;
		case Actions.ACT_OPEN:
			String strExceptionOpen = ActionOnElement.Action(element, strAction, "", strTarget, "");
			lsResult = Common.returnResult(strExceptionOpen);
			break;
		case Actions.ACT_SENDKEY:
			String [] arrTarget = strTarget.split("=");
			String strExceptionSendKey = ActionOnElement.Action(element, strAction, arrTarget[0], arrTarget[1], strValue);
			lsResult = Common.returnResult(strExceptionSendKey);
			break;
		
		default:
			break;
		}
		return lsResult;
	}
	

	
//	public static String CloseBrowser(){
//		String log;
//		try{
//			driver.quit();
//			log = "";
//		}
//		catch(Exception ex){
//			log = ex.toString();
//		}
//		return log;
//	}
	
	static void WriteXLSX(String strCurrentSheet, int rowIndex, int cellIndex, String strStatus, String strLog) throws IOException{
		String excelFileName = Constants.CONST_DATA_DRIVEN_PATH;//name of excel file
//		String sheetName = strCurrentSheet;//name of sheet
		
		FileInputStream fileInput = new FileInputStream(excelFileName);
		
//		@SuppressWarnings("resource")
//		XSSFWorkbook wb = new XSSFWorkbook();
//		XSSFSheet sheet = wb.createSheet(strCurrentSheet) ;
//		XSSFRow row = sheet.createRow((short)rowIndex);
//		XSSFCell cell = row.createCell(cellIndex);
//		cell.setCellValue(strStatus);
		XSSFWorkbook wb =  new XSSFWorkbook(fileInput);
		XSSFSheet sheet = wb.getSheet(strCurrentSheet);
		XSSFCell cellStatus = sheet.getRow(rowIndex).createCell(cellIndex);
		XSSFCell cellLog = sheet.getRow(rowIndex).createCell(cellIndex + 1);
		
		cellStatus.setCellValue(strStatus);
		cellLog.setCellValue(strLog);
		fileInput.close();
		
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
}
