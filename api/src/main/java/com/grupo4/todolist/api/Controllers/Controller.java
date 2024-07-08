package com.grupo4.todolist.api.Controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.grupo4.todolist.api.Model.Greeting;
import com.grupo4.todolist.api.Model.TaskModel;
import com.grupo4.todolist.api.Model.Entities.Task;
import com.grupo4.todolist.api.Model.Repositories.TaskRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller {
	private static TaskModel model = new TaskModel(); //sus
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	

	public Controller() {
		this.model = model; //sus
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/TodolistG4/tasks")//TODO: añadir paginación
	public static List<Task> listTasks() {
		
		return model.listTasks();
	}

	@PostMapping("/TodolistG4/tasks/add")
	public String addTask(@RequestBody Task entity) {
		String response;

		int cont = TaskModel.addTask(entity);
		
		if (cont == 1) {
			response = "Tarea agregada correctamente";
		}else if(cont == 0){
			response = "Error al agregar tarea";
		}else{
			response = "Error al enviar tarea";
		}

		return response;

	}
	@PostMapping("/TodolistG4/tasks/{id}/edit")
	public String editTask(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	
	@DeleteMapping("/TodolistG4/tasks/{id}/delete")
	public String deleteTask(@RequestBody String entity){

		return entity;
	}

	@PostMapping("/TodolistG4/tasks/{id}/move")
	public String moveTask(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	
}
