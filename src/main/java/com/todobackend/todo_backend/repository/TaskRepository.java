package com.todobackend.todo_backend.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.todobackend.todo_backend.model.Task;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByNameContainingIgnoreCase(String name);
}