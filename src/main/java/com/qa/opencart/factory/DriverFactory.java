package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
		String browser = prop.getProperty("browser").toLowerCase(); // --->> Uncomment is if you want browsername from
																	// configfile
		// String browser = System.getProperty("browserName").toLowerCase(); // This
		// line is to parameterize browsername from jenkins parameter
		System.out.println("browser name is " + browser);
		highlight = prop.getProperty("highlight");
		option = new OptionsManager(prop);
		browser = browser.toLowerCase();
		switch (browser) {
		case "chrome":
			if (Boolean.parseBoolean(prop.getProperty("remoteexecution"))) {
				// remote execution
				init_remoteDriver("chrome");
			} else {
				// local execution
				WebDriverManager.chromedriver().setup();
				tl.set(new ChromeDriver(option.getChromeOptions()));
			}

			break;

		case "ff":
			if (Boolean.parseBoolean(prop.getProperty("remoteexecution"))) {
				// remote execution
				init_remoteDriver("ff");
			} else {
				// local execution
				WebDriverManager.firefoxdriver().setup();
				// driver=new FirefoxDriver();
				tl.set(new FirefoxDriver(option.getFirefoxOptions()));

			}

			break;

		case "edge":

			if (Boolean.parseBoolean(prop.getProperty("remoteexecution"))) {
				// remote execution
				init_remoteDriver("edge");
			} else {
				// local execution
				WebDriverManager.edgedriver().setup();
				// driver=new EdgeDriver();
				tl.set(new EdgeDriver(option.getEdgeOptions()));
			}

			break;

		default:
			System.out.println("Please provide correct browser name.." + browser);
			// throw new FrameworkException("Please provide correct browser name.." +
			// browser);
			break;
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	private void init_remoteDriver(String browser) {
		
		System.out.println("*********Running scripts on remote GRID machine with browser: " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			try {
				tl.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), option.getChromeOptions()));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (browser.equalsIgnoreCase("edge")) {
			try {
				tl.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), option.getEdgeOptions()));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (browser.equalsIgnoreCase("ff")) {
			try {
				tl.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), option.getFirefoxOptions()));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(
					"==========>>> Please pass the right browser for remote execution.. ===========>>>>>" + browser);
		}

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

		// String envName = System.getenv("env");
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
	 * 
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
