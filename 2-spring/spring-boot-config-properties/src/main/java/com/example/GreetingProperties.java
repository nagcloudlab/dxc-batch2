package com.example;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app.greeting")
public class GreetingProperties {

    private String name;
    private String message;
    private List<String> messages;
    // private Map<String, String> localeMessages;

}
