package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ScreenshotCode {
	WebDriver w;
	
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  w = new ChromeDriver();
	  
  }
  @Test
  public void Code_for_Screenshots() throws Exception {
	  
	  w.get("https://www.selenium.dev/");
	  String screenshotPath =".\\Screenshots\\SeleniumHomepage.png"; //.gif .jng .png
	  TakesScreenshot ts = (TakesScreenshot)w;
	  File fi = ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(fi,new File(screenshotPath));
	  
	  Thread.sleep(2000);
	  
	  }
  @AfterTest
  public void afterTest() {
	  w.quit();
  }

}
