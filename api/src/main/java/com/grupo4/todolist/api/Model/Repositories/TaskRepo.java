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

	public  int addTask(Task task) {
		int cont = taskDAO.insert(task);
        return cont;
	}
    public  int edit(String id, Task task) {
		int cont = taskDAO.edit(id, task);
        return cont;
	}
    public  int delete(String id) {
		int cont = taskDAO.delete(id);
        return cont;
	}
    public  int move(String id, Task task) {
		int cont = taskDAO.move(id, task);
        return cont;
	}
}