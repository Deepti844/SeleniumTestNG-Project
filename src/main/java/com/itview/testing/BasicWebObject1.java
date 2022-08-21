package com.itview.testing;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BasicWebObject1 {
	
	WebDriver w;
  
  @BeforeTest
  public void preCondition() {
	  
	  WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
  }

  
  @Test
  public void handleTextBox() {
	  
	  w.get("https://demo.automationtesting.in/Register.html");
  }
  
  
  @AfterTest
  public void postconidition() {
	  
	  //w.quit();
  }

}
