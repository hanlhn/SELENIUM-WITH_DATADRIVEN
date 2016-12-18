package com.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Utils.Constants;

public class ReadExcelFile {
	public static void readExcel() throws IOException{
		FileInputStream input_document = new FileInputStream(new File(Constants.CONST_DATA_DRIVEN_PATH)); //Read XLSX document - Office 2007, 2010 format     
        @SuppressWarnings("resource")
		XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document); //Read the Excel Workbook in a instance object    
        XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0); //This will read the sheet for us into another object
        Iterator<Row> rowIterator = my_worksheet.iterator(); // Create iterator object
        List<String> lstRowValue;
//        List<String> lsGetResult;
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
//            lsGetResult = DoStep(lstRowValue);
//            XlsxWriting.WriteXLSX("Sheet1", row.getRowNum(), Constant.colStatusIndex, lsGetResult.get(0), lsGetResult.get(1));
            System.out.println(Arrays.toString(lstRowValue.toArray())); // To iterate over to the next row
        }
        input_document.close(); //Close the XLS file opened for printing
	}
}
