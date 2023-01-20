package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Employee;
import com.example.model.EmployeeId;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeId> {

}
