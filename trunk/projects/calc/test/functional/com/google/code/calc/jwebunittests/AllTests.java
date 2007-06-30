package com.google.code.calc.jwebunittests;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

import com.google.code.calc.helper.Localhost;

public final class AllTests {
    private static final Localhost LOCALHOST = new Localhost();

    private AllTests() {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(
                "Functional test for com.google.code.calc.jwebunittests") {
            public void run(TestResult arg0) {
                try {
                    LOCALHOST.start();
                    super.run(arg0);
                } catch (Exception e) {
                    e.printStackTrace();
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
//            	System.out.println(arg0);
//                return (arg0.indexOf(File.separator + "seleniumtests"
//                        + File.separator) < 0);
//            }
//        });
        
//        Test allTests = null;
//        try {
//            allTests = builder.suite("target/classes/functionaltest/");
//            suite.addTest(allTests);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        suite.addTestSuite(CalcTest.class);
        return suite;
    }
    
    public static void main(String[] args) {
    	AllTests.suite().run(new TestResult());
	}
}
