package com.kpi.jakartaeecource.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        return sanitize(value);
    }

    private String sanitize(String input) {
        if (input == null) {
            return null;
        }

        return input.replaceAll("[<>\"'()]", "");
    }
}
