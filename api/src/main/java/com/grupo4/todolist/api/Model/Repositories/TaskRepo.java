package com.grupo4.todolist.api.Model.Repositories;


import java.util.List;

import com.grupo4.todolist.api.Model.DAOs.TaskDAO;
import com.grupo4.todolist.api.Model.Entities.Task;

public class TaskRepo {
    public static List<Task> askTask(){
        return TaskDAO.getTasks();
    }

	public static int addTask(Task task) {
		int cont = TaskDAO.insert(task);
        return cont;
	}
}