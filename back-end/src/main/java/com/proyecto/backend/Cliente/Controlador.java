package com.proyecto.backend.Cliente;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Cuenta.Cuenta;
import com.proyecto.backend.Cuenta.CuentaService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins ="http://localhost:4200", maxAge = 3600 )
@RestController
@RequestMapping("/form")
public class Controlador {

    @Autowired
    ClienteService service;
    @Autowired
    CuentaService service2;

    @GetMapping
    public List<Cliente>listar() {
        return service.listar();
    }

   @PostMapping
    public void addCliente(@RequestBody Cliente c){
        service.save(c);
        
    }
    @PostMapping(value= "/{id}")
    public String deleteCliente(@PathVariable("id") Cuenta c, @PathVariable("id") Cliente x ){
        service.delete(x);
        service2.delete(c);
        return "lola";
    }
    
    @GetMapping(value ="/{email}/{contra}")
    public Optional<Cliente>login(@PathVariable("email") String email, @PathVariable("contra") String contra) {
        return service.findByEmailAndContra( email, contra);
    }
}
