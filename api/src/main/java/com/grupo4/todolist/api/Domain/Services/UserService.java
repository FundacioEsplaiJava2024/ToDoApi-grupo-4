package com.grupo4.todolist.api.Domain.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.todolist.api.Domain.Entities.User;
import com.grupo4.todolist.api.Domain.Repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    //nuevo para verificar si el usuario ya existe. mirar lo del email, marca error debido a que todavia no esta configurado...
    //configure userRepertori para lo del mail, solucionado :3
    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long user_ID) {
        return userRepository.findById(user_ID).orElse(null);
    }

    public User updateUser(Long id, User user) {
        user.setID(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long user_ID) {
        userRepository.deleteById(user_ID);
    }
}
