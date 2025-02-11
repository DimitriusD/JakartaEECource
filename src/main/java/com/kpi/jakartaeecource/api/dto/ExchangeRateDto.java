package com.kpi.jakartaeecource.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateDto {

    @JsonProperty("exchangedate")
    private String exchangeDate;

    @JsonProperty("r030")
    private int currencyCodeNumeric;

    @JsonProperty("cc")
    private String currencyCode;

    @JsonProperty("txt")
    private String currencyName;

    @JsonProperty("enname")
    private String currencyNameEn;

    @JsonProperty("rate")
    private double rate;

    @JsonProperty("units")
    private int units;

    @JsonProperty("rate_per_unit")
    private double ratePerUnit;

    @JsonProperty("group")
    private String group;

    @JsonProperty("calcdate")
    private String calculationDate;
}
