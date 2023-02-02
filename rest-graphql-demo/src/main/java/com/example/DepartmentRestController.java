package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentRestController {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @GetMapping
    public Iterable<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/employees")
    public Iterable<Employee> getDepartmentEmployees(@PathVariable Long id) {
        Iterable<Employee> employees = employeeRepository.findByDepartmentId(id);
        return employees;
    }

//    @DeleteMapping("/{id}")
//    public void deleteDepartmentById(@PathVariable Long id) {
//        departmentRepository.deleteById(id);
//    }

}
