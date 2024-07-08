package com.grupo4.todolist.api.Model;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.grupo4.todolist.api.Model.Entities.Task;
import com.grupo4.todolist.api.Model.Repositories.TaskRepo;

public class TaskModel {
    public static Gson listTasks(){
        ArrayList<Task> taskList = new ArrayList<Task>();
        Gson data = new Gson();
        data.toJson(taskList);
        return data;
    }
    public static int addTask(Task task){
        int cont = -1; 
        cont = TaskRepo.addTask(task);
        return cont;
    }
}
