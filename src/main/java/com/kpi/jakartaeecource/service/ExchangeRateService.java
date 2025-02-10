package com.kpi.jakartaeecource.service;

import com.kpi.jakartaeecource.api.NbuApiClient;
import com.kpi.jakartaeecource.api.converter.ExchangeRateConverter;
import com.kpi.jakartaeecource.api.dto.ExchangeRateDto;
import com.kpi.jakartaeecource.model.ExchangeRate;
import com.kpi.jakartaeecource.utils.LoggerUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Named
@ApplicationScoped
public class ExchangeRateService {

    private NbuApiClient nbuApiClient;

    public ExchangeRateService() {
    }

    @Inject
    public ExchangeRateService(NbuApiClient nbuApiClient) {
        this.nbuApiClient = nbuApiClient;
    }

    public List<ExchangeRate> getExchangeRate() {
        try {
            List<ExchangeRateDto> exchangeRates = nbuApiClient.fetchCurrentRates();
            return ExchangeRateConverter.toExchangeRates(exchangeRates);
        } catch (IOException e) {
            LoggerUtil.logError(getClass(), "Error fetching current exchange rates", e);
            throw new RuntimeException("Failed to fetch current exchange rates", e);
        }
    }

    public List<ExchangeRate> getHistoryRates(String currencyCode, LocalDate startDate,  LocalDate endDate) {
        try {
            validateDates(startDate, endDate);

            List<ExchangeRateDto> exchangeRates = nbuApiClient.fetchHistoricalRates(currencyCode, startDate, endDate);
            return ExchangeRateConverter.toExchangeRates(exchangeRates);
        } catch (IOException e) {
            LoggerUtil.logError(getClass(), String.format("Error fetching historical exchange rates for %s", currencyCode), e);
            throw new RuntimeException("Failed to fetch historical exchange rates for " + currencyCode, e);
        }
    }

    private void validateDates(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after the end date.");
        }
    }
}
