package com.grupo4.todolist.api.Domain.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.todolist.api.Domain.Entities.User;
import com.grupo4.todolist.api.Domain.Repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long user_ID) {
        return userRepository.findById(user_ID);
    }

    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setUserID(id);
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Long user_ID) {
        if (userRepository.existsById(user_ID)) {
            userRepository.deleteById(user_ID);
            return true;
        }
        return false;
    }

    public User authenticateUser(String userName, String userPassword) {
        List<User> users = userRepository.findByUserNameAndUserPassword(userName, userPassword);
        return users.isEmpty() ? null : users.get(0);
    }
}
