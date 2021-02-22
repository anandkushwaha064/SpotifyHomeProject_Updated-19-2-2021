package com.spotify.util;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> threadlocalwebdriver = new ThreadLocal<WebDriver>();

	public static void setDriver(WebDriver driver) {
		threadlocalwebdriver.set(driver);
	}

	public static WebDriver getDriver() {
		return threadlocalwebdriver.get();
	}

}
