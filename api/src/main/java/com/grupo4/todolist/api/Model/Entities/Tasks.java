package com.grupo4.todolist.api.Model.Entities;

public class Tasks {
    private int taskid;
    private String nombre;
    

    public Tasks(int taskid, String nombre) {
        this.taskid = taskid;
        this.nombre = nombre;
        
    }

    public int gettaskId() {
        return taskid;
    }

    public void setId(int taskid) {
        this.taskid = taskid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
