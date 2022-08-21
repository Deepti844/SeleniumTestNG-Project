package com.itview.testcases;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Data_Driven_FixedDeposit {
  
	
	
	WebDriver w; 
  @BeforeTest
  public void openBrowser() {
	  
	  WebDriverManager.chromedriver().setup();
	  w = new ChromeDriver();
	  w.manage().window().maximize();
  }
  
  @Test(priority =0,description = "validate Fixed Deposit with multiple data  ")
  public void verifyFixedDeposit_SI() throws InterruptedException {
	  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	  
	  w.findElement(By.id("wzrk-cancel")).click();
	  
	  w.findElement(By.id("principal")).clear();
	  w.findElement(By.id("principal")).sendKeys("3000000");
	  
	  w.findElement(By.name("interest")).clear();
	  w.findElement(By.name("interest")).sendKeys("6.5");
	  
	  w.findElement(By.name("tenure")).clear();
	  
	  w.findElement(By.name("tenure")).sendKeys("4");
	  
	  //droplist
	  
	  WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));
	  Select tenurePeriodDropDown= new Select(tenurePeriod);
	  tenurePeriodDropDown.selectByVisibleText("year(s)");
	  
	  //frequency dropdown, SI
	  WebElement frequency = w.findElement(By.id("frequency"));
	  Select frequencyPeriodDropDown= new Select(frequency);
	  frequencyPeriodDropDown.selectByVisibleText("Simple Interest");
	  
	  
	  w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
	  String maturityAmt = w.findElement(By.id("resp_matval")).getText();
	  
	  Thread.sleep(2000);
	  
	  System.out.println("Maturity Amount : "+maturityAmt);
	  
	  
	  
	  
	  
	  
	  
	  
	 
  }

  @AfterTest
  public void afterTest() {
  }

}
