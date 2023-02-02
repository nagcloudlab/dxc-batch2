package com.example.model;

import com.example.model.TodoType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    @Enumerated(EnumType.STRING)
    private TodoType type;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Todo(String title, String description,TodoType type,Employee employee) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.employee = employee;
    }


}
