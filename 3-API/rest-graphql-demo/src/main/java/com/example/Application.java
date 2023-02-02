package com.example;

import com.example.model.Department;
import com.example.model.Employee;
import com.example.model.Todo;
import com.example.model.TodoType;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            TodoRepository todoRepository
    ) {
        return args -> {

            Department department = departmentRepository.save(new Department("IT"));

            Employee employee = employeeRepository.save(
                    new Employee("John", "Doe", "john@email.com", "12345890", "chennai", department)
            );
            todoRepository.saveAll(List.of(
                    new Todo("todo-1", "todo-1 description", TodoType.DEV, employee),
                    new Todo("todo-2", "todo-2 description", TodoType.TEST, employee)
            ));

        };
    }

}
