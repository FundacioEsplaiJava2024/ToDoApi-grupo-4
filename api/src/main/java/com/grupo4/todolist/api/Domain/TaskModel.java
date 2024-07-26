package com.grupo4.todolist.api.Domain;

import java.util.List;

import com.grupo4.todolist.api.Domain.Entities.Task;
import com.grupo4.todolist.api.Domain.Repositories.TaskRepository;

public class TaskModel {
    private final TaskRepository taskRepo;

    public TaskModel() {
        this.taskRepo = new TaskRepository();
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
