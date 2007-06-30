package com.google.code.calc.utils;

import junit.framework.TestCase;

public class CalcUtilsTest extends TestCase {
    public void testShouldBeAbleToDecodeURL() {
        assertEquals("project name with space", CalcUtils
                .decode("project%20name%20with%20space"));
    }

    public void testShouldSplitURLToArray() {
        String[] params = CalcUtils
                .urlToParams("/detail/project%20name%20with%20space/whatever");
        assertEquals(3, params.length);
        assertEquals("detail", params[0]);
        assertEquals("project name with space", params[1]);
        assertEquals("whatever", params[2]);
    }

    public void testShouldReturnEmptyIfParamIsEmpty() {
        String[] params = CalcUtils.urlToParams("");
        assertEquals(0, params.length);
    }

}
