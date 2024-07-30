package com.grupo4.todolist.api.Domain.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo4.todolist.api.Domain.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserNameAndUserPassword(String userName, String userPassword);
}
