package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class LoginOrangeHRM {
	
	WebDriver w;
  
  @BeforeTest
  public void preCondition_openBrowser() {
	  WebDriverManager.chromedriver().setup();
	  w= new ChromeDriver();
//	  WebDriverManager.edgedriver().setup();
//	  w =new EdgeDriver();
  }
  
  @Test
  public void loginOrangeHRM() throws Exception {
	  w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		w.findElement(By.name("username")).sendKeys("Admin");
		w.findElement(By.name("password")).sendKeys("admin123");
		w.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		w.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	  
  }

  @AfterTest
  public void postCondition_closeBrowser() {
	  w.quit();
  }

}
