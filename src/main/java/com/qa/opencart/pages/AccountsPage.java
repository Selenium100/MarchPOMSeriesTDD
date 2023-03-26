package com.qa.opencart.pages;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;

public class AccountsPage {

	private WebDriver driver;

	// init
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	// By Locators
	private By myAccountLnk = By.linkText("My Account");
	private By logoutBtn = By.linkText("Logout");
	private By searchBar = By.xpath("//input[@name='search']");
	private By accSecHeaders = By.xpath("//div[@id='content']/h2");

	// Actions

	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public boolean getAccountPageUrl() {
		String url = driver.getCurrentUrl();
		Predicate<String> s = i -> i.contains(AppConstants.ACC_PAGE_URL_ROUTE);
		if (s.test(url)) {
			return true;
		}
		return false;
	}

	public boolean isSearchFieldExist() {
		Predicate<By> s = i -> driver.findElement(searchBar).isDisplayed();
		if (s.test(searchBar)) {
			return true;
		}
		return false;
	}

	public List<String> getAccSecHeaderList() {
		List<WebElement> secList = driver.findElements(accSecHeaders);
		System.out.println("Total section count is: " + secList.size());

		List<String> secHeaderList = secList.stream().map(i -> i.getText()).collect(Collectors.toList());
		return secHeaderList;
	}
	
	public boolean isLogoutExists() {
		boolean isLogoutExists = driver.findElement(logoutBtn).isDisplayed();
		return isLogoutExists;
	}

}
