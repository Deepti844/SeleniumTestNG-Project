package com.itview.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excelreading {
	WebDriver w;
	FileInputStream fi;
	DataFormatter df;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;

	public static void main(String[] args) throws Exception {
		
		DataFormatter df = new DataFormatter();
		FileInputStream fi = new FileInputStream(".\\Test_Data\\FDCal.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sht= wb.getSheetAt(0);
		
		int rowcount=sht.getLastRowNum();
		
		for(int i =1;i<=rowcount;i++) {
			  row=sht.getRow(i);
		}

	}

}
