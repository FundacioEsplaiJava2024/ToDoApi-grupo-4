package com.grupo4.todolist.api.Controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.grupo4.todolist.api.Domain.Greeting;
import com.grupo4.todolist.api.Domain.TaskServices;
import com.grupo4.todolist.api.Domain.Entities.Task;
import com.grupo4.todolist.api.Domain.Repositories.TaskRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller {
	private static TaskServices model = new TaskServices(); //sus
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
}
