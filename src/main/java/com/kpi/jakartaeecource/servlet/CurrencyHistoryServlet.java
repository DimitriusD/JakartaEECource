package com.kpi.jakartaeecource.servlet;

import com.kpi.jakartaeecource.model.ExchangeRate;
import com.kpi.jakartaeecource.service.ExchangeRateService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "currencyHistoryServlet", value = "/history")
public class CurrencyHistoryServlet extends HttpServlet {

    @Inject
    private ExchangeRateService exchangeRateService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String currencyCode = request.getParameter("currency");
        if (currencyCode == null || currencyCode.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }


        List<ExchangeRate> historyRates = null;
        try {
            historyRates = exchangeRateService.getHistoryRates(currencyCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("currencyCode", currencyCode);
        request.setAttribute("historyRates", historyRates);

        request.getRequestDispatcher("/WEB-INF/views/history.jsp").forward(request, response);
    }

}
