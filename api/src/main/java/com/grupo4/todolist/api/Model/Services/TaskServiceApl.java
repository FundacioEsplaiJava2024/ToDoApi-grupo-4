package com.grupo4.todolist.api.Model.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.todolist.api.Model.Entities.Task;
import com.grupo4.todolist.api.Model.Repositories.RepositoryTask;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class TaskServiceApl {
     @Autowired
    private RepositoryTask taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
