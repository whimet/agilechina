package com.google.code.calc.seleniumtests;

public class CalcTest extends SeleniumTestCase {
	public void testShouldDoAjaxCallAndDisplayResult() throws Exception {
		selenium.open("http://localhost:9191/calc/load");
		Thread.sleep(5000);
		selenium.type("left", "1");
		Thread.sleep(5000);
		selenium.type("right", "2");
		Thread.sleep(5000);
		selenium.click("calc");
		Thread.sleep(5000);
		assertEquals("3", selenium.getValue("result"));
		
	}
}
