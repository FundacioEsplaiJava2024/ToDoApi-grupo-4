package com.grupo4.todolist.api.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupo4.todolist.api.Domain.TaskModel;
import com.grupo4.todolist.api.Domain.UserModel;
import com.grupo4.todolist.api.Domain.Entities.Task;
import com.grupo4.todolist.api.Domain.Entities.User;
import com.grupo4.todolist.api.Requests.UserRegisterRequest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("/TodolistG4/user")
public class UserController {
    private static UserModel model = new UserModel(); //sus

    @PostMapping("/add")
	public String addUser(@RequestBody UserRegisterRequest request) {
		String response;

		int cont = model.addUser(request.username(),request.password());
		
		if (cont == 1){
			response = "User agregada correctamente";
		}else if(cont == 0){
			response = "Error al agregar tarea";
		}else{
			response = "Error al enviar tarea";
		}

		return response;

	}
    @GetMapping("/login")
    public Long login(@RequestBody UserRegisterRequest request) {
        User u = model.getUserById(request.username(),request.password());
        Long id = u.getID();
        return id;
    }
    
}
