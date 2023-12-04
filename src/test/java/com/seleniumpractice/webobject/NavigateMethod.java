package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NavigateMethod {
	WebDriver w;
	
 
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  w =new ChromeDriver();
	  	  
  }
  @Test
  public void navigation() throws Exception {
	  w.navigate().to("https://www.selenium.dev/");
	  Thread.sleep(2000);
	  
	  //download
	  w.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();
	  Thread.sleep(2000);
	  
	  //navigate back
	  w.navigate().back();
	  Thread.sleep(2000);
	  
	  //navigate forward
	  w.navigate().forward();
	  Thread.sleep(2000);
	  
	//navigate back
	  w.navigate().back();
	  Thread.sleep(2000);
	  
	  //navigate project
	  Thread.sleep(2000);
	  w.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[5]/a/span")).click();
	  Thread.sleep(2000);
	  
//	  navigate refresh
	  w.navigate().refresh();
	  Thread.sleep(2000);
	  
	  System.out.println("Success...");
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  w.quit();
  }

}
