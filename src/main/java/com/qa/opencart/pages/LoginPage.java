package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPassword = By.linkText("Forgotten Password");
	
	
	
	//page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isForgotPasswordExists() {
		return driver.findElement(forgotPassword).isDisplayed();
	}
	
	public AccountsPage doLogin(String uname,String pass) {
		driver.findElement(emailId).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
		return new AccountsPage(driver);
		
	}
	

}
