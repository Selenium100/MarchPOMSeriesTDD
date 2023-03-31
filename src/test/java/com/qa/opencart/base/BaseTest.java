package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {

	DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage login;
	public AccountsPage account;
	public SearchResultPage searchResultPage;
	public ProductInfoPage productInfo;
	public RegistrationPage register;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		login = new LoginPage(driver);
		account = new AccountsPage(driver);
		register = new RegistrationPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
