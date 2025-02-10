package com.kpi.jakartaeecource.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpi.jakartaeecource.api.dto.ExchangeRateDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Named
@ApplicationScoped
public class NbuApiClient {

    private static final String NBU_CURRENT_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    private static final String NBU_HISTORICAL_URL = "https://bank.gov.ua/NBU_Exchange/exchange_site?start=%s&end=%s&valcode=%s&sort=exchangedate&order=desc&json";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private ObjectMapper objectMapper;

    @Inject
    public NbuApiClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public NbuApiClient() {
        // Default constructor for CDI
    }

    public List<ExchangeRateDto> fetchCurrentRates() throws IOException {
        String jsonResponse = sendGetRequest(NBU_CURRENT_URL);
        return objectMapper.readValue(jsonResponse, new TypeReference<>() {
        });
    }

    public List<ExchangeRateDto> fetchHistoricalRates(String currencyCode, LocalDate startDate, LocalDate endDate) throws IOException {
        String apiUrl = String.format(NBU_HISTORICAL_URL, startDate.format(DATE_FORMATTER), endDate.format(DATE_FORMATTER), currencyCode);
        String jsonResponse = sendGetRequest(apiUrl);
        return objectMapper.readValue(jsonResponse, new TypeReference<>() {
        });
    }


    private String sendGetRequest(String apiUrl) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to fetch data from NBU API. Response Code: " + responseCode);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } finally {
            conn.disconnect();
        }
    }
}