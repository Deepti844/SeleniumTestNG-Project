package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EducationEMI_PageObj extends TestBase {
	
	@FindBy(linkText="Education Loan EMI")
	public WebElement educationLoanEMILink;
	
	@FindBy(id="educ_loan")
	public WebElement educationLoanAmount;
	
	@FindBy(id="interest_rate")
	public WebElement interestRate;
	
	@FindBy(id="loan_period")
	public WebElement loanPeriod;
	
	@FindBy(id="emi_start_from")
	public WebElement emiStartFrom;
	
	@FindBy(id ="wzrk-cancel")
	public WebElement cancelWindow;
	
	@FindBy(linkText="Submit")
	public WebElement submitlink;
	
	@FindBy(id="total_payment")
	public WebElement totalPayment;
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w,this);
	}
	
	

}
