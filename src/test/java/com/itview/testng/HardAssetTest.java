package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssetTest {
	WebDriver w;
  
  @BeforeTest
  public void openBrowser() {
	  WebDriverManager.chromedriver().setup();
	  w = new ChromeDriver();
  }
  
  @Test(priority=0,description="Validate Login page")
  public void loginTest() throws Exception {
		w.get("http://demo.testfire.net/login.jsp");
		
		//verify page title "Altoro Login"
		String loginTitle=w.getTitle();
		Assert.assertEquals(loginTitle, "Altoro Mutual");
		
		//verify page url should contains "login"
		String loginURL=w.getCurrentUrl();
		Assert.assertTrue(loginURL.contains("login"),"loginURL is wrong!!!");
		
		//verify page label should have "Login"
		String loginPageLabel= w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
		Assert.assertTrue(loginPageLabel.contains("Login"),"PageLabel is wrong!!");
				

		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		

  }
  
  @Test(priority=1,description="Validate Logout page",dependsOnMethods="loginTest")
  public void logoutTest() throws Exception {
	  Thread.sleep(3000);
	  //verify the home page title
	  String homeTitle=w.getTitle();
	  Assert.assertEquals(homeTitle, "Altoro Mutual","Wrong Home title!!!");
	  
	  
	  //verify the home page label
	  String homePageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
	  Assert.assertTrue(homePageLabel.contains("Admin"),"User name is wrong!!");
	  
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();  
  }

  @AfterTest
  public void closeBrowser() {
	  w.quit();
  }

}
