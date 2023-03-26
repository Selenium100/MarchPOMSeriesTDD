package com.qa.opencart.pages;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// init
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);
	}

	// By Locators
	private By myAccountLnk = By.linkText("My Account");
	private By logoutBtn = By.linkText("Logout");
	private By searchBar = By.xpath("//input[@name='search']");
	private By accSecHeaders = By.xpath("//div[@id='content']/h2");
	private By searchIcon = By.xpath("//button[@class='btn btn-default btn-lg']");

	// Actions

	public String getAccountsPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.DEFAULT_TIMEOUT, AppConstants.ACC_PAGE_TITLE);
		return title;
	}

	public boolean getAccountPageUrl() {
		String url = eleUtil.waitForUrlContains(AppConstants.DEFAULT_TIMEOUT, AppConstants.ACC_PAGE_URL_ROUTE);
		Predicate<String> s = i -> i.contains(AppConstants.ACC_PAGE_URL_ROUTE);
		if (s.test(url)) {
			return true;
		}
		return false;
	}

	public boolean isSearchFieldExist() {
		Predicate<By> s = i -> eleUtil.doEleIsDisplayed(searchBar);
		if (s.test(searchBar)) {
			return true;
		}
		return false;
		
	}

	public List<String> getAccSecHeaderList() {
		List<WebElement> secList = eleUtil.getElements(accSecHeaders);
		System.out.println("Total section count is: " + secList.size());

		List<String> secHeaderList = secList.stream().map(i -> i.getText()).collect(Collectors.toList());
		return secHeaderList;
	}
	
	public boolean isLogoutExists() {
		boolean isLogoutExists = eleUtil.doEleIsDisplayed(logoutBtn);
		return isLogoutExists;
	}
	
	public SearchResultPage performSearch(String productName) {
		if(isSearchFieldExist()) {
			eleUtil.doSendKeys(searchBar, productName);
			eleUtil.doClick(searchIcon);
			return new SearchResultPage(driver);
			
		}else {
			System.out.println("Search field is not exist");
			return null;
		}
		
	}

}
