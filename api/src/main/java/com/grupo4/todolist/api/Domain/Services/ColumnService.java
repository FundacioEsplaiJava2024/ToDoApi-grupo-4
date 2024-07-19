package com.grupo4.todolist.api.Domain.Services;

import java.util.Optional;

import com.grupo4.todolist.api.Domain.Entities.column_todo;

public interface ColumnService {
    public Iterable<column_todo> findAll();

    public Optional<column_todo> findById(Long id);

    public column_todo save(column_todo column_todo);

    public void deletebyId(Long id);
}
