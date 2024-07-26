package com.grupo4.todolist.api.Domain.Services;

import java.util.List;
import java.util.Optional;

import com.grupo4.todolist.api.Domain.Entities.Column;

public interface ColumnService {
    public List<Column> findAll();

    public Optional<Column> findById(String id);

    public Column save(Column column_todo);

    public void deletebyId(String id);
    
    public List<Column> findColumnsByProject(String id);
}
