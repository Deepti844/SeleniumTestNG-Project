package com.cortexcraft.testcases;

import org.testng.annotations.Test;

import com.cortexcraft.pageobject.Flipkart_Pageobj;
import com.cortexcraft.pageobject.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Flipkart_testcase  {
	Flipkart_Pageobj fk= new Flipkart_Pageobj();
  
  @BeforeTest
  public void preCondition() {
	  fk.openBrowser("chrome");
	  fk.callPageFactoryElement();
  }
  @Test
  public void Test() throws Exception {
	  
	  fk.openApplicationUrl();
	  fk.handleClickEvent(fk.cancelButton);
	  fk.handleClickEvent(fk.inputfield);
	  fk.handleInputEvent(fk.inputfield, "Phones");
	  fk.handleClickEvent(fk.search);
	  Thread.sleep(6000);
	  fk.handleClickEvent(fk.popularity);
	  Thread.sleep(9000);
	  fk.handleClickEvent(fk.appleIPhone);
	  Thread.sleep(6000);
	  fk.windowID();
	  
  }

  @AfterTest
  public void postCondition() {
	  fk.closeBrowser();
  }

}
