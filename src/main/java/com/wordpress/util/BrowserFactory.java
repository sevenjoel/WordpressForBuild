package com.wordpress.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory { 
	
	
	ConfigReader objectRepository = new ConfigReader();
	
	public WebDriver driver;
	
	public WebDriver startBrowser(String browserName, String url) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\seven\\Selenium Workspace\\com.wordpress\\src\\test\\resources\\Binaries\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.msedge.driver",
					"C:\\Users\\seven\\Selenium Workspace\\com.wordpress\\src\\test\\resources\\Binaries\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
		}
	}


