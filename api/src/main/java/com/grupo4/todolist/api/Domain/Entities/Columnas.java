package com.grupo4.todolist.api.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Columnas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long column_id;
    
    private String column_name;
   
    private long project_id;

    // Constructor por defecto
    public Columnas() {}

    public Columnas(long column_id, String column_name, long project_id) {
        this.column_id = column_id;
        this.column_name = column_name;
        this.project_id = project_id;
    }

    public String getNameColumn() {
        return column_name;
    }

    public long getIDColumn() {
        return column_id;
    }

    public long getIDProject() {
        return project_id;
    }

    public void setNameColumn(String column_name) {
        this.column_name = column_name;
    }

    public void setIDColumn(long column_id) {
        this.column_id = column_id;
    }
}
