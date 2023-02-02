package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Department(String name) {
        this.name = name;
    }

}
