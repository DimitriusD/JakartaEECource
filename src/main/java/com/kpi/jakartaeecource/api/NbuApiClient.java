package com.kpi.jakartaeecource.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpi.jakartaeecource.api.dto.ExchangeRateDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Named
@ApplicationScoped
public class NbuApiClient {

    private static final String NBU_CURRENT_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    private static final String NBU_HISTORICAL_URL = "https://bank.gov.ua/NBU_Exchange/exchange_site?start=%s&end=%s&valcode=%s&sort=exchangedate&order=desc&json";

    private ObjectMapper objectMapper;

    @Inject
    public NbuApiClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public NbuApiClient() {
    }

    public List<ExchangeRateDto> fetchCurrentRates() throws Exception {
        String jsonResponse = sendGetRequest(NBU_CURRENT_URL);
        return objectMapper.readValue(jsonResponse, new TypeReference<>() {});
    }

    public List<ExchangeRateDto> fetchHistoricalRates(String currencyCode, String startDate, String endDate) throws Exception {
        String apiUrl = String.format(NBU_HISTORICAL_URL, startDate, endDate, currencyCode);
        String jsonResponse = sendGetRequest(apiUrl);

        return objectMapper.readValue(jsonResponse, new TypeReference<>() {});
    }


    private String sendGetRequest(String apiUrl) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}