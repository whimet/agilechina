package com.google.code.calc.seleniumtests;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

import com.google.code.calc.helper.Localhost;

public final class AllSeleniumTests {

    private static final Localhost LOCALHOST = new Localhost();

    private AllSeleniumTests() {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(
                "Functional test for  com.google.code.calc") {
            public void run(TestResult arg0) {
                try {
                    LOCALHOST.start();
                    super.run(arg0);
                } catch (Exception e) {
                } finally {
                    try {
                        LOCALHOST.stop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
//        DirectorySuiteBuilder builder = new DirectorySuiteBuilder();
//        builder.setFilter(new SimpleTestFilter() {
//            public boolean include(String arg0) {
//                return (arg0.indexOf(File.separator + "seleniumtests"
//                        + File.separator) > 0)
//                        && arg0.endsWith("Test.class");
//            }
//        });
        suite.addTestSuite(CalcTest.class);
//        Test allTests = null;
//        try {
//            allTests = builder.suite("target/classes/functionaltest");
//            suite.addTest(allTests);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return suite;
    }

    public static void main(String[] args) {
    	AllSeleniumTests.suite().run(new TestResult());
	}
}
