package com.cortexcraft.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class marginalensetest {

	public static void main(String[] args) {
		WebDriver w;
		WebDriverManager.chromedriver().setup();
		
		w= new ChromeDriver();
		
		w.get("http://marginalensetest.testm2msaas.com/startpage.jxp");
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//w.findElement(By.xpath("//*[@id=\"loginDropDownlink\"]/span/font/font")).click();
		//div[contains(., "fox")]
		//w.findElement(By.xpath("//font[contains(.,'Sign in']"));
		//w.findElement(By.cssSelector("font[linkText='Sign in']")).click();
		
		w.findElement(By.id("loginDropDownlink")).click();
		w.findElement(By.id("inputEmaillogin")).click();
		w.findElement(By.id("inputEmaillogin")).sendKeys("DDD");
		
		
		w.quit();
		

	}

}
