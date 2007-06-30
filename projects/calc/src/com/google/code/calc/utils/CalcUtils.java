package com.google.code.calc.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.lang.StringUtils;

public final class CalcUtils {
    private CalcUtils() {
    }

    public static String decode(String url) {
        try {
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return url;
        }
    }

    public static String[] urlToParams(String url) {
        String[] params = StringUtils
                .split(StringUtils.defaultString(url), '/');
        String[] decodedParams = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            decodedParams[i] = decode(params[i]);
        }
        return decodedParams;
    }

}
