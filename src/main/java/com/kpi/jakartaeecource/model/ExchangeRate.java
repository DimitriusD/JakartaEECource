package com.kpi.jakartaeecource.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate {
    private String currencyCode;
    private String currencyName;
    private double rate;
    private String exchangeDate;
}
