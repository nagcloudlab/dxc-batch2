package com.example.customerservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
class CustomerVerifyRequest {
    private String name;
}

@Data
@AllArgsConstructor
class CustomerVerifyResponse {
    private String name;
    private boolean verified;
}

@RestController
@RequestMapping("/api/customers")
class CustomerController {

    @PostMapping(value = "verify")
    public CustomerVerifyResponse verifyCustomers(@RequestBody CustomerVerifyRequest request) {
        System.out.println(request.getName());
        if (request.getName().equals("John"))
            return new CustomerVerifyResponse(request.getName(), true);
        else
            return new CustomerVerifyResponse(request.getName(), false);
    }

}

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

}
