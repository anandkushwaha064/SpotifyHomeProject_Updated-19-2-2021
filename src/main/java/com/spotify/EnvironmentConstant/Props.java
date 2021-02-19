package com.spotify.EnvironmentConstant;

public class Props {  //Locater
	
	public static final String huburl = "http://3.140.223.144:4444/wd/hub";
// 	http://3.140.223.144:4444/
//	http:///

	
	public static String loginlink = "//li/a[text()=\"Log in\"]";
	
	// *******WebSite Name*******
	public final static String siteurl = "https://www.spotify.com/in/";
	
	// *******
	public static final String projectLocation = System.getProperty("user.dir");
	public static final String resourcepackage = "/src/main/java/com/spotify/resources/";
	
	// *******Excel file*******
	public static final String credentialFile = projectLocation + resourcepackage+"logincredentials.xlsx";
	
	// *******Properties files*******
	public static final String loginlocater = projectLocation + resourcepackage+"LoginLocaters.properties";

	public static final String AlbumsLocaters = projectLocation + resourcepackage+"AlbumsLocaters.properties";
	public static final String headerLocators = projectLocation + resourcepackage+"headerLocators.properties";
	
	
	public static final String SpotifyFooterLocaters = projectLocation + resourcepackage+"SpotifyFooterLocaters.properties";
	// *******Driver Locations*******
	public static final String googleDriver = projectLocation + "/Driver/chromedriver88.exe";
	public static final String firefoxDriver = projectLocation + "/Driver/geckodriver.exe";
	public static final String eageDriver = projectLocation + "/Driver/msedgedriver.exe";
	
	
	
	
}
