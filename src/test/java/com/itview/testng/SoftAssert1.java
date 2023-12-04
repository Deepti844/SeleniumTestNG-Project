package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class SoftAssert1 {
 
	WebDriver w;
	SoftAssert sft;
	
	
  @BeforeTest
  public void openBrowser() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  w= new ChromeDriver(options);
	  
  }
  
  @Test(priority=0,description ="Validate the login page")
  public void loginTest() throws Exception  {
	  
	  sft =new SoftAssert();
	  
	  w.get("https://demo.testfire.net/login.jsp");
	  Thread.sleep(3000);
	  
	  
	  //validation of title
	  String loginTitle = w.getTitle();
	  sft.assertEquals(loginTitle, "Altoro Mutual","Login Title is wrong!!");
	  
	  //validation of loginURL
	  String loginURL = w.getCurrentUrl();
	  sft.assertTrue(loginURL.contains("login"),"LoginURL mismatching");
	  
	  //validation of page label(page level-->inspect)
	  String pageLabelTitle = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
	  sft.assertTrue(pageLabelTitle.contains("Login"),"Page Label Title is wrong!!!");
	  
	  //enter UN & PW
	  
	  w.findElement(By.name("uid")).sendKeys("admin");
	  w.findElement(By.name("passw")).sendKeys("admin");
	  w.findElement(By.name("btnSubmit")).click();
	  
	  sft.assertAll();
  }
  
  @Test(priority=1,description ="Validate the logout page",dependsOnMethods="loginTest")
  public void logoutTest() throws Exception {
	  
	  sft =new SoftAssert();
	  Thread.sleep(3000);
	  
	  
	  //validate the homepagetitle
	  String homeTitle = w.getTitle();
	  sft.assertEquals(homeTitle, "Altoro Mutual","Home page title is wrong!!!");
	  
	  //validate the homepagelabel
	  String homeLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
	  sft.assertTrue(homeLabel.contains("Admin"),"Home Label is wrong!!!");
	  
	  
	  //logout
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	  
	  
	  
	  
	  
	  sft.assertAll();
	  
	  
  }

  @AfterTest
  public void closeBrowser() {
	  w.quit();
  }

}
