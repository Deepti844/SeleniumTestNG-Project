package com.itview.login.selenium_test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcelWorkBook  {

	public static void main(String[] args)throws Exception {
		
		DataFormatter df =new DataFormatter();
		
		FileInputStream fi =new FileInputStream(".\\Test_Data\\FDCal.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fi);
		XSSFSheet sht = wb.getSheetAt(0);
		XSSFRow row = sht.getRow(1);
		XSSFCell cell_A = row.getCell(0);
		XSSFCell cell_D = row.getCell(3);
		
		System.out.println("cell value : "+df.formatCellValue(cell_A));
		System.out.println("cell value : "+df.formatCellValue(cell_D));
		
		
 	 	
		
		
	}

}
