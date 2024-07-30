package com.grupo4.todolist.api.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.todolist.api.Domain.UserModel;
import com.grupo4.todolist.api.Domain.Entities.User;
import com.grupo4.todolist.api.Requests.UserRegisterRequest;


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
			response = "User agregado correctamente";
		}else if(cont == 0){
			response = "Error al agregar user";
		}else{
			response = "Error al enviar user";
		}

		return response;

	}
    @GetMapping("/login")
    public long login(@RequestBody UserRegisterRequest request) {
        long id = model.getUserById(request.username(),request.password());
        return id;
    }
    
}
