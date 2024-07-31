package com.grupo4.todolist.api.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupo4.todolist.api.Domain.Entities.Project;
import com.grupo4.todolist.api.Domain.Services.ProjectService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/TodolistG4/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping("/list")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public List<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectsByUserId(id);
    }

    @PostMapping("/update/{id}")
    public Project updateProject(@PathVariable String id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }

}
