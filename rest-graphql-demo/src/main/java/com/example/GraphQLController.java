package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class GraphQLController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @QueryMapping
    Iterable<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    @QueryMapping
    Iterable<Department> allDepartments() {
        return departmentRepository.findAll();
    }


    @SchemaMapping(typeName = "Department",field = "employees")
    Iterable<Employee> employees(Department department){
      return employeeRepository.findByDepartmentId(department.getId());
    }

    @QueryMapping
    Optional<Employee> oneEmployee(@Argument Long id) {
        return employeeRepository.findById(id);
    }

    @MutationMapping
    Employee newEmployee(@Argument NewEmployeeInput employeeInput) {
        Department department = departmentRepository.findById(employeeInput.depId()).orElseThrow(() -> new NotFoundException("no department on id: " + employeeInput.depId()));
        Employee employee = new Employee(
                employeeInput.firstName(),
                employeeInput.lastName(),
                employeeInput.email(),
                employeeInput.mobile(),
                employeeInput.address(),
                department
        );
        employee = employeeRepository.save(employee);
        return employee;
    }

    @MutationMapping
    public Employee updateEmployee(@Argument UpdateEmployeeInput employeeInput) {
        Employee employee = employeeRepository.findById(employeeInput.id()).orElseThrow(() -> new NotFoundException("no employee on id: " + employeeInput.id()));
        employee.setEmail(employeeInput.email());
        employee.setMobile(employeeInput.mobile());
        employee.setAddress(employeeInput.address());
        employee = employeeRepository.save(employee);
        return employee;
    }

    @MutationMapping
    public Long deleteEmployee(@Argument Long id) {
        employeeRepository.deleteById(id);
        return id;
    }


}
