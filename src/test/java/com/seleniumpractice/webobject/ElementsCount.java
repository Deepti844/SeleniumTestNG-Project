package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ElementsCount {
	WebDriver w;
  
  @BeforeTest
  public void precondition() {
	  WebDriverManager.chromedriver().setup();
	  w =new ChromeDriver();
	  
  }
  @Test(priority=0,description ="Test case for counting elements in a Web Page")
  public void CountofElements() throws Exception {
	  w.get("http://demo.automationtesting.in/Register.html");
	  
	  Thread.sleep(2000);
	  
	  //count of radioButtons
	  List<WebElement> radioButton=w.findElements(By.name("radiooptions"));
	  System.out.println("Number of radioButton : "+radioButton.size());
	  
	  //count of checkbox
	  
	  List<WebElement>checkbox=w.findElements(By.cssSelector("input[type='checkbox']"));
	  System.out.println("Number of checkbox : "+checkbox.size());
	  
	  //count of dropDown
	  
	  List<WebElement>dropDown=w.findElements(By.tagName("select"));
	  System.out.println("Number of dropDown : "+dropDown.size());
	  
	  //count of links
	  
	  List<WebElement>links=w.findElements(By.tagName("a"));
	  System.out.println("Number of links : "+links.size());
  }
  @AfterTest
  public void postCondition() {
	  w.quit();
  }

}
