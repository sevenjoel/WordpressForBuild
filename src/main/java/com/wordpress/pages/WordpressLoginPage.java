package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WordpressLoginPage {
	
	WebDriver driver;
	By username = By.id("user_login");
	By password = By.id("user_pass");
	By loginButton = By.xpath("//input[@id='wp-submit']");
	By checkbox = By.id("rememberme");

	public WordpressLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		
	}
	
	public void typeUserNameAndPassword(String userid, String pass) {
		
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}

}
