package com.bismark.taskmanager.service;

import com.bismark.taskmanager.model.Task;
import com.bismark.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public Task getTask(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = repo.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            return repo.save(task);
        }
        return null;
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}