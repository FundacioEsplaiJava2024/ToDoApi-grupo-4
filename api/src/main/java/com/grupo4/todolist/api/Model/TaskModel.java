package com.grupo4.todolist.api.Model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.grupo4.todolist.api.Model.DAOs.TaskDAO;
import com.grupo4.todolist.api.Model.Entities.Task;
import com.grupo4.todolist.api.Model.Repositories.TaskRepo;

public class TaskModel {
    private final TaskRepo taskRepo;

    public TaskModel() {
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
