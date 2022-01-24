package com.proyecto.backend.Cliente;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {

    public Optional<Cliente> findByEmailAndContra(String email, String Contra);    
}
