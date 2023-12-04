package com.seleniumpractice.webobject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_Links {

	public static void main(String[] args) throws Exception {
WebDriver w;
		
		WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  w= new ChromeDriver(options);
		  w.manage().window().maximize();
		w.get("https://makemysushi.com/404?");
		//w.manage().window().maximize();
		
		//capture links in the webpage
		 List<WebElement> links =w.findElements(By.tagName("a"));
		 
		 //no.of links
		 System.out.println(links.size());
		 
		 for (int i=0;i<links.size();i++) {
			 //by using 'href' attribute we can get URL in the referred link
			 
			 WebElement element = links.get(i);
			 String url= element.getAttribute("href");
			 
			 	URL link =new URL(url);
			 	URLConnection urlconnection= link.openConnection();
			 	
			 	//create a connection using url object"link"
			 	HttpURLConnection httpconn=(HttpURLConnection) urlconnection;
			 	
			 	//wait 
			 	Thread.sleep(2000);
			 	
			 	//establish connection
			 	
			 	httpconn.connect();
			 	
			 	int resCode=httpconn.getResponseCode();
			 	//return response code if resCode>=400 then broken link
			 	
			 	
			 	if (resCode>=400) {
			 		System.err.println(url +"-"+" is broken link");
			 	}
			 	else
			 	{
			 		System.out.println(url +"-"+" is valid link");
			 	}
			 	
			
		}
		
		
		 System.out.println("Success");
		 w.quit();
		
	}

}
