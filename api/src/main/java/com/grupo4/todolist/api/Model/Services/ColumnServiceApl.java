package com.grupo4.todolist.api.Model.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo4.todolist.api.Domain.Entities.Columnas;
import com.grupo4.todolist.api.Model.Repositories.RepositoryColumn;
@Service//Obligatorio para indicar que es un servicio
public class ColumnServiceApl implements ColumnService {
   @Autowired
   public RepositoryColumn repositoryColumn;
   @Transactional(readOnly = true)//esto significa que solo puede leer no puede añadir cosas a la base de datos
   @Override
   public Iterable<Columnas> findAll(){
      return repositoryColumn.findAll();
   }
   @Transactional(readOnly = true)
   @Override
   public Optional<Columnas> findById(Long id){
      return repositoryColumn.findById(id);
   }
   @Transactional// para indicar que si hará cambios en nuestra base de datos
   @Override
   public Columnas save(Columnas columna){
      return repositoryColumn.save(columna);
   }
   @Transactional
   @Override
   public void deletebyId(Long id){
      repositoryColumn.deleteById(id);
   }
}