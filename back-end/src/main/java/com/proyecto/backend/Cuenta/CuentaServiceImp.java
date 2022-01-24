package com.proyecto.backend.Cuenta;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImp implements CuentaService {
    @Autowired
    private CuentaRepositorio data;

    @Override
    public List<Cuenta> listar() {
        // TODO Auto-generated method stub
        return (List<Cuenta>) data.findAll();
    }

    @Override
    public Optional<Cuenta> listarId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Cuenta c) {
    
        data.save(new Cuenta(c.getId(),c.getNumDocumento(), c.getTipoCuenta(),c.getNumCuenta(), c.getEstado(), c.getSaldo(), c.getFechaApertura()));
        
    }

    @Override
    public void delete(Cuenta c) {
        data.delete(c);
        
    }

    @Override
    public Optional<Cuenta> findByNumDocumento(int numDocumento) {
        return data.findByNumDocumento(numDocumento);
    }

    @Override
    public Optional<Cuenta> findByNumCuenta(int numCuenta) {
        return data.findByNumCuenta(numCuenta);
    }

   

    

}
