package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage login;
	public AccountsPage account;

	@BeforeMethod
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		login = new LoginPage(driver);
		account = new AccountsPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
