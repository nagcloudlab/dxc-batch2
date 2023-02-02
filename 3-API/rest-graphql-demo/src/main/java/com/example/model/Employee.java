package com.example.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @OneToMany(
            mappedBy = "employee",
            targetEntity = Todo.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Todo> todos;

    public Employee(String firstName, String lastName, String email, String mobile, String address,Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.department = department;
    }


}
