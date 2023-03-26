package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPassword = By.linkText("Forgotten Password");
	
	
	
	//page actions
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.DEFAULT_TIMEOUT, AppConstants.LOGIN_PAGE_TITLE);
		return title;
	}
	
	public String getLoginPageUrl() {
		String url =eleUtil.waitForUrlContains(AppConstants.DEFAULT_TIMEOUT, AppConstants.LOGIN_PAGE_URL_ROUTE);
		return url;
	}
	
	public boolean isForgotPasswordExists() {
		return eleUtil.doEleIsDisplayed(forgotPassword);
	}
	
	public AccountsPage doLogin(String uname,String pass) {
		eleUtil.doSendKeysWithWait(emailId, AppConstants.DEFAULT_TIMEOUT, uname);
		eleUtil.doSendKeys(password, pass);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
		
	}
	

}
