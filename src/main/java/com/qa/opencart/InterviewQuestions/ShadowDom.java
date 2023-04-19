package com.qa.opencart.InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		driver.manage().window().maximize();
		
		

		// document.querySelector("#userName").shadowRoot.querySelector("#kils");
		
		//document.querySelector("#userName").shadowRoot.querySelector("#app2").shadowRoot.querySelector("#pizza")
		Thread.sleep(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = (WebElement) (js
				.executeScript("return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#kils\")"));
		ele.sendKeys("Nitya");
		
		WebElement ele2 = (WebElement) (js
				.executeScript("return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")"));

		
		ele2.sendKeys("good boy");
	}

}
