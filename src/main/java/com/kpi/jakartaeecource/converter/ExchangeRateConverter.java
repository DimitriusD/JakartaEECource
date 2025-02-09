package com.kpi.jakartaeecource.converter;

import com.kpi.jakartaeecource.api.dto.ExchangeRateDto;
import com.kpi.jakartaeecource.model.ExchangeRate;

import java.util.List;
import java.util.stream.Collectors;

public final class ExchangeRateConverter {

    private ExchangeRateConverter() {
    }

    public static ExchangeRate toExchangeRate(ExchangeRateDto dto) {
        return new ExchangeRate(
                dto.getCurrencyCode(),
                dto.getCurrencyName(),
                dto.getRate(),
                dto.getExchangeDate()
        );
    }

    public static List<ExchangeRate> toExchangeRates(List<ExchangeRateDto> dtos) {
        return dtos.stream().map(ExchangeRateConverter::toExchangeRate).collect(Collectors.toList());
    }
}
