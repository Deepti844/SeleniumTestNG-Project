package com.cortexcraft.testcases;

import org.testng.annotations.Test;

import com.cortexcraft.pageobject.Pageobject_1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Testcase_2 {
	Pageobject_1 po = new Pageobject_1();
  
  @BeforeTest
  public void perCondition() {
	  
	  po.openBrowser("chrome");
	  po.callPageFactoryElement();
	  
	  po.openApplicationUrl();
	  po.handleClickEvent(po.Sig_in);
	  
	  
	  
  }
  
  @Test
  public void f() {
	  
	  po.handleInputEvent(po.Email, "DDD");
  }

  @AfterTest
  public void postCondition() {
	  //po.closeBrowser();
  }

}
