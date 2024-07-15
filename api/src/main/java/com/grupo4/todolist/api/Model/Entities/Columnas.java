package com.grupo4.todolist.api.Model.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Columnas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombre;

    @OneToMany
    private List<Task> listaTareasColumnas;

    // Constructor por defecto
    public Columnas() {}

    public Columnas(long id, String nombre, List<Task> listaTareasColumnas) {
        this.id = id;
        this.nombre = nombre;
        this.listaTareasColumnas = listaTareasColumnas;
    }

    public String getNombre() {
        return nombre;
    }

    public long getId() {
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

    public void setId(long id) {
        this.id = id;
    }
}
