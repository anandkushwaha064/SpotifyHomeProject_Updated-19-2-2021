package com.spotify.testsuits2;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.spotify.pages.*;
import com.spotify.util.*;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;

public class TestNgSuit {
	private WebDriver driver = null;
	private SnapShot takesnapshort = null;
	private BrowserUtil browserUtil = new BrowserUtil();
	private String browsername = null;
	private SpotifyAllClick footer;
	private Login login;

	public TestNgSuit(String browsername) {
		this.browsername = browsername;
	}

	@Description("Initlizing remote web driver")
	public void setPropsForGrid() {
		driver = browserUtil.getRemoteDriver(this.browsername);
		
		if (driver == null)
			System.exit(0);
		wait(5000);

		footer = new SpotifyAllClick(driver);
		login = new Login(driver);
	}

	@Description("Starting TestCase")
	public void runTest(HashMap<String,Object> testdata) {
		Allure.addAttachment("RunTest Method", "");
		login.doLogin(testdata);
		footer.handleFooter();
	}

	@Description("Closing Browser")
	public void closeBrowser() {
		wait(5000);
		takesnapshort.saveFile();
		driver.quit();
	}
	
	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
	}
}
