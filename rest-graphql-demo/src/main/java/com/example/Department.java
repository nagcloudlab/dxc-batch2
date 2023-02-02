package com.example;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
