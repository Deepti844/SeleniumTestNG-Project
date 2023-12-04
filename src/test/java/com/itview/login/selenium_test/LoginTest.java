package com.itview.login.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) throws Exception {
		
// interfaceName instance = new implementation ClassName(); 
		
		WebDriverManager.chromedriver().setup();
		WebDriver w = new ChromeDriver();
		//open blank chrome browser
		
		w.get("http://demo.testfire.net/login.jsp");
		//Step 1 : Open application with url
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		w.quit();
		
		System.out.println("----SUCCESSFULL----");

	}

}
