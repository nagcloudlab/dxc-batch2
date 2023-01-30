package com.example.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.example.api.dto.NewTodo;
import com.example.exception.HttpError;
import com.example.exception.NotFoundException;
import com.example.model.Todo;

@RestController
@RequestMapping(value = "/v1/api/todos")
public class TodosRestController {

    private static Map<Integer, Todo> todosMap = new HashMap<>();

    static {
        todosMap.put(1, new Todo(1, "Learn Java", true));
        todosMap.put(2, new Todo(2, "Learn Spring Boot", true));
        todosMap.put(3, new Todo(3, "Learn API", false));
    }

    // read

    @GetMapping(produces = { "application/json" }/* , params = "limit",headers = { "Authorization" } */)
    public ResponseEntity<?> getTodos(
            @RequestParam(defaultValue = "0") int limit) {
        // System.out.println(authorization);
        List<Todo> todos = todosMap.values().stream()/* .limit(limit) */.toList();
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    @GetMapping(value = "/{todoId}", produces = { "application/json" })
    public ResponseEntity<?> getTodo(
            @PathVariable("todoId") int todoId) {
        Todo todo = todosMap.get(todoId);
        if (todo == null)
            throw new NotFoundException("todo not found : " + todoId);
        else
            return ResponseEntity.status(HttpStatus.OK).body(todosMap.get(todoId));
    }

    @RequestMapping(method = RequestMethod.HEAD, value = "/{todoId}", produces = { "application/json" })
    public ResponseEntity<?> isTodoExist(
            @PathVariable("todoId") int todoId) {
        Todo todo = todosMap.get(todoId);
        if (todo == null)
            throw new NotFoundException("todo not found : " + todoId);
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("my-xxx", "my-yyyy");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(null);
        }
    }

    // write

    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<?> createTodo(@RequestBody NewTodo newTodo) {
        Todo todo = new Todo();
        todo.setId(todosMap.size() + 1);
        todo.setTitle(newTodo.getTitle());
        todo.setCompleted(false);
        todosMap.put(todo.getId(), todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todosMap.get(todo.getId()));
    }

    // idemponent
    @PutMapping(value = "/{todoId}", consumes = { "application/json" })
    public ResponseEntity<?> createOrUpdateTodo(@PathVariable int todoId, @RequestBody NewTodo newTodo) {

        if (todosMap.get(todoId) == null) {
            Todo todo = new Todo();
            todo.setId(todoId);
            todo.setTitle(newTodo.getTitle());
            todo.setCompleted(false);
            todosMap.put(todo.getId(), todo);
            return ResponseEntity.status(HttpStatus.CREATED).body(todosMap.get(todo.getId()));
        } else {
            Todo todo = todosMap.get(todoId);
            if (todo == null)
                throw new NotFoundException("todo not found : " + todoId);
            todo.setTitle(newTodo.getTitle());
            return ResponseEntity.status(HttpStatus.OK).body(todosMap.get(todo.getId()));
        }

    }

    // idemponent
    @DeleteMapping(value = "/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable int todoId) {
        Todo todo = todosMap.get(todoId);
        if (todo == null)
            throw new NotFoundException("todo not found : " + todoId);
        todosMap.remove(todoId);
        return ResponseEntity.status(HttpStatus.OK).body(todosMap.get(todo.getId()));
    }

    @ExceptionHandler(value = {
            NotFoundException.class
    })
    public ResponseEntity<?> handleException(ServerRequest request, Exception e) {
        HttpError httpError = new HttpError();
        httpError.setPath(request.path());
        if (e instanceof NotFoundException) {
            httpError.setStatus(HttpStatus.NOT_FOUND.value());
        }
        httpError.setMessage(e.getMessage());
        return ResponseEntity.status(httpError.getStatus()).body(httpError);
    }

}