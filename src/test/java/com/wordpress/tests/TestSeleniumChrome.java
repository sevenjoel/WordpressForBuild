package com.wordpress.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wordpress.util.ConfigReader;

public class TestSeleniumChrome {
	ConfigReader config = new ConfigReader();
	
  @BeforeTest
  public void setup() {
	  System.setProperty("webdriver.chrome.driver",config.getchromepath());
	  
	  System.out.println("Setup is Ready");
  }
  
  @Test
  public void testchrome( ) {
	  System.out.println("Navigate to URL");
	  WebDriver driver = new ChromeDriver();
	  driver.get(config.getApplicationURL());
  
  
				
  }
}
