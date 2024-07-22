package com.grupo4.todolist.api.Controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.todolist.api.Domain.Greeting;
import com.grupo4.todolist.api.Domain.TaskModel;
import com.grupo4.todolist.api.Domain.Entities.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



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
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/TodolistG4/tasks")//TODO: añadir paginación
	public static List<Task> listTasks() {
		
		return model.listTasks();
	}

	@RequestMapping(value="path", method=RequestMethod.GET)
	public String requestMethodName(@RequestParam String param) {
		return new String();
	}
	
	@PostMapping("/TodolistG4/tasks/add")
	public String addTask(@RequestBody Task t) {
		String response;
		Task task = new Task(t.getTaskId(), t.getTaskName(), t.getSourceColumn());
		System.out.println(task);
		int cont = model.addTask(task);
		
		if (cont == 1){
			response = "Tarea agregada correctamente";
		}else if(cont == 0){
			response = "Error al agregar tarea";
		}else{
			response = "Error al enviar tarea";
		}

		return response;

	}
	@PostMapping("/TodolistG4/tasks/{id}/edit")
	public String editTask(@PathVariable ("id") String id, @RequestBody Task entity) {
		String response;

		int cont = model.editTask(entity);

		if (cont == 1) {
			response = "Tarea editada correctamente";
		}else if(cont == 0){
			response = "Error al editar tarea";
		}else{
			response = "No se pudo editar la tarea";
		}
		
		return response;
	}
	
	@DeleteMapping("/TodolistG4/tasks/{id}/delete")
	public String deleteTask(@PathVariable("id")String id, @RequestBody Task task){
		String response;

		int cont = model.deleteTask(task);
		
		if (cont == 1) {
			response = "Tarea eliminada correctamente";
		}else if(cont == 0){
			response = "Error al eliminar tarea";
		}else{
			response = "No se pudo eliminar la tarea";
		}
		return response;
	}

	@PostMapping("/TodolistG4/tasks/{id}/move")
	public String moveTask(@PathVariable ("id")String id ,@RequestBody Task entity) {
		String response;
		
		int cont = model.moveTask(entity);
		if (cont == 1) {
			response = "Tarea movida correctamente";
		}else if(cont == 0){
			response = "Error al mover la tarea";
		}else{
			response = "no se pudo movertarea";
		}
		
		return response;
	}
	
}
