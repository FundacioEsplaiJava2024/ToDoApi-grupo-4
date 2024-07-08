package com.grupo4.todolist.api.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.grupo4.todolist.api.Model.Entities.Columnas;

import com.grupo4.todolist.api.Model.Entities.Tasks;

public class RepositoryColumn {
    private List<Columnas> columnasList = new ArrayList<>();
    
    public List<Tasks> addTask(int id, String name) {
        List<Tasks> listaTareasColumnas = new ArrayList<>();

        Tasks task1 = new Tasks(1, "Task 1");
        Tasks task2 = new Tasks(2, "Task 2");
        Tasks task3 = new Tasks(3, "Task 3");

        listaTareasColumnas.add(task1);
        listaTareasColumnas.add(task2);
        listaTareasColumnas.add(task3);

        return listaTareasColumnas;
    }
        
        public List<Tasks> listarTareasColumna(int id) {
        Optional<Columnas> columnaOptional = columnasList.stream().filter(c -> c.getId() == id).findFirst();
        if (columnaOptional.isPresent()) {
            Columnas columna = columnaOptional.get();
            return columna.getListaTareasColumnas();
        }
        return new ArrayList<>(); // Devolver una lista vacía si no se encuentra la columna
    
    }
    }

    public Columnas addColumn(int id, String nombre) {
        List<Columnas> columnasList = new ArrayList<>();
        Columnas c1= new Columnas(1, "col1", null);
    }

    @Override
    public Columnas editColumn(int id, String nuevoNombre) {
        for (Columnas c : columnasList) {
            if (c.getId() == id) {
                c.setNombre(nuevoNombre);
                return c;
            }
        }
        return null;
    }

    @Override
    public Columnas delColumn(int id) {
        Optional<Columnas> columna = columnasList.stream().filter(c -> c.getId() == id).findFirst();
        if (columna.isPresent()) {
            columnasList.remove(columna.get());
            return columna.get();
        }
        return null;
    }
}