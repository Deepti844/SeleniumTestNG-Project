package com.cortexcraft.pageobject;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	String url ="https://www.flipkart.com/";
	 WebDriver w;
	 
	
	public void openApplicationUrl() {
		w.get(url);
	}
	
	public void openBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			w =new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w= new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
		}
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void handleInputEvent(WebElement we, String value) {
		we.clear();
		we.sendKeys(value);
		
	}
	
	public void handleClickEvent(WebElement we) {
		we.click();
	}
	public void windowID() throws Exception {
		
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Set winId =w.getWindowHandles();//getting the windows id
		Object windowId[]=winId.toArray();//converting Jagged array to normal array
		
		//switching to window 1
		
		w.switchTo().window(windowId[0].toString());
		System.out.println("Window 1 title: "+w.getTitle());
		Thread.sleep(2000);
		//switching to window 2
		
		w.switchTo().window(windowId[1].toString());
		System.out.println("Window 2 title: "+w.getTitle());
		Thread.sleep(2000);
		//switching to window 1
		
		w.switchTo().window(windowId[0].toString());
		Thread.sleep(2000);
	}
	
//	public static void takeScreenshot(String screenshotsPath) throws Exception{
//		
//		TakesScreenshot ts =(TakesScreenshot)w;
//		File f = ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(f, new File(screenshotsPath));
		
		
//	}
	public void enterKeyboardEvent() {
		Actions a = new Actions(w);
		a.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void closeBrowser() {
		w.quit();
	
	}
	
	
	
	

}
