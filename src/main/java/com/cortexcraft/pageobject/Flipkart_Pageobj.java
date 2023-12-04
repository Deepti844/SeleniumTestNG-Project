package com.cortexcraft.pageobject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_Pageobj extends TestBase {
	
	@FindBy(name = "q")
	public WebElement inputfield;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
	public WebElement phoneLink_1;
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	public WebElement cancelButton;
		
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")
	public WebElement search;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]")
	public WebElement popularity;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
	public WebElement appleIPhone;
	
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w, this);
	}

}
