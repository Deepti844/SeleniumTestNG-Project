package com.seleniumpractice.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class MouseHandling {
   WebDriver w;
   
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  w =new ChromeDriver();
	  w.manage().window().maximize();
	 // w.manage().
	  
  }
  @Test
  public void f() throws Exception {
	  
	  w.get("https://www.ebay.com/");
	  w.findElement(By.linkText("Electronics")).click();
	  
	  w.navigate().back();
	  
  Actions a = new Actions(w);
	  
	  WebElement ElectronicsLink= w.findElement(By.linkText("Electronics"));
	  
	  a.moveToElement(ElectronicsLink).build().perform();
	  Thread.sleep(3000);
	  WebElement Samsung = w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[2]/a"));
	  
	  a.moveToElement(Samsung).build().perform();
	  
	  Thread.sleep(3000);
	  
	  a.click(Samsung).build().perform();
	  
	  WebElement rightclick_Smartphones =w.findElement(By.linkText("Cell Phones, Smart Watches & Accessories"));
	  
	  a.contextClick(rightclick_Smartphones).build().perform();
  
	  //drag and drop
	  
	  w.get("http://crossbrowsertesting.github.io/drag-and-drop.html");
	  
	  WebElement drag = w.findElement(By.id("draggable"));
	  WebElement drop = w.findElement(By.id("droppable"));
	  
	  a.dragAndDrop(drag, drop).build().perform();
  }

  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}
