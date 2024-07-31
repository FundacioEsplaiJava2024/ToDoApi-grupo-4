package com.grupo4.todolist.api.Domain;

import com.grupo4.todolist.api.Domain.Entities.User;
import com.grupo4.todolist.api.Domain.Repositories.UserRepository;

public class UserModel {
    private final UserRepository userRepo;

    public UserModel() {
        this.userRepo = new UserRepository();
    }
    public int addUser(String username, String password){
        int cont = -1; 
        cont = userRepo.addUser(username, password);
        return cont;
    }
    public long getUserById(String username, String password){
        long u = -1;
        return u = userRepo.getUserId(username, password);
    }

    
}
