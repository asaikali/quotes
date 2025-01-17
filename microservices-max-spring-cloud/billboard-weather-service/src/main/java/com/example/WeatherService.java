package com.example;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class WeatherService {

    private static final String[] CONDITIONS = {"Sunny", "Cloudy", "Rainy", "Partly Cloudy", "Snowy"};
    private static final String[] WIND_DIRECTIONS = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    public CurrentWeather getCurrentWeather(String city) {
        Random random = new Random();

        CurrentWeather weather = new CurrentWeather();
        weather.setCity(city);
        weather.setTemperature(roundToOneDecimalPlace(10 + (30 - 10) * random.nextDouble())); // Random temperature between 10 and 30, rounded to one decimal place
        weather.setWeatherCondition(CONDITIONS[random.nextInt(CONDITIONS.length)]);
        weather.setHumidity(random.nextInt(101)); // Random humidity between 0 and 100%
        weather.setWindSpeed(roundToOneDecimalPlace(random.nextDouble() * 20)); // Random wind speed between 0 and 20 km/h, rounded to one decimal place
        weather.setWindDirection(WIND_DIRECTIONS[random.nextInt(WIND_DIRECTIONS.length)]);
        weather.setTimeStamp(LocalDateTime.now()); // Current timestamp

        return weather;
    }

    private double roundToOneDecimalPlace(double value) {
        return Math.round(value * 10.0) / 10.0;
    }
}
