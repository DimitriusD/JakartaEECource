package com.kpi.jakartaeecource.servlet;

import com.kpi.jakartaeecource.model.ExchangeRate;
import com.kpi.jakartaeecource.service.ExchangeRateService;
import com.kpi.jakartaeecource.utils.LoggerUtil;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "currencyHistoryServlet", value = "/history")
public class CurrencyHistoryServlet extends HttpServlet {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private ExchangeRateService exchangeRateService;

    @Inject
    public void setExchangeRateService(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String currencyCode = request.getParameter("currency");
        String startDateParam = request.getParameter("startDate");
        String endDateParam = request.getParameter("endDate");

        if (currencyCode == null || currencyCode.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        try {
            LocalDate endDate = endDateParam != null && !endDateParam.isBlank()
                    ? LocalDate.parse(endDateParam, DATE_FORMATTER)
                    : LocalDate.now();

            LocalDate startDate = startDateParam != null && !startDateParam.isBlank()
                    ? LocalDate.parse(startDateParam, DATE_FORMATTER)
                    : endDate.minusDays(30);

            List<ExchangeRate> historyRates = exchangeRateService.getHistoryRates(currencyCode, startDate, endDate);

            request.setAttribute("currencyCode", currencyCode);
            request.setAttribute("historyRates", historyRates);

            request.getRequestDispatcher("/WEB-INF/views/history.jsp").forward(request, response);
        } catch (Exception e) {
            LoggerUtil.logError(getClass(), String.format("Error fetching historical exchange rates for %s", currencyCode), e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to fetch exchange rates.");
        }
    }
}
