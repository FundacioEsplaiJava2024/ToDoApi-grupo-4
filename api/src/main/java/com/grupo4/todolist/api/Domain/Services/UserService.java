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

    public User createUser (User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
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
