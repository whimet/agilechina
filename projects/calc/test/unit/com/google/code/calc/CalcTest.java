package com.google.code.calc;

import junit.framework.TestCase;

public class CalcTest extends TestCase {
    private Calc calc;

    protected void setUp() throws Exception {
        calc = new Calc();
    }

    public void testShouldAddTwoDigit() {
        assertEquals(new Integer(3), calc.add(1, 2));
    }

    public void testShouldSubtractTwoDigit() {
        assertEquals(new Integer(1), calc.subtract(3, 2));
    }

    public void testShouldMultiplyTwoDigit() {
        assertEquals(new Integer(6), calc.multiply(2, 3));
    }

    public void testShouldDivideTwoDigit() {
        assertEquals(new Integer(18), calc.divide(36, 2));
    }

    public void testShouldReturnZeroWhenDivideTwoDigit() {
        assertEquals(new Integer(0), calc.divide(2, 3));
    }
}
