package com.kpi.jakartaeecource.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateDto {

    @JsonProperty("exchangedate")
    private String exchangeDate;  // Дата курсу (05.05.2022)

    @JsonProperty("r030")
    private int currencyCodeNumeric;  // Числовий код валюти (840 - USD)

    @JsonProperty("cc")
    private String currencyCode;  // Символьний код валюти (USD, EUR, GBP)

    @JsonProperty("txt")
    private String currencyName;  // Назва валюти українською ("Долар США")

    @JsonProperty("enname")
    private String currencyNameEn;  // Назва валюти англійською ("US Dollar")

    @JsonProperty("rate")
    private double rate;  // Курс валюти по відношенню до гривні (29.2549)

    @JsonProperty("units")
    private int units;  // Кількість одиниць валюти (1)

    @JsonProperty("rate_per_unit")
    private double ratePerUnit;  // Курс за 1 одиницю валюти (29.2549)

    @JsonProperty("group")
    private String group;  // Група валют ("1")

    @JsonProperty("calcdate")
    private String calculationDate;  // Дата розрахунку курсу (04.05.2022)

    public ExchangeRateDto() {
    }

    public ExchangeRateDto(String exchangeDate, int currencyCodeNumeric, String currencyCode,
                           String currencyName, String currencyNameEn, double rate, int units,
                           double ratePerUnit, String group, String calculationDate) {
        this.exchangeDate = exchangeDate;
        this.currencyCodeNumeric = currencyCodeNumeric;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.currencyNameEn = currencyNameEn;
        this.rate = rate;
        this.units = units;
        this.ratePerUnit = ratePerUnit;
        this.group = group;
        this.calculationDate = calculationDate;
    }

    // Геттери і сеттери
    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public int getCurrencyCodeNumeric() {
        return currencyCodeNumeric;
    }

    public void setCurrencyCodeNumeric(int currencyCodeNumeric) {
        this.currencyCodeNumeric = currencyCodeNumeric;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyNameEn() {
        return currencyNameEn;
    }

    public void setCurrencyNameEn(String currencyNameEn) {
        this.currencyNameEn = currencyNameEn;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getRatePerUnit() {
        return ratePerUnit;
    }

    public void setRatePerUnit(double ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(String calculationDate) {
        this.calculationDate = calculationDate;
    }

}
