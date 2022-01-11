package com.proyecto.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {

    //List<Cliente>findAll();
    
}
