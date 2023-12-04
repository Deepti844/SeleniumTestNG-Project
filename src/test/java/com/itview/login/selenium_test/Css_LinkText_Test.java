package com.itview.login.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Css_LinkText_Test {

	public static void main(String[] args) throws Exception {
		
	WebDriverManager.chromedriver().setup();
	WebDriver w = new ChromeDriver();
	
	w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 Thread.sleep(3000);
	 
	 w.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
	 w.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
	 
	 Thread.sleep(3000);
	 w.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	 w.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/img")).click();
	 //w.findElement(By.linkText("Paul Collings")).click();
	 Thread.sleep(3000);
	 w.findElement(By.linkText("Logout")).click();
	 
	 
	 System.out.println("---SUCCESS---");
	 Thread.sleep(3000);
	
	
	w.quit();

	}

}
