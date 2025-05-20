package com.todobackend.todo_backend.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.todobackend.todo_backend.exception.TaskNotFoundException;
import com.todobackend.todo_backend.model.Task;
import com.todobackend.todo_backend.repository.TaskRepository;
import com.todobackend.todo_backend.service.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(String id, Task updatedTask) {
        Task existing = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        existing.setName(updatedTask.getName());
        existing.setCompleted(updatedTask.isCompleted()); 
        return taskRepository.save(existing);
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> searchTasks(String keyword) {
        return taskRepository.findByNameContainingIgnoreCase(keyword);
    }
}