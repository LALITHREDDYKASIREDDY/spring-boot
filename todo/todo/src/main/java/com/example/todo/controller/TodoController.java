package com.example.todo.controller;

import com.example.todo.service.TodoH2Service;
import com.example.todo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
public class TodoController {
    @Autowired
    private TodoH2Service s;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        System.out.println("sdk");
        return s.getTodos();
    }

    @GetMapping("/todos/{id}")

    public Todo getTodoById(@PathVariable("id") int id) {
        return s.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return s.createTodo(todo);
    }

    @PutMapping("/todos/{id}")

    public Todo updateTodo(@RequestBody Todo todo, @PathVariable("id") int id) {
        return s.updateTodo(todo, id);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        s.deleteTodo(id);
    }
}
