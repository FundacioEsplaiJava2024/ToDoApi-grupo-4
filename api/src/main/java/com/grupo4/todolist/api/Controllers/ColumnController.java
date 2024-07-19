package com.grupo4.todolist.api.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.todolist.api.Model.Entities.Columnas;
import com.grupo4.todolist.api.Model.Entities.Task;
import com.grupo4.todolist.api.Model.Services.ColumnService;

@RestController
@RequestMapping("/api/Columnas")
public class ColumnController {

    @Autowired
    private ColumnService serviceColumn;
    //Crear una nueva columna
    @PostMapping
    public ResponseEntity<Columnas> create(@RequestBody Columnas columna) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceColumn.save(columna));
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
        //Cambiar nombre de la columna
        @PutMapping("edit/{id}")
        public ResponseEntity<Columnas> update(@RequestBody Columnas nombreCol,@PathVariable Long id){
            Optional<Columnas> columna = serviceColumn.findById(id);
            if(!columna.isPresent()){//si no se encuentra la columna devuelve el codigo 404
                return ResponseEntity.notFound().build();
            }
            columna.get().setNombre(nombreCol.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(serviceColumn.save(nombreCol));
        }
        
        //Eliminar columna
        @DeleteMapping("del/{id}")
        public ResponseEntity<Columnas> delete(@PathVariable Long id){
            if(!serviceColumn.findById(id).isPresent()){//si no se encuentra la columna devuelve el codigo 404
                return ResponseEntity.notFound().build();
            }
            serviceColumn.deletebyId(id);
            return ResponseEntity.ok().build();
        }
        
            @Autowired
            private ColumnService columnService;
        
            @PostMapping("/{id}/tasks")
            public ResponseEntity<Task> addTaskToColumn(@PathVariable Long id, @RequestBody Task task) {
                // Obtener la columna por su ID
                Optional<Columnas> optionalColumna = columnService.findById(id);
        
                if (!optionalColumna.isPresent()) {
                    return ResponseEntity.notFound().build();
                }
        
                // Asignar la tarea a la columna
                Columnas columna = optionalColumna.get();
                task.setSourceColumn(columna.getNombre()); // Establecer la columna de origen para la tarea
                columna.getListaTareasColumnas().add(task); // Añadir la tarea a la lista de la columna
        
                // Guardar la columna actualizada (con la nueva tarea)
                columnService.save(columna);
        
                return ResponseEntity.status(HttpStatus.CREATED).body(task);
            }
        
            // Otros métodos del controlador para leer y manejar las tareas...
        }
        



