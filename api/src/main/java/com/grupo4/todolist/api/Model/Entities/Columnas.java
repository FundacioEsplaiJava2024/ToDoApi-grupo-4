package com.grupo4.todolist.api.Model.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Columnas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombre;

    @OneToMany
    private List<Tasks> listaTareasColumnas;

    // Constructor por defecto
    public Columnas() {}

    public Columnas(long id, String nombre, List<Tasks> listaTareasColumnas) {
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

    public List<Tasks> getListaTareasColumnas() {
        return listaTareasColumnas;
    }

    public void setListaTareasColumnas(List<Tasks> listaTareasColumnas) {
        this.listaTareasColumnas = listaTareasColumnas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(long id) {
        this.id = id;
    }
}
