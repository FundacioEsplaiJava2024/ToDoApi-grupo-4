package com.grupo4.todolist.api.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String taskId;

    private String taskName;

    private String sourceColumn;
    @ManyToOne // Relación muchos a uno con Columnas
    @JoinColumn(name = "columna_id")
    private Columnas columna;
    // Constructor por defecto
    public Task() {}

    public Task(String taskId, String taskName,String sourceColumn, Columnas columna) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.sourceColumn = sourceColumn;
        this.columna= columna;
        
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskId(String taskId) {
        this.taskId= taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getSourceColumn() {
        return sourceColumn;
    }

    public void setSourceColumn(String sourceColumn) {
        this.sourceColumn = sourceColumn;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (taskId == null) {
            if (other.taskId != null)
                return false;
        } else if (!taskId.equals(other.taskId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", sourceColumn=" + sourceColumn + "]";
    }

    public Columnas getColumna() {
        return columna;
    }

    public void setColumna(Columnas columna) {
        this.columna = columna;
    }

}
