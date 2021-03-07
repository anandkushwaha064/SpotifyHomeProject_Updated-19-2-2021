package com.spotify.testNgRunner;
import com.spotify.testsuits2.TestSuitExecution;
import org.testng.TestNG;

public class TestNGMainClass {
//com.spotify.testNgRunner.TestNGMainClass::RunTest
        public void RunTest() {
//        public static void main(String args[]) {

        System.out.println("Start Test");
        TestNG testSuite = new TestNG();
        testSuite.setTestClasses(new Class[] { TestSuitExecution.class });
//        testSuite.addListener(new Test5SuiteListener());
        testSuite.setDefaultSuiteName("Spotify Login Test Suite");
        testSuite.setDefaultTestName("Check Login");
//        testSuite.setOutputDirectory("/Users/pankaj/temp/testng-output");
        testSuite.run();
        System.out.println("End Test");
    }

}