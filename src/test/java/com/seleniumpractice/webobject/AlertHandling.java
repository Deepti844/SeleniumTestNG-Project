package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AlertHandling {
  
	WebDriver w;
	  
	  @BeforeTest
	  public void precondition() {
		  WebDriverManager.chromedriver().setup();
		  w =new ChromeDriver();
	  }
  @Test
  public void handleAlert() throws Exception {
	  
	  w.get("https://demo.testfire.net/login.jsp");
//	  w.findElement(By.id("uid")).sendKeys("1");
//	  w.findElement(By.name("btnSubmit")).click();
	  
	  Thread.sleep(2000);
	  
	  try {
		  w.switchTo().alert().accept();
		  System.out.println("ALERT!!!!");
		  
	  }
	  catch(NoAlertPresentException a)
	  {
		    System.out.println("NO ALERT......"); 
	  }
	  
	  Thread.sleep(2000);
	  
	  w.findElement(By.id("uid")).clear();
	  w.findElement(By.id("uid")).sendKeys("admin");
	  w.findElement(By.id("passw")).clear();
	  w.findElement(By.id("passw")).sendKeys("admin");
	  w.findElement(By.name("btnSubmit")).click();
  }

  @AfterTest
  public void afterTest() {
	  w.quit();
  }

}
