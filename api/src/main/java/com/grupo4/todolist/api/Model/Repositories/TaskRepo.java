package com.grupo4.todolist.api.Model.Repositories;


import java.util.List;

import com.grupo4.todolist.api.Model.DAOs.TaskDAO;
import com.grupo4.todolist.api.Model.Entities.Task;

public class TaskRepo {
    private final TaskDAO taskDAO;

    public TaskRepo() {
        this.taskDAO = new TaskDAO();
    }

    public List<Task> askTask(){
        return taskDAO.getTasks();
    }

	public static int addTask(Task task) {
		int cont = TaskDAO.insert(task);
        return cont;
	}
}