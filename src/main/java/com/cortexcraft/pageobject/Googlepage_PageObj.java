package com.cortexcraft.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Googlepage_PageObj extends TestBase {
	@FindBy(xpath="(//button)[2]")
	public WebElement cancelbutton;
	
	@FindBy(name="q")
	public WebElement inputfield;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button/svg/g/path[2]")
	public WebElement search;
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w,this);//driver information +classname
	}
	
	

}
