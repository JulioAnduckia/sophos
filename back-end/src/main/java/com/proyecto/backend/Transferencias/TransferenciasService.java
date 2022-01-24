package com.proyecto.backend.Transferencias;

import java.util.List;
import java.util.Optional;

public interface TransferenciasService {
    public List<Transferencias>listar();
    public Optional<Transferencias>listarId(int id);
    public void save(Transferencias c);
    public void delete(Transferencias c);
    public List<Transferencias> findByNumDocumento(int numDocumento);
}
