package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BasicWebObject1 {
	WebDriver w;
 
  @BeforeTest
  public void preCondition() {
	  WebDriverManager.chromedriver().setup();
	  w =new ChromeDriver();
	  
  }
  @Test(priority=0,description="Handle Textbox")
   public void handleTextBox() {
	  w.get("http://demo.automationtesting.in/Register.html");
	  w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Jones");
	  
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Steven");
	  
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
	  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("123 , Block7, Sample Address");
	  
	  w.findElement(By.cssSelector("input[type='email']")).clear();
	  w.findElement(By.cssSelector("input[type='email']")).sendKeys("ABC@xyz.com");
	  
	  
	  w.findElement(By.cssSelector("input[ng-model='Phone']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='Phone']")).sendKeys("8575956212");
	  
	  
	  
  }
  
  @Test(priority=1,description="Handle Radio button and CheckBox")
  public void handleRadioCheckBox() {
	  w.findElement(By.cssSelector("input[value='FeMale']")).click();
	  w.findElement(By.id("checkbox1")).click();
	  w.findElement(By.id("checkbox2")).click();
	  
  }
  
  @Test(priority=2,description="Handle Drop down list")
  public void handleDropdownlist() {
	  
	  WebElement Skill= w.findElement(By.id("Skills"));
	  
	  Select sel = new Select(Skill);
	  
//	  sel.selectByIndex(4);
//	  sel.selectByValue("Java");// Java is from Select -> Option tage
	  sel.selectByVisibleText("C");
	  
  }
	  
	  @Test(priority=4,description="Print Drop down list")
	  public void printValueFromDropDown() 
	  {
		  WebElement monthList= w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));
		  
		  Select sel =new Select(monthList);
		  
		  List <WebElement> elementFromDropDownList= sel.getOptions();
		  
		  System.out.println("\n Print months list : \n");
		  
		  for(int i=1;i<elementFromDropDownList.size();i++)
		  {
			 System.out.println(elementFromDropDownList.get(i).getText()); 
			  
			  
		  }  
			  
	  }
		  
		    
	  
  
  @AfterTest
  public void postCondition() {
//	  w.quit();
  }

}
