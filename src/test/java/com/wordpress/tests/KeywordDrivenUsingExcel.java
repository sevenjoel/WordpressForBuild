package com.wordpress.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wordpress.util.ConfigReader;
import com.wordpress.util.ExcelDataConfig;

public class KeywordDrivenUsingExcel {
	
	
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	
	  @Test(dataProvider="wordpress")
	  public void loginToWordpress(String username, String password) {
		  
		  System.setProperty("webdriver.chrome.driver",
					config.getchromepath());
			driver = new ChromeDriver();
			driver.get(config.getApplicationURL());
			driver.findElement(By.id("user_login")).sendKeys(username);
			driver.findElement(By.id("user_pass")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
			
			Assert.assertEquals(config.getActualURLforVerification(), driver.getCurrentUrl());
			System.out.println(driver.getCurrentUrl());
			System.out.println("User is able to login successfully");
			}
	  
	  @AfterMethod
	  public void tearDown() {
	  driver.quit();
	  }
	  
	  @DataProvider(name="wordpress")
	  public Object[][] passData(){
		  
		  ExcelDataConfig configExcel = new ExcelDataConfig(config.Exceldata());
		  int noOfRows = configExcel.getRowCount(0);
		  Object[] [] data = new Object [noOfRows] [2];
		  
		  for(int i=0;i<noOfRows;i++) {
			  data[i][0] = configExcel.getData(0, i, 0);
			  data[i][1] = configExcel.getData(0, i, 1);
		  }
		  
	  

	  return data;

	  
	  
  }
}
