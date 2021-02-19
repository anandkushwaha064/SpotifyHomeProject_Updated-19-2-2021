package com.spotify.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.spotify.EnvironmentConstant.Props;
import com.spotify.util.SnapShot;
import com.spotify.util.UtilClasses;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class SpotifyAllClick extends UtilClasses {
	private WebDriver driver = null;
	private Properties prop = new Properties();
	public List<WebElement> elements;

	public SpotifyAllClick(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Footer exection")
	public void handleFooter() {
		setProps(prop, Props.SpotifyFooterLocaters);
		WebElement web;
		elements = driver.findElements(By.xpath(prop.getProperty("footerspotify")));
		System.out.println("footerspotify : "+elements.size());
		
		Iterator<WebElement> iterator = elements.iterator();
		scrollDown(2000);
		while (iterator.hasNext()) {
			try {
				web = iterator.next();
				controlClick(web);
				wait(3000);
				Allure.addAttachment("Clicking footer", "");
			} catch (Exception e) {
//				System.out.println(e.getLocalizedMessage());
			}
		}

	}
}
