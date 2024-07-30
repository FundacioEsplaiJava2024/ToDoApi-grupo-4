package com.grupo4.todolist.api.Domain.Repositories;


import java.util.List;

import com.grupo4.todolist.api.Domain.DAOs.TaskDAO;
import com.grupo4.todolist.api.Domain.Entities.Task;

public class TaskRepository {
    private final TaskDAO taskDAO;

    public TaskRepository() {
        this.taskDAO = new TaskDAO();
    }

    public List<Task> askTask(){
        return taskDAO.getTasks();
    }

	public  int addTask(Task task) {
		int cont = taskDAO.insert(task);
        return cont;
	}
    public  int edit(String id, String newName) {
		int cont = taskDAO.edit(id, newName);
        return cont;
	}
    public  int delete(String id) {
		int cont = taskDAO.delete(id);
        return cont;
	}
    public  int move(Task task) {
		int cont = taskDAO.move(task);
        return cont;
	}

    public List<Task> askTasksByColumn(String id) {
        return taskDAO.getTasksByColumnId(id);
    }
    
}