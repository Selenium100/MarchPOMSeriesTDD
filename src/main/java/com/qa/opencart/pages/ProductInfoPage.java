package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHaeder(String productName) {
		String xpath = "//h1[text()='" + productName + "']";
		String productHeader = eleUtil.doGetText(By.xpath(xpath));
		return productHeader;
		
		
	}

}
