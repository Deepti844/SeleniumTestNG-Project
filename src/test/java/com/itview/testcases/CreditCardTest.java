package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CreditCard_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CreditCardTest {
	CreditCard_PageObj cc = new CreditCard_PageObj();
  
  @BeforeTest
  public void preCondition() throws Exception {
	  cc.openBrowser(cc.ReadDataFromPropertiesFile("browser"));
	  cc.callPageFactoryElement();
  }
  
  @Test(priority=0,description="Verify OutStanding Amount=10000")
  public void outStandingAmount_10000() throws Exception {
	  cc.openApplicationUrl();
	  cc.handleClickEvent(cc.cancelWindow);
	  cc.handleTextbox(cc.outstandingAmount, "10000");
	  cc.handleTextbox(cc.paymentPlanEveryMonth, "1000");
	  cc.handleTextbox(cc.monthlyInterest, "6");
	  cc.pageScrollDown();
	  cc.handleClickEvent(cc.SubmitLink);
	  
	  
	  cc.waitForSec(3);
	    
	  System.out.println("Total payment for 10000 :"+cc.getValidationValue(cc.totalPayment));
	  //hard assert
	  Assert.assertEquals(cc.getValidationValue(cc.totalPayment), "15,730.99");//15,730.99
  }
  
  @Test(priority=1,description="Verify OutStanding Amount=20000")
  public void outStandingAmount_20000() throws Exception {
	  cc.openApplicationUrl();
	  cc.handleTextbox(cc.outstandingAmount, "20000");
	  cc.handleTextbox(cc.paymentPlanEveryMonth, "1500");
	  cc.handleTextbox(cc.monthlyInterest, "7");
	  cc.handleClickEvent(cc.SubmitLink);
	  cc.pageScrollDown();
	  
	  cc.waitForSec(3);
	  
	  System.out.println("Total payment for 20000 :"+cc.getValidationValue(cc.totalPayment));
  }

  @AfterTest
  public void postCondition() {
	  cc.closeBrowser();
  }

}
