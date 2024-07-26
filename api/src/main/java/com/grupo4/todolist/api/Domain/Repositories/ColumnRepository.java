package com.grupo4.todolist.api.Domain.Repositories;

import java.util.List;

import com.grupo4.todolist.api.Domain.DAOs.ColumnDAO;
import com.grupo4.todolist.api.Domain.Entities.Column;

public class ColumnRepository {
        private final ColumnDAO columnDAO;

    public ColumnRepository() {
        this.columnDAO = new ColumnDAO();
    }

    public List<Column> askColumn(){
        return columnDAO.getColumn();
    }
}
