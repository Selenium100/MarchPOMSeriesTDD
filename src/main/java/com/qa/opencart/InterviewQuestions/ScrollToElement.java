package com.qa.opencart.InterviewQuestions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollToElement {

	public WebDriver driver;

	@Test
	public void scroll() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");

		int count= 1;
		while (count<=20) {
			System.out.println(count + " sec");
			if(count==20) break;
			String currentWorldPopulation = driver.findElement(By.xpath("//div[@class='maincounter-number']"))
					.getText();

			System.out.println(currentWorldPopulation);
			
			Thread.sleep(1000);
			count++;
			
		}
	}

}
