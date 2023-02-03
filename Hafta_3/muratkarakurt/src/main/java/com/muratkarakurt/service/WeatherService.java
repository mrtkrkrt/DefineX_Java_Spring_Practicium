package com.muratkarakurt.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.muratkarakurt.model.Weather;
import com.muratkarakurt.model.WeatherResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(Weather weather) {
        String resourceUrl = "http://api.weatherapi.com/v1/current.json?key={apiKey}&q={city}&days={days}";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl,
                                                                HttpMethod.GET,
                                                                entity,
                                                                String.class,
                                                                apiKey,
                                                                weather.getCity(),
                                                                weather.getdays());
        //TODO auth ve lokasyon bilgilerinin doğruluğunu custom error lar ile kontrol et
        return responseToWeatherResponse(response.getBody());
    }

    public WeatherResponse responseToWeatherResponse(String response) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node;

        JsonFactory factory = objectMapper.getFactory();
        JsonParser jsonParser = null;
        try {
            jsonParser = factory.createParser(response);
            node = objectMapper.readTree(jsonParser);
        } catch (IOException e) {
            // TODO custom exception
            throw new RuntimeException(e);
        }

        String name = node.get("location").get("name").toString();
        String country = node.get("location").get("country").toString();
        String region = node.get("location").get("tz_id").toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm");
        String localtime = node.get("location").get("localtime").toString();
        Date localTime = null;
        try {
            localTime = formatter.parse(localtime.substring(1, localtime.length() - 1));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        double temp_c = Double.parseDouble(node.get("current").get("temp_c").toString());
        double temp_f = Double.parseDouble(node.get("current").get("temp_f").toString());
        String condition = node.get("current").get("condition").get("text").toString();
        double avgWind = Double.parseDouble(node.get("current").get("wind_mph").toString());
        String icon = node.get("current").get("condition").get("icon").toString();

        return new WeatherResponse(name, country, region, localTime, temp_c, temp_f, condition, avgWind, icon);
    }
}
