package com.kpi.jakartaeecource.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.net.http.HttpClient;

@ApplicationScoped
public class AppConfig {

    @Produces
    public HttpClient produceHttpClient() {
        return HttpClient.newHttpClient();
    }

    @Produces
    public ObjectMapper produceObjectMapper() {
        return new ObjectMapper();
    }
}