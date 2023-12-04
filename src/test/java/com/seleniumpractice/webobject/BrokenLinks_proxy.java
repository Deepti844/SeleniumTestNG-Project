package com.seleniumpractice.webobject;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks_proxy {

	
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver w = new ChromeDriver();
			w.get("https://makemysushi.com/404?" );
			w.manage().window().maximize();
			
			//capture links in the webpage
			 List<WebElement> links =w.findElements(By.tagName("a"));
			 
			 //no.of links
			 System.out.println(links.size());
			 
			 for (int i=0;i<links.size();i++) {
				 //by using 'href' attribute we can get URL in the referred link
				 
				 WebElement element = links.get(i);
				 String url= element.getAttribute("href");
				 
				 Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress("hostname",80));
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
			
			
			 
			 w.quit();

	}

}
