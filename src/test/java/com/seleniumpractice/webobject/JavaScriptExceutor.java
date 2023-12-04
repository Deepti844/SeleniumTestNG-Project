package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class JavaScriptExceutor {
	WebDriver w;
	
 
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
	  w = new ChromeDriver();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  w.manage().window().maximize();
  }
  @Test
  public void JavaExecutor() throws Exception {
	  
	  w.get("http://demo.automationtesting.in/Register.html");
	  
	  WebElement firstname =w.findElement(By.cssSelector("input[ng-model='FirstName']"));
	  						
	  
	  WebElement lastname =w.findElement(By.cssSelector("input[ng-model='LastName']"));
	  
	  JavascriptExecutor js = (JavascriptExecutor)w;
	 
	  
	 
	  js.executeScript("alert('Welcome to Register Page...');");
	  
	  
	  Thread.sleep(3000);
	  
	  w.switchTo().alert().accept();
	  
	  //JavaScriptExecutor for input
	  
	  js.executeScript("arguments[0].value=''", firstname);
	  js.executeScript("arguments[0].value='Jones'", firstname);
	  
	  js.executeScript("arguments[0].value=''", lastname);
	  js.executeScript("arguments[0].value='Smith'", lastname);
	  
	  
	  //page scroll down
	  js.executeScript("window.scrollBy(0,600)");
	  
	 
	  Thread.sleep(2000);
	  
	  //selecting from drop down list
	   System.out.println("\n111");
	  Thread.sleep(2000);
	  WebElement skills =w.findElement(By.xpath("//*[@id=\"Skills\"]"));
	  System.out.println("\n111");
	  Select sel = new Select(skills);
	  sel.selectByVisibleText("Java");
	  
	  Thread.sleep(2000);
	  
	  
	  //list box
	  w.findElement(By.id("msdd")).click();
	  Thread.sleep(2000);
	  
	  w.findElement(By.linkText("Arabic")).click();
	  
	  WebElement thai = w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[37]/a"));
	  
	  js.executeScript("arguments[0].scrollIntoView(true);", thai);
	  Thread.sleep(2000);
	  
	  thai.click();
	  
	//page scroll up
	  
	  js.executeScript("window.scrollBy(0,-600)");
	  
	  Thread.sleep(2000);
	  
	 
	  js.executeScript("history.go(0)");//refresh page
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
