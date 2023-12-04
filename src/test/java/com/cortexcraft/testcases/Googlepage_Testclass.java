 package com.cortexcraft.testcases;

import org.testng.annotations.Test;


import com.cortexcraft.pageobject.Googlepage_PageObj;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

@org.testng.annotations.Listeners(com.cortexcraft.pageobject.Listeners.class)

public class Googlepage_Testclass {
	Googlepage_PageObj gp =new Googlepage_PageObj();
	

	
  @BeforeTest
  public void preCondition() {
	  gp.openBrowser("Chrome");
	  gp.callPageFactoryElement();
	  
  }
  
  @Test(priority=0, description ="OpenFlipKart")
  public void textType() throws InterruptedException {
	  gp.openApplicationUrl();
	  
	  
  }
  
  @Test(priority=1, description ="Enter the product")
  public void GmailAccountCreation()  {
	 
	  
	  gp.handleClickEvent(gp.cancelbutton);
 gp.handleInputEvent(gp.inputfield, "Phones");
 gp.handleClickEvent(gp.search);
	  
  }
  

  @AfterTest
  public void postCondition() {
	  gp.closeBrowser();
  }

}
