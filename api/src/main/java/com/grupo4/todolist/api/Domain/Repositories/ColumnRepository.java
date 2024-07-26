package com.grupo4.todolist.api.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo4.todolist.api.Domain.Entities.Column;


@Repository
public interface ColumnRepository extends JpaRepository<Column, Long> {

}
