package com.grupo4.todolist.api.Domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.grupo4.todolist.api.Domain.DAOs.TaskDAO;
import com.grupo4.todolist.api.Domain.Entities.Task;
import com.grupo4.todolist.api.Domain.Repositories.TaskRepo;

public class TaskServices {
    private final TaskRepo taskRepo;

    public TaskServices() {
        this.taskRepo = new TaskRepo();
    }

    public List<Task> listTasks(){
        return taskRepo.askTask();
    }
    public static int addTask(Task task){
        int cont = -1; 
        cont = TaskRepo.addTask(task);
        return cont;
    }
}
