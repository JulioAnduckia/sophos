package com.proyecto.backend.Cuenta;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CuentaRepositorio extends CrudRepository<Cuenta, Integer> {

    public Optional<Cuenta> findByNumDocumento(int numDocumento);
    public Optional<Cuenta> findByNumCuenta(int numCuenta);
    
}
