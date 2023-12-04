package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class All_Annotations {
 
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("		before Method.......");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("             afterMethod    ");
  }

  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("   beforeClass...... ");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("   afterClass ");
	  
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println(" beforeTest>> ");
  }

  @Test
  public void test1 () {
	  
	  System.out.println("                          TEST 1");
  }
  
  @Test
  public void test2() {
	  System.out.println("                          TEST 2");
  }
  
  @Test
  public void test3() {
	  
	  System.out.println("                          TEST 3");
  }
  @AfterTest
  public void afterTest() {
	  
	  System.out.println("  after Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println(" ..beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  
	  System.out.println(" afterSuite....... ");
  }

}
