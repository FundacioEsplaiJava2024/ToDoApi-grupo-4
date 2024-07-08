package com.grupo4.todolist.api.Model.Entities;

import java.util.List;

public interface ServiceColumn {
   public List<Tasks> listaTareasColumnas();
   //public Columnas addColumn(int id, String nombre);
   public Columnas delColumn(int id);
   public Columnas editColumn(int id, String nuevoNombre);
   //public Tasks addTask(int id, Task task);
   
}