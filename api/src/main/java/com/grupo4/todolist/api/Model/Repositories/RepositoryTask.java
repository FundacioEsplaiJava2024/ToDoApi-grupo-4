package com.grupo4.todolist.api.Model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo4.todolist.api.Model.Entities.Task;

@Repository
public interface RepositoryTask extends JpaRepository<Task, String> {

}