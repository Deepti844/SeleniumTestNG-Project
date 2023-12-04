package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class KeyboardHandling {
	WebDriver w;
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  w = new ChromeDriver();
	  w.manage().window().maximize();
  }
  
  @Test
  public void f() {
	  Actions a = new Actions(w);
	  
	  w.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
	  
	  w.findElement(By.name("firstName")).clear();
	  w.findElement(By.name("firstName")).sendKeys("JonesP");
	  
	  a.sendKeys(Keys.BACK_SPACE).build().perform();
	  a.sendKeys(Keys.TAB).build().perform();
	  
	  w.findElement(By.name("lastName")).clear();
	  w.findElement(By.name("lastName")).sendKeys("Smith");
	  
	  a.sendKeys(Keys.TAB).build().perform();
	  
	  a.sendKeys(Keys.TAB).build().perform();
	  a.sendKeys(Keys.TAB).build().perform();
	  
	  a.sendKeys(Keys.ENTER).build().perform();
	  
	  w.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[3]/div[3]/div/div[1]/div/div/div[1]/div/input")).click();
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}
