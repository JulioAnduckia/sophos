package com.proyecto.backend.Cuenta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/cuenta")
public class Controlador2 {

    @Autowired
    CuentaService service;

    @GetMapping
    public List<Cuenta> listar() {
        return service.listar();
    }

    @PostMapping
    public void addCuenta(@RequestBody Cuenta c) {
        service.save(c);
    }

    @GetMapping(value = "/{numDocumento}")
    public Optional<Cuenta> login(@PathVariable("numDocumento") String numDocumento) {

        return service.findByNumDocumento(Integer.parseInt(numDocumento));
    }

    @GetMapping(value = "/transferencia/{numCuenta}")
    public Optional<Cuenta> Transferencia(@PathVariable("numCuenta") String numCuenta) {

        return service.findByNumCuenta(Integer.parseInt(numCuenta));
    }
    @PostMapping(value= "/delete")
    public void deleteCuenta(@RequestBody Cuenta c){
        service.delete(c);
        
    }

}
