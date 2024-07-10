package com.grupo4.todolist.api.Domain.Repositories;


import java.util.List;

import com.grupo4.todolist.api.Domain.DAOs.TaskDAO;
import com.grupo4.todolist.api.Domain.Entities.Task;

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