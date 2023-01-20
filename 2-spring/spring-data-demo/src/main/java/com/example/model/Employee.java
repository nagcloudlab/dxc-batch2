package com.example.model;

import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @EmbeddedId
    private EmployeeId id;

    private String firstName;
    private String lastName;

}
