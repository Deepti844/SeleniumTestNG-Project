package com.itview.login.selenium_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test123 {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver w =new ChromeDriver();
	
		w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

	}

}
