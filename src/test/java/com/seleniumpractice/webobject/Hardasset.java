package com.seleniumpractice.webobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hardasset {
	WebDriver w;
	
  @Test(priority =0,description = "Verify Google page on 'Chrome'")
  public void chromeBrowser() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  
	  w= new ChromeDriver();
	  w.get("https://www.google.com/");
	  
	  String pageTitle =w.getTitle();
	  Assert.assertEquals(pageTitle,"Google");
	  
	  Thread.sleep(2000);
	  w.quit();
  }
  
  @Test(priority =1,description = "Verify Google page on 'Firefox'")
  public void firefoxBrowser() throws Exception {
	  
	  WebDriverManager.firefoxdriver().setup();
	  w =new FirefoxDriver();
	  w.get("https://www.google.com/");
	  
	  String pageTitle =w.getTitle();
	  Assert.assertEquals(pageTitle,"Google");
	  
	  Thread.sleep(2000);
	  w.quit();
	  
  }
  
  @Test(priority =2,description = "Verify Google page on 'Edge'")
  public void edgeBrowser() throws Exception {
	  WebDriverManager.edgedriver().setup();
	  
	  w =new EdgeDriver();
	  
	  w.get("https://www.google.com/");
	  
	  String pageTitle =w.getTitle();
	  Assert.assertEquals(pageTitle,"Google");
	  
	  Thread.sleep(2000);
	  w.quit();
	  
  }
}
