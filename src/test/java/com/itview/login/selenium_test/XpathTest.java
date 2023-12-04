package com.itview.login.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathTest {

	public static void main(String[] args)  throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver w = new ChromeDriver();
		
		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.xpath("//*[@id=\"LinkHeader2\"]")).click();
		Thread.sleep(3000);
		w.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[3]/div/a")).click();
		
		
		System.out.println("--PASSED---");
		
		
		
	w.quit();
	}

}
