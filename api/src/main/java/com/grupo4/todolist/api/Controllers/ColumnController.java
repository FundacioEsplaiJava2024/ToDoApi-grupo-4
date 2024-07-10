package com.grupo4.todolist.api.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.todolist.api.Model.Entities.Columnas;
import com.grupo4.todolist.api.Model.ServiceColumn;

@RestController
@RequestMapping("/api/Columnas")
public class ColumnController {

    @Autowired
    private ServiceColumn serviceColumn;
    //Crear una nueva columna
    @PostMapping
    public ResponseEntity<Columnas> create(@RequestBody Columnas columna) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceColumn.guardarColumnas(columna));
    }
    //Leer una columna
    @GetMapping("{id}")
        public ResponseEntity<Optional<Columnas>> leerCol (@PathVariable Long id){
            Optional<Columnas> oCol= serviceColumn.findById(id);

            if(!oCol.isPresent()){//si no se encuentra la columna devuelve el codigo 404
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(oCol);//metodo de todo ha ido bien y devuelve la columna
        }
}
