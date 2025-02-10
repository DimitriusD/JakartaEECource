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
import java.util.Collections;
import java.util.List;

@WebServlet(name = "currenciesServlet", value = "/currencies")
public class CurrenciesServlet extends HttpServlet {

    @Inject
    private ExchangeRateService rateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<ExchangeRate> todayRates = rateService.getExchangeRate();
            req.setAttribute("todayRates", todayRates);
        } catch (Exception e) {
            LoggerUtil.logError(getClass(), "Error retrieving exchange rates", e);

            req.setAttribute("todayRates", Collections.emptyList());
            req.setAttribute("errorMessage", "Не вдалося отримати курси валют. Будь ласка, спробуйте пізніше.");
        }

        try {
            req.getRequestDispatcher("/WEB-INF/views/currencyRates.jsp").forward(req, resp);
        } catch (ServletException ex) {
            LoggerUtil.logError(getClass(), "Error forwarding to JSP", ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error.");
        }
    }
}
