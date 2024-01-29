package com.example.messageservice;

import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    private final QuoteRepository quoteRepository;
    private final Environment environment;

    public MessageController(QuoteRepository quoteRepository, Environment environment) {
        this.quoteRepository = quoteRepository;
        this.environment = environment;
    }

    @GetMapping("/")
    public Quote radomQuote() {
        Quote result = quoteRepository.findRandomQuote();
        CloudPlatform platform = CloudPlatform.getActive(environment);
        if (platform != null) {
            result.setPlatform(platform.name());
        }

        return result;
    }

    @GetMapping("/quotes")
    public List<Quote> getAll() {
        return quoteRepository.findAll();
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuote(@PathVariable("id") Integer id) {
        Optional<Quote> quote = quoteRepository.findById(id);
        if (quote.isPresent()) {
            return new ResponseEntity<>(quote.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
