package com.itview.testcases;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Datadriven_FD_Dataprovider {
 
	WebDriver w;
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "1000000","5","4","Simple Interest" },
      new Object[] { "4000000","8.5","9","Simple Interest" },
      new Object[] { "8000000","6.5","6","Simple Interest" },
    };
  }
  @BeforeTest
  public void perCondition() {
	  
	  
	  WebDriverManager.chromedriver().setup();
	  w= new ChromeDriver();
	  w.manage().window().maximize();
	  
  }
  
  @Test(dataProvider = "dp")
  public void dataDriven_DataProvider(String principle, String ROI,String tenure_perioddata,String frequency_data) throws Exception {
	  
 w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	  
	  try {
	  w.findElement(By.id("wzrk-cancel")).click();
	  }
	  catch(Exception e) {}
	  
	  Thread.sleep(2000);
	  
	  
	  w.findElement(By.id("principal")).clear();
	  w.findElement(By.id("principal")).sendKeys(principle);
	  
	  w.findElement(By.id("interest")).clear();
	  w.findElement(By.id("interest")).sendKeys(ROI);
	  
	  w.findElement(By.id("tenure")).clear();
	  w.findElement(By.id("tenure")).sendKeys(tenure_perioddata);
	  
	  //tenurePeriod=id
	  WebElement tenurePeriod= w.findElement(By.id("tenurePeriod"));
	  Select seltenure =new Select(tenurePeriod);
	  seltenure.selectByVisibleText("year(s)");
	  
	  //frequency
	  WebElement frequencylist=w.findElement(By.id("frequency"));
	  Select selfrequency =new Select(frequencylist);
	  selfrequency.selectByVisibleText(frequency_data);
	  
	  
	  //calculate button
	  w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
	  
	  Thread.sleep(2000);
	 
	 String Amount=w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
	  
	  System.out.println("Maturity value :"+Amount);
//	  System.out.println("row count: "+row);
	  } 
  

  @AfterTest
  public void postCondition() {
	  w.quit();
  }

}
