package com.proyecto.backend.Service.Impl;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.CustomerEntity;
import com.proyecto.backend.Repository.ICustomerRepository;
import com.proyecto.backend.Service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository data;

    @Override
    public List<CustomerEntity> get() {
        return (List<CustomerEntity>) data.findAll();
    }

    @Override
    public void save(CustomerEntity c) {
        data.save(new CustomerEntity(c.getId(), c.getName(), c.getLastName(), 
        c.getDocumentType(), c.getDocumentNum(), c.getBirthDate(), c.getEmail(), c.getPassword()));
    }

    @Override
    public void delete(CustomerEntity c) {       
        data.delete(c);
    }

    @Override
    public Optional<CustomerEntity> findByEmailAndPassword(String email, String password) {
        return data.findByEmailAndPassword(email, password);
    }

    

}
