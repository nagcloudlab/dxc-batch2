package com.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "todos")
public class Todo {

    @Id
    private int id;
    private String title;
    private String description;

}
