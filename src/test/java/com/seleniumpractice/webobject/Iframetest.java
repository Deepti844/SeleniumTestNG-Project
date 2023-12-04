package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Iframetest {
	WebDriver w;
 
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  w =new ChromeDriver();
  }
  @Test
  public void Testcaseiframes() throws Exception {
	  
	  w.get("https://demo.automationtesting.in/Frames.html");
//	  Thread.sleep(2000);
	  
	  
	  w.switchTo().frame("singleframe");
	  
	  w.findElement(By.xpath("/html/body/section/div/div/div/input")).clear();
	  w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Selenium");
	  
	  System.out.println("GREAT JOB...SUCCESS...");
	  
	  
	  
  } 

  @AfterTest
  public void afterTest() {
  w.quit();
  }

}
