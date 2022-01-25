package com.proyecto.backend.Controller;
import java.util.List;

import com.proyecto.backend.Entity.TransferEntity;
import com.proyecto.backend.Service.ITransferService;

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
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    ITransferService service;

    @GetMapping
    public List<TransferEntity> get() {
        return service.get();
    }

    @PostMapping
    public void addTransfer(@RequestBody TransferEntity c) {
        service.save(c);
    }
    @GetMapping(value = "/{documentNum}")
    public List<TransferEntity> login(@PathVariable("documentNum") String documentNum) {

        return service.findByDocumentNum(Integer.parseInt(documentNum));
    }
   

}

