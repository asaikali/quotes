package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String get() {
        return this.get(Optional.of("Ajax"));
    }

    @GetMapping(value = {"/message/{city}", "/message"})
    public String get(@PathVariable(required = false) Optional<String> city) {
        String cityName = city.orElse("Toronto");
        return this.messageService.getMessage(cityName);
    }

}
