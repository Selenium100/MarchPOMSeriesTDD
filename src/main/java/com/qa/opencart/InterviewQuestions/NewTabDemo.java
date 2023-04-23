package com.qa.opencart.InterviewQuestions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTabDemo {

	public WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		Thread.sleep(4000);

	}

	@Test
	public void newTabTest() {
		String currentWindowId = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://amazon.in");
		System.out.println(driver.getTitle());

		driver.switchTo().window(currentWindowId);

		System.out.println(driver.getTitle());
	}

}
