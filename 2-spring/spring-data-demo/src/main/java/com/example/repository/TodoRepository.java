package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, Integer> {

}
