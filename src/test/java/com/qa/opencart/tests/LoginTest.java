package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginTest extends BaseTest {

	@Test(priority = 0, description = "Title Test")
	public void openCartLoginTest() {
		String title = login.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 1, description = "Url Test")
	public void openCartLoginPageUrlTest() {
		String url = login.getLoginPageUrl();
		Assert.assertEquals(url, "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	@Test(priority = 2, description = "Forgot password Test")
	public void isForgotPasswordLinkExists() {
		boolean isExist = login.isForgotPasswordExists();
		Assert.assertEquals(isExist, true);
	}
	
	@Test(priority = 3, description = "Login Test")
	public void doLogin() {
		account = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean isLogoutExists = account.isLogoutExists();
		Assert.assertEquals(isLogoutExists, true);
		
	}

}
