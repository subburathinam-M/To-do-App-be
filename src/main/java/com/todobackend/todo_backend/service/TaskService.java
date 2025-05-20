package com.todobackend.todo_backend.service;

import java.util.List;

import com.todobackend.todo_backend.model.Task;

public interface TaskService {
    Task addTask(Task task);
    Task updateTask(String id, Task task);
    void deleteTask(String id);
    List<Task> getAllTasks();
    List<Task> searchTasks(String keyword);
}