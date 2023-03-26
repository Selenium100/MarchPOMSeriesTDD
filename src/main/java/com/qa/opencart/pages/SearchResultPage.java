package com.qa.opencart.pages;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	By productSearchLayout = By.cssSelector("div.product-layout");
	
	public boolean isSearchSuccessful() {
		List<WebElement> searchList = eleUtil.waitForElementsToBeVisible(productSearchLayout, AppConstants.DEFAULT_LONG_TIMEOUT);
		
		Predicate<List<WebElement>> p = i -> i.size()>0;
		if(p.test(searchList)) {
			System.out.println("Search Successfully done..");
			return true;
		}
		return false;
	}
	
	public ProductInfoPage selectProduct(String productName) {
		By mainPrName = By.linkText(productName);
		eleUtil.doClick(mainPrName);
		return new ProductInfoPage(driver);
	}

}
