package com.kpi.jakartaeecource.servlet;

import com.kpi.jakartaeecource.model.ExchangeRate;
import com.kpi.jakartaeecource.service.ExchangeRateService;
import com.kpi.jakartaeecource.utils.LoggerUtil;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "сurrenciesServlet", value = "/currencies")
public class CurrenciesServlet extends HttpServlet {

    @Inject
    private ExchangeRateService rateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<ExchangeRate> todayRates = rateService.getExchangeRate();
            req.setAttribute("todayRates", todayRates);
            req.getRequestDispatcher("/WEB-INF/views/currencyRates.jsp").forward(req, resp);
        } catch (Exception e) {
            LoggerUtil.logError(getClass(), "Error retrieving exchange rates", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to fetch exchange rates.");
        }

    }
}
