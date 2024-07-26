package com.grupo4.todolist.api.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo4.todolist.api.Domain.Entities.Column;
import com.grupo4.todolist.api.Domain.Services.ColumnService;

@RestController
@CrossOrigin
@RequestMapping("/TodolistG4/columns")
public class ColumnController {

    @Autowired
    private ColumnService serviceColumn;

    @GetMapping
    public List<Column> getColumns() {
        return serviceColumn.findAll();
    }
    //Leer una columna
    @GetMapping("{id}")
        public ResponseEntity<Optional<Column>> leerCol (@PathVariable String id){
            Optional<Column> oCol= serviceColumn.findById(id);

            if(oCol.isEmpty()){//si no se encuentra la columna devuelve el codigo 404
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(oCol);//metodo de todo ha ido bien y devuelve la columna
        }
        //Cambiar nombre de la columna
        @PutMapping("edit/{id}")
        public ResponseEntity<Column> update(@RequestBody Column nombreCol,@PathVariable String id){
            Optional<Column> column_todo = serviceColumn.findById(id);
            if(column_todo.isEmpty()){//si no se encuentra la columna devuelve el codigo 404
                return ResponseEntity.notFound().build();
            }
            column_todo.get().setNameColumn(nombreCol.getNameColumn());
            return ResponseEntity.status(HttpStatus.CREATED).body(serviceColumn.save(nombreCol));
        }
        
        //Eliminar columna
        @DeleteMapping("del/{id}")
        public ResponseEntity<Column> delete(@PathVariable String id){
            if(serviceColumn.findById(id).isEmpty()){//si no se encuentra la columna devuelve el codigo 404
                return ResponseEntity.notFound().build();
            }
            serviceColumn.deletebyId(id);
            return ResponseEntity.ok().build();
        }
        
    }
        



