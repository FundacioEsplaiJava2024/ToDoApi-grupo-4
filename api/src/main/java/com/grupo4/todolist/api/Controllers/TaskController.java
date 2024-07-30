package com.grupo4.todolist.api.Controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import com.grupo4.todolist.api.Domain.Greeting;
import com.grupo4.todolist.api.Domain.TaskModel;
import com.grupo4.todolist.api.Domain.Entities.Task;
import com.grupo4.todolist.api.Requests.TaskEditRequest;
import com.grupo4.todolist.api.Requests.TaskMoveRequest;



@RestController
@CrossOrigin
@RequestMapping("/TodolistG4")
public class TaskController {
	private static TaskModel model = new TaskModel(); //sus
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


	public TaskController() {
		this.model = model; //sus ඞ
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/tasks")
	public static List<Task> listTasks() {
		
		return model.listTasks();
	}
	@GetMapping("/tasks/column/{id}")//TODO: añadir paginación
	public static List<Task> listTasksByCol(@PathVariable ("id") String id) {
		
		return model.listTasksByColumn(id);
	}

	@PostMapping("/tasks/add")
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
	@PostMapping("/tasks/{id}/edit")
	public String editTask(@PathVariable ("id") String id, @RequestBody TaskEditRequest request) {
		String response;
		int cont = model.editTask(id, request.newName());
		
		if (cont == 1) {
			response = "Tarea editada correctamente";
		}else if(cont == 0){
			response = "Error al editar tarea";
		}else{
			response = "No se pudo editar la tarea";
		}
		
		return response;
	}
	
	@DeleteMapping("/tasks/{id}/delete")
	public String deleteTask(@PathVariable("id")String id){
		String response;

		int cont = model.deleteTask(id);
		
		if (cont == 1) {
			response = "Tarea eliminada correctamente";
		}else if(cont == 0){
			response = "Error al eliminar tarea";
		}else{
			response = "No se pudo eliminar la tarea";
		}
		return response;
	}

	@PostMapping("/tasks/{id}/move")
	public String moveTask(@PathVariable ("id")String id ,@RequestBody TaskMoveRequest entity) {
		String response;
		
		int cont = model.moveTask(id, entity.newColumn());
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
