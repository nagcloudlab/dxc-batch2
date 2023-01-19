package com.example;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Profile("test")
@Service
@RequiredArgsConstructor
public class GreetingService {

    // // @Value("Hello")
    // @Value("${app.greeting.message:Hello}")
    // private String greetingMessage;

    // @Value("${app.greeting.messages}")
    // private List<String> greetingMessages;

    // @Value("#{${app.greeting.locale.messages}}")
    // private Map<String, String> greetingLocaleMessages;

    // @Value("${app.greeting.name}")
    // private String name;

    private final GreetingProperties greetingProperties;

    // public GreetingService(GreetingProperties greetingProperties) {
    // this.greetingProperties = greetingProperties;
    // }

    public void greet() {
        // System.out.println(greetingMessage);
        // System.out.println(greetingMessages);
        // System.out.println(greetingLocaleMessages.get("tn"));
        // System.out.println(name);

        System.out.println(greetingProperties.getName());
        System.out.println(greetingProperties.getMessage());
        System.out.println(greetingProperties.getMessages());
        // System.out.println(greetingProperties.getLocaleMessages());

    }

}
