package com.cortexcraft.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageobject_1 extends TestBase{
	
	@FindBy(id="loginDropDownlink")
	public WebElement Sig_in;
	
	@FindBy(id="inputEmaillogin")
	public WebElement Email;
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w, this);
	}
	

}
