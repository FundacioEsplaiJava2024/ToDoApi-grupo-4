package com.grupo4.todolist.api.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="column_todo")
public class Column {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String column_id;
    
    private String column_name;
   
    private String project_id;

    // Constructor por defecto
    public Column() {}

    public Column(String column_id, String column_name, String project_id) {
        this.column_id = column_id;
        this.column_name = column_name;
        this.project_id = project_id;
    }

    public String getNameColumn() {
        return column_name;
    }

    public String getIDColumn() {
        return column_id;
    }

    public String getIDProject() {
        return project_id;
    }

    public void setNameColumn(String column_name) {
        this.column_name = column_name;
    }

    public void setIDColumn(String column_id) {
        this.column_id = column_id;
    }

    public void setIDProject(String project_id) {
        this.project_id = project_id;
    }
}
