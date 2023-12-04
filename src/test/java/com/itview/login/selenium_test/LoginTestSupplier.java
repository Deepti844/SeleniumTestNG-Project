package com.itview.login.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestSupplier {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver w = new ChromeDriver();
		
		w.get("http://hospitalnew.bdtask.com/demo6/login");
		Thread.sleep(3000);
		
		w.findElement(By.id("email")).sendKeys("admin@demo.com");
		w.findElement(By.name("password")).sendKeys("12345");
		
//		w.findElement(By.xpath("//*[@id=\"layoutAuthentication_content\"]/main/div/div/div/div[1]/div/form/div[4]/button/span[1]")).click();
		//w.findElement(By.className("material-icons").click();
		//w.findElement(By.cssSelector("i.material-icons")).click();
				//("i.material-icons")).click();
		//w.findElement(By.xpath("/html/body/nav/div/div/div/div[3]/ul/li[4]/a/div")).click();
		System.out.println("---Success---");
		 
		
		//w.quit();

	}

}
