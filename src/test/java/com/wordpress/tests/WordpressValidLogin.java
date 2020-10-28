package com.wordpress.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wordpress.pages.WordpressLoginPage;
import com.wordpress.util.BrowserFactory;
import com.wordpress.util.ConfigReader;

public class WordpressValidLogin {
	
	ConfigReader objectRepository = new ConfigReader();
	
  @Test
  public void checkValidLogin() {
	  
	  
	  //This will launch browser and specific url
	  BrowserFactory browserfactory = new BrowserFactory ();
	  WebDriver driver = browserfactory.startBrowser("chrome", objectRepository.getApplicationURL());
	  
	  //Create pageObject - loginpage to user pageFactory
	  
	  WordpressLoginPage loginpage = new WordpressLoginPage(driver);
	  loginpage.typeUserNameAndPassword("admin", "demo123");
	  loginpage.clickOnLoginButton();
	  
	  String currenturl = driver.getCurrentUrl();
	  Assert.assertEquals(objectRepository.getActualURLforVerification(), currenturl);
	  Reporter.log("Success login", true);
  }
}
