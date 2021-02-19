package com.spotify.util;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Maqdoom Sharief
 * @version 1.0
 * @since 22020-09-12
 * @description This class is Util class which will provides common methods for
 *              validations/manipulations/conversion
 */
public class CommonUtil {

	/**
	 * Return the status whether the given string is valid
	 * 
	 * @param inputString
	 * @return true or false
	 */
	public static boolean isValidString(String inputString) {
		return (inputString != null && !inputString.trim().isEmpty());
	}

	/**
	 * Return the status whether the given string is valid number
	 * 
	 * @param inputNumberInString
	 * @return true or false
	 */
	public static boolean isValidInteger(String inputNumberInString) {
		return StringUtils.isNumeric(inputNumberInString);
	}

	/**
	 * Return convert string to number
	 * 
	 * @param inputNumberInString
	 * @return integer value
	 */
	public int getInteger(String inputNumberInString) {
		Integer value = null;
		try {
			value = Integer.valueOf(inputNumberInString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	/**
	 * Return the status whether the given @regexPatternStr matches
	 * with @textContent
	 * 
	 * @param regexPatternStr
	 * @param textContent
	 * @return true or false
	 */
	public static boolean isRegexParrenMatched(String regexPatternStr, String textContent) {
		Pattern pattern = Pattern.compile(regexPatternStr);
		Matcher matcher = pattern.matcher(textContent);
		return matcher.find();
	}

	/**
	 * Return the extracted Sub-String using 1st regex Group. the
	 * regex @regexPatternStr should have grouping pattern like "'(.*?)'". It will
	 * first check whether pattern is found. then it will return 1st group
	 * 
	 * @param regexPatternStr
	 * @param textContent
	 * @return true or false
	 */
	public static String extractSubStringUsingRegex(String regexPatternStr, String textContent) {
		String extractedValue = null;
		Pattern pattern = Pattern.compile(regexPatternStr);
		Matcher matcher = pattern.matcher(textContent);
		if (matcher.find()) {
			if (matcher.groupCount() > 0)
				extractedValue = matcher.group(1);
			else
				Assert.fail("No matching group found for the extraction");
		} else
			Assert.fail("Pattern '" + regexPatternStr + "' cannot be found in the content: " + textContent);
		return extractedValue;
	}

}
