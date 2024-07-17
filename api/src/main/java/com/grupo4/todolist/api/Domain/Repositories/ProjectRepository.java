package com.grupo4.todolist.api.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.todolist.api.Domain.Entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
