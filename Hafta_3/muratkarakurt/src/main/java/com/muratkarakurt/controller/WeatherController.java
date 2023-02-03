package com.muratkarakurt.controller;

import com.muratkarakurt.model.Weather;
import com.muratkarakurt.model.WeatherResponse;
import com.muratkarakurt.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/weather")
    public WeatherResponse postWeather(@RequestBody Weather weather) {
        return weatherService.getWeather(weather);
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather() {
        return weatherService.getWeather(new Weather("Turkey", "Istanbul", "1"));
    }
}
