package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCard_PageObj extends TestBase{
	
	@FindBy(id ="debtpayoff")
	public WebElement outstandingAmount;
	
	@FindBy(id="monthly_interest")
	public WebElement monthlyInterest;
	
	@FindBy(id="payment_plan_every_month")
	public WebElement paymentPlanEveryMonth;
	
	@FindBy(linkText ="Submit")
	public WebElement SubmitLink;
	
	@FindBy(id ="total_payment")
	public WebElement totalPayment;
	
	@FindBy(id ="wzrk-cancel")
	public WebElement cancelWindow;
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w, this);
	}

}
