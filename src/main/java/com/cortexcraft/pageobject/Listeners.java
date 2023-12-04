package com.cortexcraft.pageobject;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener  {
	
	
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Testcase is Passed :" +result.getMethod().getDescription());
		
		try {
			TestBase.takeScreenshot(".\\Screenshots\\Pass\\"+result.getMethod().getDescription()+".png");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
public void onTestFailure(ITestResult result) {
		
		System.out.println("Testcase is Failed :" +result.getMethod().getDescription());
		
		try {
			TestBase.takeScreenshot(".\\Screenshots\\Failed\\"+result.getMethod().getDescription()+".png");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

public void onTestSkipped(ITestResult result) {
	
	System.out.println("Testcase is Skipped :" +result.getMethod().getDescription());
	
	try {
		TestBase.takeScreenshot(".\\Screenshots\\Skipped\\"+result.getMethod().getDescription()+".png");
	}catch (Exception e) {
		e.printStackTrace();
	}
}
	
	

}
 