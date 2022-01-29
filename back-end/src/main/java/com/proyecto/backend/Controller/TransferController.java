package com.proyecto.backend.Controller;
import java.util.List;

import com.proyecto.backend.Entity.TransferEntity;
import com.proyecto.backend.Service.ITransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TransferEntity>> get() {
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(service.get());
    }

    @PostMapping
    public ResponseEntity<String> addTransfer(@RequestBody TransferEntity c) {
        service.save(c);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body("Transfer created");
    }
    @GetMapping(value = "/{documentNum}")
    public ResponseEntity<List<TransferEntity>> login(@PathVariable("documentNum") String documentNum) {

        return ResponseEntity
        .status(HttpStatus.OK)
        .body(service.findByDocumentNum(Integer.parseInt(documentNum)));
    }
   

}

