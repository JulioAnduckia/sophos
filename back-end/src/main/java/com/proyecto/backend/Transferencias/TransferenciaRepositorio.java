package com.proyecto.backend.Transferencias;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TransferenciaRepositorio extends CrudRepository<Transferencias, Integer>  {
    public List<Transferencias> findByNumDocumento(int numDocumento);
}
