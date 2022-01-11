package com.proyecto.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins ="http://localhost:4200", maxAge = 3600 )
@RestController
@RequestMapping("/datos")
public class Controlador {

    @Autowired
    ClienteService service;

    /*
     * @GetMapping("/registro")
     * public String listar(Model model){
     * List<Cliente>clientes=service.listar();
     * model.addAttribute("clientes", clientes);
     * return "index";
     */
    @GetMapping
    public List<Cliente>listar() {
        return service.listar();
    }

   @PostMapping
    public void addCliente(@RequestBody Cliente c){
        service.save(c);
        
    }
    
}
