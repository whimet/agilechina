//add today comments in CalcController.java and Calc.java
//add three
//add8 hehehhehehhe
//user ydqiao 01
package com.google.code.calc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.code.calc.Calc;
import com.google.code.calc.utils.CalcUtils;

public class CalcController extends MultiActionController {
    private Calc calc;

    public CalcController(Calc calc) {
        this.calc = calc;
    }

    public ModelAndView load(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("calc");
    }

    public ModelAndView add(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        int[] params = getParams(request.getRequestURI());
        return doCalc(calc.add(params[0], params[1]));
    }

    public ModelAndView subtract(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        int[] params = getParams(request.getRequestURI());
        return doCalc(calc.subtract(params[0], params[1]));
    }

    public ModelAndView multiply(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        int[] params = getParams(request.getRequestURI());
        return doCalc(calc.multiply(params[0], params[1]));
    }

    public ModelAndView divide(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        int[] params = getParams(request.getRequestURI());
        return doCalc(calc.divide(params[0], params[1]));
    }

    private int[] getParams(String uri) {
        String[] urlToParams = CalcUtils.urlToParams(uri);
        int length = urlToParams.length;
        int[] params = new int[2];
        params[0] = Integer.parseInt(urlToParams[length - 2]);
        params[1] = Integer.parseInt(urlToParams[length - 1]);
        return params;
    }

    private ModelAndView doCalc(Integer result) {
        ModelAndView mov = new ModelAndView("result");
        mov.getModel().put("result", result);
        return mov;
    }

}
