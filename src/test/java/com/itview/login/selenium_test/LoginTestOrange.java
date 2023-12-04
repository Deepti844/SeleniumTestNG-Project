package com.itview.login.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestOrange  {

	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		
		WebDriver w = new ChromeDriver(options);
		  
//		  WebDriverManager.edgedriver().setup();
//		  WebDriver w =new EdgeDriver();
		//name / type /value =  tagName[attribute='data']
		// input[name='username']
		
		w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		w.findElement(By.name("username")).sendKeys("Admin");
		w.findElement(By.name("password")).sendKeys("admin123");
		w.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		w.findElement(By.cssSelector("i.oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon")).click();
		//w.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
		//w.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Logout")).click();
		System.out.println("---SUCCESS----");
		
		w.quit();
		
	}

}
