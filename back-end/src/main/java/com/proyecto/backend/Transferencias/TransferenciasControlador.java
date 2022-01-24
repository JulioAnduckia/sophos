package com.proyecto.backend.Transferencias;
import java.util.List;


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
@RequestMapping("/transferencias")
public class TransferenciasControlador {

    @Autowired
    TransferenciasService service;

    @GetMapping
    public List<Transferencias> listar() {
        return service.listar();
    }

    @PostMapping
    public void addTransferencias(@RequestBody Transferencias c) {
        service.save(c);
    }
    @GetMapping(value = "/{numDocumento}")
    public List<Transferencias> login(@PathVariable("numDocumento") String numDocumento) {

        return service.findByNumDocumento(Integer.parseInt(numDocumento));
    }
   

}

