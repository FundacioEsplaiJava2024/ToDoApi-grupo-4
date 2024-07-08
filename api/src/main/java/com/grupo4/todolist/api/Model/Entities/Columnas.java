package com.grupo4.todolist.api.Model.Entities;

import java.util.List;

public class Columnas {
    private String nombre;
    private int id;
    private List<Task> listaTareasColumnas;

    public Columnas(int id, String nombre, List<Task> listaTareasColumnas) {
        this.id = id;
        this.nombre = nombre;
        this.listaTareasColumnas = listaTareasColumnas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public List<Task> getListaTareasColumnas() {
        return listaTareasColumnas;
    }

    public void setListaTareasColumnas(List<Task> listaTareasColumnas) {
        this.listaTareasColumnas = listaTareasColumnas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
}

