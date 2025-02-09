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

@WebServlet(name = "сurrenciesServlet", value = "/currencies")
public class CurrenciesServlet extends HttpServlet {

    @Inject
    private ExchangeRateService rateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ExchangeRate> todayRates = null;
        try {
            todayRates = rateService.getExchangeRate();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("todayRates", todayRates);
        req.getRequestDispatcher("/WEB-INF/views/currencyRates.jsp").forward(req, resp);

    }
}
