package com.proyecto.backend.Cuenta;

import java.util.List;
import java.util.Optional;


public interface CuentaService {
    public List<Cuenta>listar();
    public Optional<Cuenta>listarId(int id);
    public void save(Cuenta c);
    public void delete(Cuenta c);
    public Optional<Cuenta> findByNumDocumento(int numDocumento);
    public Optional<Cuenta> findByNumCuenta(int numCuenta);
    
}