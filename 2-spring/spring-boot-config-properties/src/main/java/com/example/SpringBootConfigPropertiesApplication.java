package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootConfigPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigPropertiesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(GreetingService greetingService) {
		return args -> {
			greetingService.greet();
		};
	}

}
