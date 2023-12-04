package com.itview.login.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Field {

	public static void main(String[] args) {
		WebDriver w;
		WebDriverManager.chromedriver().setup();
		 w = new ChromeDriver();
		 
		 w.get("https://zapier.com/");
		 w.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div/div[1]/div/section/div[1]/div/div[2]/div[2]/div[1]/a/span")).click();
		 
		 w.findElement(By.id("signup-email")).sendKeys("abc@gmail.com");
		w.findElement(By.id("signup-first-name")).sendKeys("DDDDD");
		w.findElement(By.id("signup-last-name")).sendKeys("NNN");
		w.findElement(By.id("signup-last-name")).click();
		 
		 
		 System.out.println("Sucess");

	}

}
