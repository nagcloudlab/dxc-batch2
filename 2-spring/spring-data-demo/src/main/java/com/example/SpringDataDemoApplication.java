package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.model.Employee;
import com.example.model.EmployeeId;
import com.example.model.Todo;
import com.example.model.User;
import com.example.repository.EmployeeRepository;
import com.example.repository.TodoRepository;
import com.example.repository.UserRepository;

@SpringBootApplication
public class SpringDataDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository, TodoRepository todoRepository,
			EmployeeRepository employeeRepository) {
		return args -> {

			// User user = new User();
			// user.setName("foo");
			// user.setEmail("foo@mail.com");
			// user.setMobile("987654321");

			// userRepository.save(user);

			// userRepository.findAll()
			// .forEach(System.out::println);

			// User user = userRepository.findByEmailAddress("foo@mail.com").orElse(null);
			// System.out.println(user);

			// Todo todo = new Todo();
			// todo.setId(1);
			// todo.setTitle("lear ???");
			// todoRepository.save(todo);

			EmployeeId employeeId = new EmployeeId();
			employeeId.setEmpId(45);
			employeeId.setDepId("IT");

			Employee employee = new Employee();
			employee.setId(employeeId);
			employee.setFirstName("sfd");
			employee.setLastName("sdf");

			employeeRepository.save(employee);

		};
	}

}
