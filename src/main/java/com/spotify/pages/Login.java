package com.spotify.pages;

import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.spotify.EnvironmentConstant.Props;
import com.spotify.util.SnapShot;
import com.spotify.util.UtilClasses;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import junit.framework.Assert;

public class Login {
	private WebDriver driver;
	Properties props = new Properties();
	SnapShot takesnapshort = null;
	String st = "Anand";

	public Login(WebDriver driver, SnapShot takesnapshort) {
		this.takesnapshort = takesnapshort;
		this.driver = driver;
	}

	@Step("Login Excetion")
	public void doLogin(HashMap<String, Object> testdata) {
		UtilClasses ut = new UtilClasses(driver);
		try {
			ut.setProps(props, Props.loginlocater);
			ut.wait(500);
			ut.click(props.getProperty("loginlink"));
			Allure.addAttachment("Login Link Clicked", "");
			ut.takeScreenShot("First Page Before Login");
			ut.iwait(3000);
			ut.sendValue(props.getProperty("usertextbox"), (String) testdata.get("userid"));
			Allure.addAttachment("Userid filled", (String) testdata.get("userid"));
			ut.sendValue(props.getProperty("password"), (String) testdata.get("password"));
			Allure.addAttachment("Password filled", (String) testdata.get("password"));
			ut.takeScreenShot("Before UserID and Password Inserted");
			ut.wait(1000);
			ut.click(props.getProperty("loginbutton"));
			Allure.addAttachment("Login Button Clicked", "");
			ut.wait(4000);
			ut.takeScreenShot("After Clicking on Login Button");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
		boolean islogedin = "Account overview - Spotify".equals(driver.getTitle());
		// System.out.println(String.valueOf(islogedin).equalsIgnoreCase((String)testdata.get("expectedresult")));

		Allure.addAttachment("Actaual : ", String.valueOf(islogedin));
		Allure.addAttachment("Expected : ", (String) testdata.get("expectedresult"));
		ut.takeScreenShot("After Clicking on Login Button");
		Assert.assertTrue(String.valueOf(islogedin).equalsIgnoreCase((String) testdata.get("expectedresult")));
	}
}
