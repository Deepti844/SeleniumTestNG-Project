package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginMutualFund {
	
	WebDriver w;
 
  @BeforeTest
  public void preCondition_openBrowser() {
	  
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  w= new ChromeDriver(options);
	  
  }
  
  @Test(priority=0,description="Test case to validate login -admin functionality",groups = "Login")
  
  public void loginAdmin() throws Exception {
	  
	  w.get("http://demo.testfire.net/login.jsp");
	  w.findElement(By.id("uid")).sendKeys("admin");
	  w.findElement(By.id("passw")).sendKeys("admin");
	  w.findElement(By.name("btnSubmit")).click();
	  
	  Thread.sleep(3000);
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	  
  }

  
  @Test(priority=1,description="Test case to validate login -Jsmith functionality",dependsOnMethods = "loginAdmin",groups = "Login")
  
  public void loginJsmith() throws Exception {
	  
	  w.get("http://demo.testfire.net/login.jsp");
	  w.findElement(By.id("uid")).sendKeys("jsmith");
	  w.findElement(By.id("passw")).sendKeys("Demo1234");
	  w.findElement(By.name("btnSubmit")).click();
	  
	  Thread.sleep(3000);
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	  
	  
	  
  }
  
  
  @Test(priority=2,description="Test case to validate login -Test User functionality",dependsOnMethods = "loginAdmin",groups = "Log",invocationCount=2,enabled = false)
  public void loginTestUser() throws Exception {
	  
	  w.get("http://demo.testfire.net/login.jsp");
	  w.findElement(By.id("uid")).sendKeys("tuser");
	  w.findElement(By.id("passw")).sendKeys("tuser");
	  w.findElement(By.name("btnSubmit")).click();
	  
	  Thread.sleep(3000);
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	  
	  
	  
  }
  @AfterTest
  public void postCondition_closeBrowser() {
	  w.quit();
	  
  }

}
