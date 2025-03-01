package com.grupo4.todolist.api.Domain.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo4.todolist.api.Domain.Entities.Project;
import com.grupo4.todolist.api.Domain.Repositories.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
    public List<Project> getProjectsByUserId(Long userId) {
        return projectRepository.getProjectsByUserId(userId);
    }

    public Project updateProject(String project_id, Project project) {
        project.setIDProject(project_id);
        return projectRepository.save(project);
    }

    public void deleteProject(String project_id) {
        projectRepository.deleteById(project_id);
    }

}
