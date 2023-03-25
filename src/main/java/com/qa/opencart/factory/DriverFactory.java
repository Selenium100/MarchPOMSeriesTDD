package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * This method initialize the driver on the basis of given browser.
	 * @param browser
	 * @return driver
	 */
	public WebDriver initDriver(Properties prop) {
		String browser = prop.getProperty("browser").toLowerCase();
		System.out.println("browser name is " + browser);
		browser = browser.toLowerCase();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			System.out.println("Please provide correct browser name.." + browser);
			break;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	/**
	 * This method is used to init the config properties
	 * @return properties object
	 */
	public Properties initProp() {
		 prop = new Properties();
		 try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
		
	}

}
