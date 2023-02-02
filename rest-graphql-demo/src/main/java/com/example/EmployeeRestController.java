package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("no employee on id: " + id)));
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<?> createEmployee(@RequestBody NewEmployeeInput employeeInput) {
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
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,@RequestBody NewEmployeeInput employeeInput) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("no employee on id: " +id));
        employee.setEmail(employeeInput.email());
        employee.setMobile(employeeInput.mobile());
        employee.setAddress(employeeInput.address());
        employee = employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> handleException(Throwable throwable) {
        HttpError httpError = new HttpError(404, throwable.getMessage());
        return ResponseEntity.status(httpError.status()).body(httpError);
    }

    record HttpError(int status, String message) {
    }



}
