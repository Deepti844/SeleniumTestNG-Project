package com.itview.login.selenium_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait_Concepts {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver w;
		
		w= new ChromeDriver();
		
//		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		w.get("https://in.via.com/flight-tickets");
		w.findElement(By.id("wzrk-cancel")).click();
		
		//select "FROM"
		w.findElement(By.id("source")).clear();
		w.findElement(By.id("source")).sendKeys("Mumbai");
		Thread.sleep(2000);
		
		w.findElement(By.id("ui-id-1")).click();
		
		//	select "TO"
		w.findElement(By.id("destination")).clear();
		w.findElement(By.id("destination")).sendKeys("Pune");
		
		Thread.sleep(3000);
		w.findElement(By.id("ui-id-2")).click();
		
		//date
		Thread.sleep(5000);
		w.findElement(By.xpath("//*[@id=\"depart-cal\"]/div[3]/div[2]/div[3]/div[4]")).click();
		
		//search
		w.findElement(By.id("search-flight-btn")).click();
		
		
		//cheapest flight
//		Thread.sleep(6000);
		
		//explicit wait
//		WebDriverWait wt = new WebDriverWait(w,Duration.ofSeconds(20));
//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]")));
		
		//Fluent wait
		Wait<WebDriver> fluentwt = new FluentWait<WebDriver>(w)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				 .ignoring(NoSuchElementException.class); 
		// this defines the exception to ignore
		
		fluentwt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]")));
		
		String price =w.findElement(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]")).getText();
		
		
		System.out.println("Cheapest price : " + price);
		
		w.findElement(By.id("fast_flight")).click();
		
		//Thread.sleep(6000);
		//Explicit wait
//		WebDriverWait wdt =new WebDriverWait(w,Duration.ofSeconds(20));
//		wdt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fast_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));
		
	//Fluent wait
		
		Wait<WebDriver> fluentwdt = new FluentWait<WebDriver>(w)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				 .ignoring(NoSuchElementException.class);
		
		fluentwdt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fast_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));
		
		
		String fastest =w.findElement(By.xpath("//*[@id=\"fast_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")).getText();
		
		System.out.println("Fastest price : " + fastest);
		
		w.quit();
		

	}

}
