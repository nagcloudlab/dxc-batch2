package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("from Employee e where e.department.id=:id")
    Iterable<Employee> findByDepartmentId(Long id);

}
