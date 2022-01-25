package com.proyecto.backend.Controller;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.AccountEntity;
import com.proyecto.backend.Entity.CustomerEntity;
import com.proyecto.backend.Service.IAccountService;
import com.proyecto.backend.Service.ICustomerService;

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
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService service;
    @Autowired
    IAccountService service2;

    @GetMapping
    public List<CustomerEntity>get() {
        return service.get();
    }

   @PostMapping
    public void addCliente(@RequestBody CustomerEntity c){
        service.save(c);
        
    }
    @PostMapping(value= "/{id}")
    public String deleteCliente(@PathVariable("id") AccountEntity c, @PathVariable("id") CustomerEntity x ){
        service.delete(x);
        service2.delete(c);
        return "lola";
    }
    
    @GetMapping(value ="/{email}/{password}")
    public Optional<CustomerEntity>login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.findByEmailAndPassword( email, password);
    }
}
