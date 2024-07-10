package com.grupo4.todolist.api.Model;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.grupo4.todolist.api.Model.Entities.Columnas;

public interface ServiceColumn {
    public Iterable<Columnas> findAll();

    public Optional<Columnas> findById(Long id);

    public Columnas guardarColumnas(Columnas columna);

    public void deletebyId(Long id);
}
