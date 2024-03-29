package com.example.todo.model;

public class Todo {
    private int id;
    private String todo;
    private String status;
    private String priority;

    public Todo(int id, String todo, String status, String priority) {
        this.todo = todo;
        this.status = status;
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}