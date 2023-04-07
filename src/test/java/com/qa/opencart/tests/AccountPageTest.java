package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accSetup() {
		account = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 0, description = "Account Page Title Test")
	public void accountPageTitleTest() {
		String title = account.getAccountsPageTitle();
		System.out.println("Account page Title is " + title);
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
	
	@DataProvider(name = "getSearchData")
	public Object[][] getDataSearchCheck(){
		return new Object[][] {
			{"Macbook"},
			{"Samsung"},
			{"iMac"}
					
		};
	}
	
	@Test(priority = 4, description = "Search Page Check Test", dataProvider = "getSearchData")
	public void searchCheckTest(String searchProduct) {
		searchResultPage = account.performSearch(searchProduct);
		assertTrue(searchResultPage.isSearchSuccessful());
	}
	
	@DataProvider(name = "getData")
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		data[0][0] =  "Macbook";
		data[0][1] =  "MacBook Pro";
		
		data[1][0] =  "Samsung";
		data[1][1] =  "Samsung Galaxy Tab 10.1";
		
		data[2][0] =  "iMac";
		data[2][1] =  "iMac";
		
		
		return data;
		
		
		
	}
	
	@Test(priority = 5, description = "Search Macbookpro " , dataProvider = "getData")
	public void searchTest(String productSearch, String productName) {
		searchResultPage = account.performSearch(productSearch);
		if(searchResultPage.isSearchSuccessful()) {
			productInfo=searchResultPage.selectProduct(productName);
			String actualHeader = productInfo.getProductHaeder(productName);
			Assert.assertEquals(actualHeader, productName);
		}
	}
	

	
	
	

}
