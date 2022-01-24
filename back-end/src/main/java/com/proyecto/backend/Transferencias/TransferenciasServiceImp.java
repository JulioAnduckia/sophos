package com.proyecto.backend.Transferencias;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciasServiceImp implements TransferenciasService{

    @Autowired
    TransferenciaRepositorio data;

    @Override
    public List<Transferencias> listar() {
        // TODO Auto-generated method stub
        return (List<Transferencias>) data.findAll();
    }

    @Override
    public Optional<Transferencias> listarId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Transferencias c) {
        data.save(new Transferencias(c.getId(), c.getTipoMovimiento(), 
        c.getCuentaTraslado(), c.getTransferencia(), c.getSaldo(), c.getNumDocumento()));
    }

    @Override
    public void delete(Transferencias c) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Transferencias> findByNumDocumento(int numDocumento) {
        // TODO Auto-generated method stub
        return data.findByNumDocumento(numDocumento);
    }
    
}
