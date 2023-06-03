package com.qa.opencart.InterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleAlert {

	WebDriver driver;

	@Test
	public void handleAlert() {

		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		
		driver.findElement(By.xpath("//input[@value='Click Me']")).click();
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
	}

}
