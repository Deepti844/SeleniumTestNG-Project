package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Window_tab {
  WebDriver w;
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  w = new ChromeDriver();
	  w.manage().window().maximize();
	  
  }
  @Test
  public void f() throws Exception {
	  
	  w.get("https://www.flipkart.com/home-kitchen/home-appliances/washing-machines/fully-automatic-front-load~function/pr?sid=j9e%2Cabm%2C8qx&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Fully%20Automatic%20Front%20Load");
	  w.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();
	  Set winIDs =w.getWindowHandles();
	  
	  System.out.println("Windows id are: "+winIDs);
	  //convert Jagged array to normal array
	  
	   Object windowIds[]= winIDs.toArray();
	   
	   System.out.println("\nWindow 1 Id: "+windowIds[0].toString());
	   System.out.println("\nWindow 2 Id: "+windowIds[1].toString());
	   
	   Thread.sleep(2000);
	   w.switchTo().window(windowIds[0].toString());
	   System.out.println("\nWindow 1 title : "+w.getTitle());
	   
	   Thread.sleep(2000);
	   w.switchTo().window(windowIds[1].toString());
	   System.out.println("\nWindow 2 title : "+w.getTitle());
	   Thread.sleep(2000);
	   w.switchTo().window(windowIds[0].toString());
	   Thread.sleep(2000);
	   
	   
	   
  }
  @AfterTest
  public void afterTest() {
	  w.quit();
  }

}
