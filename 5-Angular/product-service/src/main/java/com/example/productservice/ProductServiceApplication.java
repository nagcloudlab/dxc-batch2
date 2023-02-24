package com.example.productservice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Product {
	private int id;
	private String name;
	private double price;
	private String description;
	private String imgUrl;
	private boolean isAvailable;
}

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductServiceApplication {

	@GetMapping("api/products")
	public Iterable<Product> getProducts() {
		return List.of(
				new Product(1, "Laptop", 1000.00, "This is a laptop", "assets/Laptop.png", true),
				new Product(2, "Mobile", 500.00, "This is a mobile", "assets/Mobile.png", true));
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
