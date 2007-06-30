package com.google.code.calc.seleniumtests;

public class CalcTest extends SeleniumTestCase {
	public void testShouldDoAjaxCallAndDisplayResult() throws Exception {
		selenium.open("http://localhost:9191/calc/load");
		selenium.type("left", "1");
		selenium.type("right", "2");
		selenium.click("calc");
		Thread.sleep(500);
		assertTrue(selenium.isTextPresent("Result : 3"));
	}


	public void testShouldNotDisplay404() throws Exception {
		selenium.open("http://localhost:9191/calc/load");
		selenium.type("left", "");
		selenium.type("right", "");
		selenium.click("calc");
		Thread.sleep(500);
		assertTrue(selenium.isTextPresent("Result : 0"));
	}
}
