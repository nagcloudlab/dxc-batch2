package com.example;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestGraphqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestGraphqlDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			EmployeeRepository employeeRepository,
			DepartmentRepository departmentRepository) {
		return args -> {
			Department department1 = departmentRepository.save(new Department("SALES"));
			Department department2 = departmentRepository.save(new Department("HR"));
			Department department3 = departmentRepository.save(new Department("ACCOUNTS"));
			employeeRepository.saveAll(List.of(
					new Employee("John", "Doe", "john@email.com", "12345890", "chennai", department1),
					new Employee("Foo", "Bar", "foobar@email.com", "0987521", "chennai", department1)));
		};
	}

}
