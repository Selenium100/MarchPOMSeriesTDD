package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic 65131: Open cart epic for login test design")
@Story("US 45634")
public class LoginTest extends BaseTest {

	@Description("Login page title test...")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 0, description = "Title Test")
	public void openCartLoginTest() {
		String title = login.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Description("Login page url test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1, description = "Url Test")
	public void openCartLoginPageUrlTest() {
		String url = login.getLoginPageUrl();
		Assert.assertEquals(url, "https://naveenautomationlabs.com/opencart/index.php?route=account/login1");
	}
	
	@Description("Login page forget password link test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2, description = "Forgot password Test")
	public void isForgotPasswordLinkExists() {
		boolean isExist = login.isForgotPasswordExists();
		Assert.assertEquals(isExist, true);
	}
	
	@Description("Login woring properly or not test...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3, description = "Login Test")
	public void doLogin() {
		account = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean isLogoutExists = account.isLogoutExists();
		Assert.assertEquals(isLogoutExists, true);
		
	}

}
