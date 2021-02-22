package com.spotify.testsuits2;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.spotify.EnvironmentConstant.Props;
import com.spotify.util.DriverManager;
import com.spotify.util.ExcelOperation;
import io.qameta.allure.Description;

public class TestSuitExcution {

	private ExcelOperation excelOperation = new ExcelOperation(Props.credentialFile);

	@DataProvider(name = "testData") //, parallel = true)
	public Object[][] testData() {
		int test_start = 5;
		int test_end = 19;
		int totaltests = test_end - test_start + 1;
		Object[][] tests = new Object[totaltests][1];
		for (int i = 0; i < totaltests; i++) {
			tests[i][0] = test_start++;
		}
		return tests;
	}
	
	@Test(priority = 1, dataProvider = "testData")
	@Description("Checking Login Activity")
	public void test(int testid) {
		HashMap<String, Object> data = excelOperation.read(0, testid);
		TestNgSuit suit = new TestNgSuit((String) data.get("BrowserName"));
		suit.setPropsForGrid();
		suit.runTest(data);
//		suit.closeBrowser();
	}

	@AfterMethod
	public void afterTest() {
		if (DriverManager.getDriver() != null)
			DriverManager.getDriver().quit();
	}
}
