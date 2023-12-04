package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CarHome_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CarHomeTest {
	CarHome_PageObj ch =new CarHome_PageObj();
	
  
  @BeforeTest
  public void preConidition() throws Exception {
	  ch.openBrowser(ch.ReadDataFromPropertiesFile("browser"));
	  ch.callPageFactoryElement();
	  
	  
  }
  
  @Test(priority=0,description="Verify carhome loan =10 lakh")
  public void carHomeLoanEMI() throws Exception {
	  ch.openApplicationUrl();
	  ch.handleClickEvent(ch.cancelWindow);
	  ch.handleClickEvent(ch.CarHomeLoanEMI);
	  ch.handleTextbox(ch.carhomeLoan, "1000000");
	  ch.handleTextbox(ch.loanPeriod,"3");
	  ch.handleDropDownList(ch.EMIStart,"From next month after disbursement");
	  ch.handleTextbox(ch.interestRate, "7");
	  ch.handleTextbox(ch.upfrontCharges, "1000");
	  ch.pageScrollDown();
	  ch.handleClickEvent(ch.SubmitLink);
	  ch.waitForSec(3);
	  
	  
	  System.out.println("Total Payment :"+ch.getValidationValue(ch.TotalPaymentCarHome));
	  
	  
  }

  @AfterTest
  public void postCondition() {
	  ch.closeBrowser();
  }

}
