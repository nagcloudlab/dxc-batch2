package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Product {
    private String name;
    private double price;
    private String description;
    private String imgPath;
}

@RestController
@RequestMapping("/api/products")
class ProductController {

    @GetMapping
    public Iterable<Product> getProducts() {
        return List.of(
                new Product("veg", 10.99, "veg is always healthy","https://images.unsplash."),
                new Product("non-veg", 10.99, "Try once a week","https://images.unsplash.")
        );
    }

}

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
