package com.grupo4.todolist.api.Domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.grupo4.todolist.api.Domain.DAOs.TaskDAO;
import com.grupo4.todolist.api.Domain.Entities.Task;
import com.grupo4.todolist.api.Domain.Repositories.TaskRepo;

public class TaskModel {
    private final TaskRepo taskRepo;

    public TaskModel() {
        this.taskRepo = new TaskRepo();
    }

    public List<Task> listTasks(){
        return taskRepo.askTask();
    }
    public  int addTask(Task task){
        int cont = -1; 
        cont = taskRepo.addTask(task);
        return cont;
    }
    public  int editTask(Task task){
        int cont = -1; 
        cont = taskRepo.edit(task);
        return cont;
    }
    public  int deleteTask(Task task){
        int cont = -1; 
        cont = taskRepo.delete(task);
        return cont;
    }
    public  int moveTask(Task task){
        int cont = -1; 
        cont = taskRepo.move(task);
        return cont;
    }
}
