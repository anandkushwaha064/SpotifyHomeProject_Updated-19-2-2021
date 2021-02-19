package com.spotify.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spotify.EnvironmentConstant.Props;
import com.spotify.util.SnapShot;
import com.spotify.util.UtilClasses;

public class SpotifyHeader {
	private Properties prop = new Properties();
	private WebDriver driver = null;

	public SpotifyHeader(WebDriver driver) {
		this.driver = driver;
	}

	public void headerOperation() {
		UtilClasses ut = new UtilClasses(driver);
		ut.wait(5000);
		driver.navigate().to(Props.siteurl);
		ut.setProps(prop, Props.headerLocators);
		ut.wait(5000);
		List<WebElement> listOfHeaderElements = ut.getWebElements(prop.getProperty("header"));
		System.out.println(listOfHeaderElements.size());
		Iterator<WebElement> iterator = listOfHeaderElements.iterator();
		while (iterator.hasNext()) {
			WebElement webElement = iterator.next();
			ut.wait(2000);

			ut.wait(200);
			ut.hover(webElement);
		}
		ut.wait(2000);
		ut.click(prop.getProperty("profile"));
		ut.wait(2000);
		ut.click(prop.getProperty("profile"));
		ut.wait(2000);
		ut.click(prop.getProperty("getPremium"));
		ut.wait(2000);
		driver.navigate().to(Props.siteurl);
		ut.wait(2000);
		ut.click(prop.getProperty("tnc"));
		ut.wait(4000);

	}

}
