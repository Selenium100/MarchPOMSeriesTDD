package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceMetaData = By.xpath("((//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li)[position()=2]");

	public String getProductHaeder(String productName) {
		String xpath = "//h1[text()='" + productName + "']";
		String productHeader = eleUtil.doGetText(By.xpath(xpath));
		System.out.println("Product Header is: " + productHeader);
		return productHeader;

	}

	public int getProductImageCount() {
		return eleUtil.getElementsCount(productImages);
	}

	public String getProductTitleTest(String productTitle) {
		return eleUtil.waitForTitleIs(AppConstants.DEFAULT_TIMEOUT, productTitle);
	}

	public LinkedHashMap<String, String> getProductMeteData() {
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		List<WebElement> metaList = eleUtil.getElements(productMetaData);
		for(WebElement e :metaList) {
			String text = e.getText();
			lhm.put(text.split(":")[0].trim(), text.split(":")[1].trim());
		}
		lhm.forEach((k,v) -> System.out.println(k+":"+v));
		return lhm;
	}
	
	public LinkedHashMap<String, String> getProductPriceMetaData() {
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		List<WebElement> priceMetaList = eleUtil.getElements(productPriceMetaData);
		for(WebElement e :priceMetaList) {
			String priceText = e.getText();
			lhm.put(priceText.split(":")[0].trim(), priceText.split(":")[1].trim());
			
		}
		lhm.forEach((k,v) -> System.out.println(k+":"+v));
		return lhm;
	}

}
