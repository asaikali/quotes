package com.example.messageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ScQuotesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScQuotesServiceApplication.class, args);
    }
}
