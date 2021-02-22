package com.spotify.builttestNg;

public class BuiltTestNg {
	
	private static String testName = null;
	private static String testid = null;
	
	
	public static void main(String args[]) {
		String st = "<test name=\""+testName+"\" >" + 
				"	     <classes>" + 
							 
				"	         <class name=\"com.spotify.testsuits2.TestSuitExcution\"/>" + 
				"	     </classes>" + 
				"	</test>";
		
		
	}
}
