package com.example.todo.repository;

import com.example.todo.model.Todo;
import java.util.*;

public interface TodoRepository {
    ArrayList<Todo> getTodos();

    Todo getTodoById(int id);

    Todo createTodo(Todo todo);

    Todo updateTodo(Todo todo, int id);

    void deleteTodo(int id);
}