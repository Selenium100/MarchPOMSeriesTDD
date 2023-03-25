package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void accSetup() {
		account = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 0, description = "Account Page Title Test")
	public void accountPageTitleTest() {
		String title = account.getAccountsPageTitle();
		Assert.assertEquals(title, "My Account");
	}
	
	@Test(priority = 1  )
	public void accountPageUrlTest() {
		boolean isCorrectUrl = account.getAccountPageUrl();
		Assert.assertEquals(isCorrectUrl, true);
	}
	

}
