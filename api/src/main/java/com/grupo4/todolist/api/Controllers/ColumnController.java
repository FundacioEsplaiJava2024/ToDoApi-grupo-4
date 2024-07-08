package com.grupo4.todolist.api.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.todolist.api.Model.Entities.Columnas;

@RestController
public class ColumnController{

    @PostMapping("/add")
    public Columnas addColumna(@RequestBody Columnas entity) {
        // Aquí procesas la solicitud POST
        // Por ejemplo, podrías guardar la columna en una base de datos
        return entity;
    }
}
