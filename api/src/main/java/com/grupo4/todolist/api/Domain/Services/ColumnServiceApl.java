package com.grupo4.todolist.api.Domain.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo4.todolist.api.Domain.Entities.Column;
import com.grupo4.todolist.api.Domain.Repositories.RepositoryColumn;
@Service//Obligatorio para indicar que es un servicio
public class ColumnServiceApl implements ColumnService {
   @Autowired
   public RepositoryColumn repositoryColumn;
   @Transactional(readOnly = true)//esto significa que solo puede leer no puede añadir cosas a la base de datos
   @Override
   public Iterable<Column> findAll(){
      return repositoryColumn.findAll();
   }
   @Transactional(readOnly = true)
   @Override
   public Optional<Column> findById(Long id){
      return repositoryColumn.findById(id);
   }
   @Transactional// para indicar que si hará cambios en nuestra base de datos
   @Override
   public Column save(Column column_todo){
      return repositoryColumn.save(column_todo);
   }
   @Transactional
   @Override
   public void deletebyId(Long id){
      repositoryColumn.deleteById(id);
   }
}