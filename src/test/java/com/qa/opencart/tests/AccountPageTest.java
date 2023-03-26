package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.SearchResultPage;

public class AccountPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accSetup() {
		account = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 0, description = "Account Page Title Test")
	public void accountPageTitleTest() {
		String title = account.getAccountsPageTitle();
		Assert.assertEquals(title, AppConstants.ACC_PAGE_TITLE);
	}
	
	@Test(priority = 1 , description =  "Account Page url Test" )
	public void accountPageUrlTest() {
		boolean isCorrectUrl = account.getAccountPageUrl();
		Assert.assertEquals(isCorrectUrl, true);
	}
	
	@Test(priority = 2, description = "Searchbar exists or not Test")
	public void isSearchBarExistTest() {
		boolean isSearchBar = account.isSearchFieldExist();
		Assert.assertEquals(isSearchBar, true);
	}
	
	@Test(priority = 3, description = "Account Page Headers Test")
	public void accPageHeadersTest() {
		List<String> accHeadersList = account.getAccSecHeaderList();
		accHeadersList.stream().forEach(System.out::println);
		Assert.assertEquals(accHeadersList.stream().sorted((i,j) -> i.compareTo(j)).collect(Collectors.toList()), 
				AppConstants.ACC_PAGE_HEARDERS_LIST.stream().sorted((i,j) -> i.compareTo(j)).collect(Collectors.toList()));
	}
	
	@Test(priority = 4, description = "Search Page Check Test")
	public void searchCheckTest() {
		searchResultPage = account.performSearch("Macbook");
		assertTrue(searchResultPage.isSearchSuccessful());
	}
	
	@Test(priority = 5, description = "Search Macbookpro ")
	public void searchTest() {
		searchResultPage = account.performSearch("Macbook");
		if(searchResultPage.isSearchSuccessful()) {
			productInfo=searchResultPage.selectProduct("MacBook Pro");
		}
	}
	

	
	
	

}
