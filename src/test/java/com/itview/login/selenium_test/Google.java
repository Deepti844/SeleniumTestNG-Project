package com.itview.login.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	public static void main(String[] args) {
		WebDriver w;
		WebDriverManager.chromedriver().setup();
		 w = new ChromeDriver();
		 
		
		 System.out.println(" first Sucess ");
		 w.get("https://www.flipkart.com/");
		 w.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		 w.findElement(By.name("q")).sendKeys("Phones");
		 Actions a = new Actions(w);
		 
		 a.sendKeys(Keys.ENTER).build().perform();

		 System.out.println(" second Sucess ");

	}

}
