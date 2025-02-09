package com.kpi.jakartaeecource.service;

import com.kpi.jakartaeecource.api.NbuApiClient;
import com.kpi.jakartaeecource.api.dto.ExchangeRateDto;
import com.kpi.jakartaeecource.converter.ExchangeRateConverter;
import com.kpi.jakartaeecource.model.ExchangeRate;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public List<ExchangeRate> getExchangeRate() throws Exception {
        List<ExchangeRateDto> exchangeRateDtos = nbuApiClient.fetchCurrentRates();
        return ExchangeRateConverter.toExchangeRates(exchangeRateDtos);
    }

    public List<ExchangeRate> getHistoryRates(String currencyCode) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        String endDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.YEAR, -1);
        String startDate = dateFormat.format(calendar.getTime());
        List<ExchangeRateDto> exchangeRateDtos = nbuApiClient.fetchHistoricalRates(currencyCode, startDate, endDate);
        return ExchangeRateConverter.toExchangeRates(exchangeRateDtos);
    }
}
