package com.proyecto.backend.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteService {
    @Autowired
    private ClienteRepositorio data;

    @Override
    public List<Cliente> listar() {
        // TODO Auto-generated method stub
        return (List<Cliente>) data.findAll();
    }

    @Override
    public Optional<Cliente> listarId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Cliente c) {
        data.save(new Cliente(c.getId(), c.getNombre(),c.getApellido(),c.getTipoDocumento(),c.getNumDocumento(),
        c.getFechaNacimiento(),c.getEmail(), c.getContra()));
    }

    @Override
    public void delete(Cliente c) {
        data.delete(c);
        
    }

    @Override
    public Optional<Cliente> findByEmailAndContra(String email, String Contra) {
        // TODO Auto-generated method stub
        return data.findByEmailAndContra(email, Contra);
    }

}
