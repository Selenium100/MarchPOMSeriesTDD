package com.qa.opencart.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropToFrame {
	
	WebDriver driver;
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement ele = driver.findElement(By.className("demo-frame"));
		switchToFrame(driver, ele);
		WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		dragAndDropInFrame(driver, source, target);
		
		
		
	}
	
	public void switchToFrame(WebDriver driver,WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	public void dragAndDropInFrame(WebDriver driver,WebElement source,WebElement target) {
		Actions act = new Actions(driver);
		act.clickAndHold(source).build().perform();
		act.release(target).build().perform();
	}

}
