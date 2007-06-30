package com.google.code.calc.web;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmock.Mock;
import org.jmock.cglib.MockObjectTestCase;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.calc.Calc;

public class CalcControllerTest extends MockObjectTestCase {
    private Mock calcMock;
    private Calc calc;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private CalcController controller;

    protected void setUp() throws Exception {
        calcMock = mock(Calc.class);
        calc = (Calc) calcMock.proxy();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        controller = new CalcController(calc);
        request.setRequestURI("calc/anyaction/1/2");
    }

    public void testShouldLoadCalc() throws Exception {
        ModelAndView mov = controller.load(request, response);
        assertEquals("calc", mov.getViewName());
    }

    public void testShouldInvokeAddOnCalc() throws Exception {
        actionOnCalc("add", 1, 2, 3);
    }

    public void testShouldInvokeSubtractOnCalc() throws Exception {
        actionOnCalc("subtract", 1, 2, -1);
    }

    public void testShouldInvokeMultiplyOnCalc() throws Exception {
        actionOnCalc("multiply", 1, 2, 2);
    }

    public void testShouldInvokeDivideOnCalc() throws Exception {
        actionOnCalc("divide", 1, 2, 0);
    }

    private void actionOnCalc(String action, int digitA, int digitB, int result)
            throws Exception {
        calcMock.expects(once()).method(action).with(eq(digitA), eq(digitB))
                .will(returnValue(new Integer(result)));
        Method actionMethod = CalcController.class.getMethod(action,
                new Class[] { HttpServletRequest.class,
                        HttpServletResponse.class });
        Object mov = actionMethod.invoke(controller, new Object[] { request,
                response });
        assertEquals(new Integer(result), ((ModelAndView) mov).getModel().get(
                "result"));
        assertEquals("result", ((ModelAndView) mov).getViewName());
    }
}
