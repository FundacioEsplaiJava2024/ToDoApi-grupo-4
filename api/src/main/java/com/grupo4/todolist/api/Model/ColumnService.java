package com.grupo4.todolist.api.Model;

import java.util.Optional;

import com.grupo4.todolist.api.Model.Entities.Columnas;

public interface ColumnService {
    public Iterable<Columnas> findAll();

    public Optional<Columnas> findById(Long id);

    public Columnas save(Columnas columna);

    public void deletebyId(Long id);
}
