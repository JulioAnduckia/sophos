package com.proyecto.backend;

import java.util.List;
import java.util.Optional;


public interface ClienteService {
    public List<Cliente>listar();
    public Optional<Cliente>listarId(int id);
    public void save(Cliente c);
    public void delete(Cliente c);

    
    
}
