package com.grupo4.todolist.api.Domain.Services;

import java.util.Optional;

import com.grupo4.todolist.api.Domain.Entities.Column;

public interface ColumnService {
    public Iterable<Column> findAll();

    public Optional<Column> findById(Long id);

    public Column save(Column column_todo);

    public void deletebyId(Long id);
}
