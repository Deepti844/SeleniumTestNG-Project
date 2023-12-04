package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.EducationEMI_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class EducationalLoanTest {
	EducationEMI_PageObj edu =new EducationEMI_PageObj();
  
  @BeforeTest
  public void preCondition() throws Exception {
	  edu.openBrowser(edu.ReadDataFromPropertiesFile("browser"));
	  edu.callPageFactoryElement();
	  
	  
  }
  
  @Test(priority=0,description ="Educational Loan of 8 lakhs")
  public void EducationalLoan() throws Exception {
	  edu.openApplicationUrl();
	  edu.handleClickEvent(edu.cancelWindow);
	  edu.handleClickEvent(edu.educationLoanEMILink);
	  edu.handleTextbox(edu.educationLoanAmount, "800000");
	  edu.handleTextbox(edu.interestRate, "5");
	  edu.handleTextbox(edu.loanPeriod, "3");
	  edu.handleTextbox(edu.emiStartFrom, "36");
	  edu.handleClickEvent(edu.submitlink);
	  edu.pageScrollDown();
	  
	  edu.waitForSec(3);
	  edu.getValidationValue(edu.totalPayment);
	  
	  System.out.println("Total payment for educational loan:"+edu.totalPayment);
  }

  @AfterTest
  public void postCondition() {
	  edu.closeBrowser();
  }

}
