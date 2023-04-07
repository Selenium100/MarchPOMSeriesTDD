package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();
	public static String highlight;
	public static OptionsManager option;

	/**
	 * This method initialize the driver on the basis of given browser.
	 * 
	 * @param browser
	 * @return driver
	 */
	public WebDriver initDriver(Properties prop) {
		//String browser = prop.getProperty("browser").toLowerCase(); --->> Uncomment is if you want browsername from configfile
		String browser = System.getProperty("browserName").toLowerCase();  // This line is to parameterize browsername from jenkins parameter
		System.out.println("browser name is " + browser);
		highlight = prop.getProperty("highlight");
		option = new OptionsManager(prop);
		browser = browser.toLowerCase();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver(option.getChromeOptions()));
			break;

		case "ff":
			WebDriverManager.firefoxdriver().setup();
			// driver=new FirefoxDriver();
			tl.set(new FirefoxDriver(option.getFirefoxOptions()));
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			// driver=new EdgeDriver();
			tl.set(new EdgeDriver(option.getEdgeOptions()));
			break;

		default:
			System.out.println("Please provide correct browser name.." + browser);
			//throw new FrameworkException("Please provide correct browser name.." + browser);
			break;
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tl.get();
	}

	/**
	 * This method is used to init the config properties
	 * 
	 * @return properties object
	 */
	public Properties initProp() {
		prop = new Properties();
		FileInputStream fis = null;

		//String envName = System.getenv("env");
		String envName = System.getProperty("env");
		System.out.println("----->>> Running testcases on environment " + envName);

		if (envName == null) {
			System.out.println("-->>No environment is passed.. So running on QA environment --->> ");
			try {
				fis = new FileInputStream("./src/test/resources/config/qa_config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			switch (envName) {
			case "stage":
				try {
					fis = new FileInputStream("./src/test/resources/config/stage_config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "qa":
				try {
					fis = new FileInputStream("./src/test/resources/config/qa_config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "dev":
				try {
					fis = new FileInputStream("./src/test/resources/config/dev_config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "prod":
				try {
					fis = new FileInputStream("./src/test/resources/config/config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Please pass the right Environment name --->  " + envName);
				break;
			}
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
	
	
	/**
	 * Get Screenshot
	 * @return
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
