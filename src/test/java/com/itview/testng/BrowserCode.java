package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

//@before & after test is not requried as we
//are opening different browsers chrome,edge..

public class BrowserCode {
	WebDriver w;
	 
  
  @Test(priority =0,description ="Verify the Google page in Chrome")
  public void chromeBrowser() {
	  WebDriverManager.chromedriver().setup();
	  w =new ChromeDriver();
	  w.get("https://www.google.com/");
	  
	  String pageTitle= w.getTitle();
	  Assert.assertEquals(pageTitle, "Google");
	   
	  w.quit();
	  
  }
  
  @Test(priority =1,description ="Verify the Google page in Edge")
  public void edgeBrowser() {
	  WebDriverManager.edgedriver().setup();
	  w =new EdgeDriver();
	  
	  w.get("https://www.google.com/");
	  
	  String pageTitle= w.getTitle();
	  Assert.assertEquals(pageTitle, "Google");
	   
	  w.quit();
	  
	  
	  
	  
  }

 

}
