package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.application.name=config-server",
        "spring.config.name=config-server",
        "spring.profiles.active=native",
        "spring.cloud.config.import-check.enabled=false"
        //  "spring.cloud.config.server.native.searchLocations=file:/pathToFile"
})
public class WeatherServiceApplicationTests {

    @Test
    public void contextLoads() {
    }
}
