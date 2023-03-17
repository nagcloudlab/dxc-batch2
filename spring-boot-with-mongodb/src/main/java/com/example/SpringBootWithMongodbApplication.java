package com.example;

import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Document(collection = "todos")
class Todo {
	@Id
	private ObjectId objectId;
	private int id;
	private String title;
	private boolean completed;
}

interface TodoRepository extends MongoRepository<Todo, ObjectId> {

}

@Data
class NewTodoRequestDto {
	private String title;
}

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
class TodoController {
	private final TodoRepository repository;

	@PostMapping
	public Todo save(@RequestBody NewTodoRequestDto dto) {
		Todo todo = new Todo();
		todo.setTitle(dto.getTitle());
		todo.setId(1);
		todo.setCompleted(false);
		return repository.save(todo);
	}

	@GetMapping
	public Iterable<Todo> findAll() {
		return repository.findAll();
	}
}

@SpringBootApplication
public class SpringBootWithMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongodbApplication.class, args);
	}

}
