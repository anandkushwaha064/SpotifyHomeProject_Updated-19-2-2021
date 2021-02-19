package com.spotify.testsuits2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spotify.EnvironmentConstant.Props;

import com.spotify.util.ExcelOperation;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;

public class TestSuitExcution {

	private ExcelOperation excelOperation = new ExcelOperation(Props.credentialFile);

	@DataProvider(name = "testData",parallel = true)
	public Object[][] testData() {
		int test_start = 1;
		int test_end = 20;
		Object[][] tests = new Object[test_end - test_start + 1][1];
		for (int i = test_start; i < test_end; i++) {
			tests[i][0] = i;
		}
		return tests;
	}
	// Allure.addAttachment("Expected Object", "");

	@Test(priority = 1, dataProvider = "testData")
	@Description("Checking Login Activity")
	public void test(int testid) {
		HashMap<String, Object> data = excelOperation.read(0, testid);
		TestNgSuit suit = new TestNgSuit((String) data.get("BrowserName"));
		suit.setPropsForGrid();
		suit.runTest(data);
		suit.closeBrowser();
	}
}
