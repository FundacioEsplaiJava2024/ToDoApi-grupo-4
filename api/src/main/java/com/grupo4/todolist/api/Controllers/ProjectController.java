package com.grupo4.todolist.api.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.grupo4.todolist.api.Domain.ProjectService;
import com.grupo4.todolist.api.Domain.Entities.Project;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService ProjectService;

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return ProjectService.createProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return ProjectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return ProjectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        return ProjectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        ProjectService.deleteProject(id);
    }

    @PutMapping("/user/{id}")
    public Project updateUserProject(@PathVariable Long id, @RequestBody Project project) {
        return ProjectService.updateUserProject(id, project);
    }
}
