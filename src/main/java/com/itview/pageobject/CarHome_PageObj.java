 package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarHome_PageObj extends TestBase {

	@FindBy(xpath="/html/body/div[15]/section[1]/div/div/div[1]/ul/li[3]/a")
	public WebElement CarHomeLoanEMI;
	
	@FindBy(id="carhome_loan")
	public WebElement carhomeLoan;
	
	@FindBy(id="loan_period")
	public WebElement loanPeriod;

	
	@FindBy(css="select.custselect")
	public WebElement EMIStart;
	
	@FindBy(id="interest_rate")
	public WebElement interestRate;
	
	@FindBy(id="upfront_charges")
	public WebElement upfrontCharges;
	
	
	@FindBy(linkText="Submit")
	public WebElement SubmitLink;
	
	@FindBy(id ="wzrk-cancel")
	public WebElement cancelWindow;
	
	@FindBy(id="total_payment")
	public WebElement TotalPaymentCarHome;
	
	public void callPageFactoryElement() {
	PageFactory.initElements(w, this);
	}
}
