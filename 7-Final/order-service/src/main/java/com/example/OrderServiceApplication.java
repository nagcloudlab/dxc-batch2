package com.example;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

// dto
@Data
class ItemLine {
	private String name;
	private int qty;
}

@Data
class Customer {
	private String name;
}

@Data
class OrderRequest {
	private List<ItemLine> itemLines;
	private Customer customer;
}

@Data
@RequiredArgsConstructor
class OrderResponse {
	private final String orderId;
}

@Data
@AllArgsConstructor
class CustomerVerifyRequest {
	private String name;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class CustomerVerifyResponse {
	private String name;
	private boolean verified;
}

@RestController
@RequestMapping("/api/orders")
class OrderController {

	WebClient webClient = WebClient.create();

	@PostMapping(consumes = "application/json", produces = "application/json")
	OrderResponse create(@RequestBody OrderRequest orderRequest) {
		System.out.println(orderRequest);

		Mono<CustomerVerifyResponse> customerVerifyResponseMono = webClient.post()
				.uri("http://localhost:8083/api/customers/verify")
				.accept(MediaType.APPLICATION_JSON )
				.body(Mono.just(new CustomerVerifyRequest(orderRequest.getCustomer().getName())),
						CustomerVerifyRequest.class)
				.retrieve()
				.bodyToMono(CustomerVerifyResponse.class);

		customerVerifyResponseMono.subscribe(cv -> {
			System.out.println(cv.getName());
			System.out.println(cv.isVerified());
		}, err -> {
			System.out.println(err.getMessage());
		});

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new OrderResponse(UUID.randomUUID().toString());
	}
}

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
