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

	public  int addTask(Task task) {
		int cont = taskDAO.insert(task);
        return cont;
	}
    public  int edit(Task task) {
		int cont = taskDAO.edit(task);
        return cont;
	}
    public  int delete(Task task) {
		int cont = taskDAO.delete(task);
        return cont;
	}
    public  int move(Task task) {
		int cont = taskDAO.move(task);
        return cont;
	}
}