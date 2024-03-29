package com.spotify.util;

import java.net.URL;

import javax.sql.rowset.spi.TransactionalWriter;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.spotify.EnvironmentConstant.Props;

public class BrowserUtil {

	public WebDriver getDriver(String BrowserName) {
		WebDriver driver = null;

		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Props.googleDriver);
			driver = new ChromeDriver();
		} else if (BrowserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", Props.firefoxDriver);
			driver = new FirefoxDriver();
		} else if (BrowserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", Props.eageDriver);
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Options :\"" + BrowserName + "\" Dose not exist");
		}

		driver.manage().window().maximize();
		driver.navigate().to(Props.siteurl);
		return driver;
	}

	public WebDriver getRemoteDriver(String BrowserName) {

		WebDriver driver = null;
		try {
			if (BrowserName.equals("chrome")) {
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				driver = new RemoteWebDriver(new URL(Props.huburl), cap);
			} else if (BrowserName.equals("firefox")) {
				DesiredCapabilities cap = DesiredCapabilities.firefox();

				driver = new RemoteWebDriver(new URL(Props.huburl), cap);
			} else if (BrowserName.equals("edge")) {
				DesiredCapabilities cap = DesiredCapabilities.edge();

				driver = new RemoteWebDriver(new URL(Props.huburl), cap);
			} else {
				System.out.println("Options :\"" + BrowserName + "\" Dose not exist");
			}
		} catch (Exception e) {
			throw new RuntimeException("Error occured while creating the New web driver instance",e);
		}
		DriverManager.setDriver(driver);
		driver.manage().window().maximize();
		driver.navigate().to(Props.siteurl);
		return driver;
	}

	public WebDriver getHtmlUnitBrowser(String BrowserName) {
		WebDriver driver = null;
		if (BrowserName.equals("chrome")) {
			driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		} else if (BrowserName.equals("firefox")) {
			driver = new HtmlUnitDriver();
		} else {
			driver = new HtmlUnitDriver(BrowserVersion.getDefault());
		}
		driver.manage().window().maximize();
		driver.navigate().to(Props.siteurl);
		return driver;
	}
}