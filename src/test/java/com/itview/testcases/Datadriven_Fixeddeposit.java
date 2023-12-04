package com.itview.testcases;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Datadriven_Fixeddeposit {
	
	WebDriver w;
	FileInputStream fi;
	DataFormatter df;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell  principle,ROI,tenure_period,frequencycell,maturtiy_value;
	
	
  @BeforeTest
  public void preCondition() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  w=new ChromeDriver();
	  w.manage().window().maximize();
	  
	  df= new DataFormatter();
	  fi =new FileInputStream(".\\Test_Data\\FDCal.xlsx");
	  wb = new XSSFWorkbook(fi);
	  sht = wb.getSheetAt(0);
	  
  }
  
  @Test
  public void compoundedMonthly() throws Exception {
	  int rowCount = sht.getLastRowNum();
	  for(int i =1;i<=rowCount;i++)
	  {
		   row=sht.getRow(i);
		  
	  principle = row.getCell(0);
	  ROI = row.getCell(1);
	  tenure_period = row.getCell(2);
	  frequencycell = row.getCell(3);
	  maturtiy_value = row.getCell(4);
	  
	  
	  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	  
	  try {
	  w.findElement(By.id("wzrk-cancel")).click();
	  }
	  catch(Exception e) {}
	  
	  Thread.sleep(2000);
	  
	  
	  w.findElement(By.id("principal")).clear();
	  w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principle).toString());
	  
	  w.findElement(By.id("interest")).clear();
	  w.findElement(By.id("interest")).sendKeys(df.formatCellValue(ROI).toString());
	  
	  w.findElement(By.id("tenure")).clear();
	  w.findElement(By.id("tenure")).sendKeys(df.formatCellValue(tenure_period).toString());
	  
	  //tenurePeriod=id
	  WebElement tenurePeriod= w.findElement(By.id("tenurePeriod"));
	  Select seltenure =new Select(tenurePeriod);
	  seltenure.selectByVisibleText("year(s)");
	  
	  //frequency
	  WebElement frequencylist=w.findElement(By.id("frequency"));
	  Select selfrequency =new Select(frequencylist);
	  selfrequency.selectByVisibleText(df.formatCellValue(frequencycell).toString());
	  
	  
	  //calculate button
	  w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
	  
	  Thread.sleep(2000);
	 
	 String Amount=w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
	  
	  System.out.println("Maturity value :"+Amount);
//	  System.out.println("row count: "+row);
	  } 
	  
  }

  @AfterTest
  public void postCondition() {
	 w.quit();
  }

}
