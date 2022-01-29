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
    public List<CustomerEntity> get() throws Exception {
        return (List<CustomerEntity>) data.findAll();
    }

    @Override
    public CustomerEntity save(CustomerEntity c) throws Exception{
        return data.save(c);
    }

    @Override
    public  boolean delete(Integer id) throws Exception {
		data.deleteById(id);
		return true;
    }

    @Override
    public Optional<CustomerEntity> findByEmailAndPassword(String email, String password) throws Exception {
        return data.findByEmailAndPassword(email, password);
    }

    @Override
    public Optional<CustomerEntity> findByEmail(String email) {
        return data.findByEmail(email);
    }

    @Override
    public Optional<CustomerEntity> findByDocumentTypeAndDocumentNum(String documentType, String documentNum) {
        return data.findByDocumentTypeAndDocumentNum(documentType, documentNum);
    }

    @Override
    public Optional<CustomerEntity> findById(Integer id) {
        
        return data.findById(id);
    }

    

}
