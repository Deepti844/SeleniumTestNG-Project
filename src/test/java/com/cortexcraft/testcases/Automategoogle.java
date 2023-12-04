package com.cortexcraft.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automategoogle { 

	public static void main(String[] args) {
		WebDriver w;
		WebDriverManager.chromedriver().setup();
		w= new ChromeDriver();
		
		w.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
				
		WebElement fname= w.findElement(By.id("firstName"));
		fname.clear();
		fname.sendKeys("DDDD");
		
		w.findElement(By.id("lastName")).clear();
		w.findElement(By.id("lastName")).sendKeys("NNNNNN");
		
		System.out.println("Success");
		
		w.quit();
	}

}
