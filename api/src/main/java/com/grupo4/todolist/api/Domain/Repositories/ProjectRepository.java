package com.grupo4.todolist.api.Domain.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo4.todolist.api.Domain.Entities.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {
    @Query(value = "SELECT p from Project p where p.user_ID = ?1")
    List<Project> getProjectsByUserId(Long id);
}
