package com.example.todo.service;

import java.util.*;
import com.example.todo.repository.TodoRepository;
import com.example.todo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoH2Service implements TodoRepository {
  @Autowired
  private JdbcTemplate db;

  @Override
  public ArrayList<Todo> getTodos() {
    List<Todo> todoList = db.query("select * from todolist", new TodoRowMapper());
    return new ArrayList<>(todoList);
  }

  @Override
  public Todo getTodoById(int id) {
    try {
      Todo todo = db.queryForObject("select * from todolist where id=?", new TodoRowMapper(), id);
      return todo;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Todo createTodo(Todo todo) {
    db.update("insert into todolist (todo,status,priority) values (?,?,?)",
        todo.getTodo(), todo.getStatus(), todo.getPriority());

    return db.queryForObject("select * from todolist where todo=? and status=? and priority=?",
        new TodoRowMapper(), todo.getTodo(), todo.getStatus(), todo.getPriority());
  }

  @Override
  public Todo updateTodo(Todo todo, int id) {
    Todo original = db.queryForObject("select * from todolist where id=?", new TodoRowMapper(), id);
    if (original == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    if (todo.getTodo() != null) {
      db.update("update todolist set todo=?", todo.getTodo());

    }
    if (todo.getStatus() != null) {
      db.update("update todolist set status=?", todo.getStatus());

    }
    if (todo.getPriority() != null) {
      db.update("update todolist set priority=?", todo.getPriority());

    }
    return db.queryForObject("select * from todolist where id=?", new TodoRowMapper(), id);
  }
   @Override
  public void deleteTodo(int id) {
    Todo original = db.queryForObject("select * from todolist where id=?", new TodoRowMapper(), id);
    if (original == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    db.update("delete from todolist where id=?", id);
  }

}
