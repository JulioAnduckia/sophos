package com.proyecto.backend.Controller;

import java.util.List;
import java.util.Optional;



import com.proyecto.backend.Entity.AccountEntity;
import com.proyecto.backend.Service.IAccountService;

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
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    IAccountService service;

    @GetMapping(value="/{documentNum}")//duda!
    public Optional<AccountEntity> dataLogin(@PathVariable("documentNum") String documentNum) {
        return service.findByDocumentNum(Integer.parseInt(documentNum));
    }

    @GetMapping
    public List<AccountEntity>getAll() {
        return service.get();
    }
    
    @PostMapping(value = "/delete")
    public void deleteAccount(@RequestBody AccountEntity c) {
        service.delete(c);

    }

    @PostMapping
    public void addAccount(@RequestBody AccountEntity c) {
        service.save(c);
        
    }

    @GetMapping(value = "/transfer/{accountNum}")
    public Optional<AccountEntity> AccountTransfer(@PathVariable("accountNum") String accountNum) {

        return service.findByAccountNum(Integer.parseInt(accountNum));
    }

    

}
