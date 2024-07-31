package com.grupo4.todolist.api.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.todolist.api.Domain.DAOs.UserDAO;
import com.grupo4.todolist.api.Domain.Entities.User;

public class UserRepository {
    private final UserDAO userDAO;

    public UserRepository(){
        this.userDAO = new UserDAO();
    }
    public int addUser(String username, String password) {
        int cont = userDAO.insert(username,password);
        return cont;
    }

    public long getUserId(String username, String password) {
       long u = userDAO.getUser(username, password);
       return u;
    }
    
}
