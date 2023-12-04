package com.itview.pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	String url ="https://www.moneycontrol.com/personal-finance/tools/credit-card-debt-payoff-calculator.html";
	WebDriver w;  
	
	public void openApplicationUrl() {
		
		w.get(url);
	}
		
		public void openBrowser(String browsername){
			
			if(browsername.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				w =new ChromeDriver();
				
			} else if(browsername.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				w = new FirefoxDriver();
				
			} else if(browsername.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				w =new EdgeDriver();
				
			}
			
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		}
		
		public void closeBrowser() {
			w.quit();
		
		}
		

		public void handleTextbox(WebElement we, String value) {
			we.clear();
			we.sendKeys(value);
		}
		
		
		public void handleClickEvent(WebElement we) {
			we.click();
		}
		
		public void handleDropDownList(WebElement we,String value){
			Select sel = new Select(we);
			sel.selectByVisibleText(value);
			
		}
		
		public void waitForSec(int sec) throws Exception {
			Thread.sleep(1000* sec);
		}
		
		public void handleAlert() {
			try {
			w.switchTo().alert().accept();
			}
			catch(Exception e) {
				
			}
		}
			
		public void handleFrame(String frameName){
				w.switchTo().frame(frameName);
			}
		
		public String getValidationValue(WebElement w) {
			return w.getText();
		
		}
		
		public String getPageTitle() {
			return w.getTitle();
		}
		
		public void pageScrollDown() {
			
			JavascriptExecutor js = (JavascriptExecutor) w;
			js.executeScript("window.scrollBy(0,400)");
		}
		
		public String ReadDataFromPropertiesFile(String passKey) throws Exception {
		
		FileInputStream fi = new FileInputStream(".\\Config\\config.properties");
		Properties p =new Properties();
		p.load(fi);
		
		String returnValue= p.getProperty(passKey);		
		fi.close();
		
		return returnValue;
		
		
		}
		
}
	


