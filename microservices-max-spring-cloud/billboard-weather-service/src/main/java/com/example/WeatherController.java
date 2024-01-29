package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/")
    public CurrentWeather get() {
        return this.getCurrentWeather("Ajax");
    }

    @GetMapping("/weather/current/{city}")
    public CurrentWeather getCurrentWeather(@PathVariable String city) {
        return weatherService.getCurrentWeather(city);
    }
}
