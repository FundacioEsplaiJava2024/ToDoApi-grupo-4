package com.grupo4.todolist.api.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;

    private String project_name;

    private long user_ID;


    public Project() {}

    public Project(long project_id, String project_name, long user_ID) {
        this.project_id =  project_id;
        this.project_name = project_name;
        this.user_ID = user_ID;
    }

    public String getName() {
        return project_name;
    }
    public long getIDProject() {
        return project_id;
    }
    public long getIDUser() {
        return user_ID;
    }
    
    public void setName(String project_name) {
        this.project_name = project_name;
    }    
    public void setIDProject(long project_id) {
        this.project_id = project_id;
    }    
    public void setIDUser(long user_ID) {
        this.user_ID = user_ID;
    }
}
