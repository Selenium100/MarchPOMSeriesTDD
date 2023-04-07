package com.qa.opencart.tests;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class ProductPageTest extends BaseTest {

	@BeforeClass
	public void productInfoSetup() {
		account = login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider(name = "getDataHeader")
	public Object[][] getDataHeader() {

		Object[][] data = new Object[3][2];
		data[0][0] = "Macbook";
		data[0][1] = "MacBook Pro";

		data[1][0] = "Samsung";
		data[1][1] = "Samsung Galaxy Tab 10.1";

		data[2][0] = "iMac";
		data[2][1] = "iMac";

		return data;

	}

	@Test(priority = 0, description = "Product Header Test", dataProvider = "getDataHeader")
	public void productHeaderTest(String productName, String productSearch) {
		searchResultPage = account.performSearch(productName);
		productInfo = searchResultPage.selectProduct(productSearch);
		productInfo.getProductHaeder(productSearch);
	}

	@DataProvider(name = "getData")
	public Object[][] getData() {

		return new Object[][] { { "Macbook", "MacBook Pro", AppConstants.MACBOOK_PRO_IMAGES_COUNT },
				{ "Samsung", "Samsung Galaxy Tab 10.1", AppConstants.SAMSUNG_IMAGES_COUNT },
				{ "iMac", "iMac", AppConstants.IMAC_IMAGES_COUNT } };

	}

	@Test(priority = 1, description = "Product Image Count Test", dataProvider = "getData")
	public void getProductImageCountTest(String productName, String productSearch, int imageCount) {
		searchResultPage = account.performSearch(productName);
		productInfo = searchResultPage.selectProduct(productSearch);
		int actualImageCount = productInfo.getProductImageCount();
		System.out.println("Actual Image count is : " +  actualImageCount);
		Assert.assertEquals(actualImageCount, imageCount, "Actual image and expected image count not matched");
	}

	@Test(priority = 2, description = "Product MetaData Test")
	public void productMetaDataTest() {
		searchResultPage = account.performSearch("Macbook");
		productInfo = searchResultPage.selectProduct("MacBook Pro");
		LinkedHashMap<String, String> actMetaDataMap = productInfo.getProductMeteData();
		Assert.assertEquals(actMetaDataMap.get("Brand"), "Apple");
		Assert.assertEquals(actMetaDataMap.get("Product Code"), "Product 18");
		Assert.assertEquals(actMetaDataMap.get("Reward Points"), "800");
		Assert.assertEquals(actMetaDataMap.get("Availability"), "In Stock");

	}
	
	@Test(priority = 3, description = "Product Price MetaData Test")
	public void productPriceMetaDataTest() {
		searchResultPage = account.performSearch("Macbook");
		productInfo = searchResultPage.selectProduct("MacBook Pro");
		LinkedHashMap<String, String> actPriceMetaDataMap = productInfo.getProductPriceMetaData();
		Assert.assertEquals(actPriceMetaDataMap.get("Ex Tax"), "$2,000.00");
	}
}
