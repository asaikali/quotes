package com.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class MessageService {

    private final RestTemplate restTemplate;
    private final Random random = new Random();

    public MessageService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String getMessage(String city) {
        if (random.nextFloat() < 0.5) {
            return getWeatherReport(city);
        } else {
            return getMotivationalQuote();
        }
    }

    private String getWeatherReport(String city) {
        final CurrentWeather weather = restTemplate.getForObject("http://weather-service/weather/current/" + city, CurrentWeather.class);
        return String.format("""
                        Weather update for %s. 
                        Currently, the skies are %s with the temperature at %.1f degrees.
                        The humidity stands at %d%%, and we've got winds moving at %.1f km/h, coming from the %s.""",
                weather.getCity(),
                weather.getWeatherCondition().toLowerCase(),
                weather.getTemperature(),
                weather.getHumidity(),
                weather.getWindSpeed(),
                weather.getWindDirection());
    }

    private String getMotivationalQuote() {
        Quote quote = restTemplate.getForObject("http://quotes-service/", Quote.class);
        quote.setQuote(quote.getQuote().toUpperCase());
        return quote.getQuote() + " -- " + quote.getAuthor() + " -- Platform: " + quote.getPlatform();
    }

}