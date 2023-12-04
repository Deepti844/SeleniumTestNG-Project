package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WindowSize {
	WebDriver w;
	
 
  @BeforeTest
  public void beforeTest() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  w = new ChromeDriver();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  Thread.sleep(3000);
	  w.manage().window().maximize();
  }
  @Test
  public void Code_for_Maximizing_windowsize() throws Exception {
	  
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	  
//	  class dimension
	  Dimension d = new Dimension(1400,800);
	  w.manage().window().setSize(d);
	  Thread.sleep(3000);
	  w.manage().window().minimize();
	  System.out.println("Success++++++++++++++++++++");
  }

  @AfterTest
  public void afterTest() {
	  w.quit();
  }

}
