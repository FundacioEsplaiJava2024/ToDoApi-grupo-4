package com.grupo4.todolist.api.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.todolist.api.Domain.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
