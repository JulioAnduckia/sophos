package com.proyecto.backend.Service;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.CustomerEntity;


public interface ICustomerService {
    public List<CustomerEntity>get() throws Exception;
    public CustomerEntity save(CustomerEntity c) throws Exception;
    public boolean delete(Integer id) throws Exception;
    public Optional<CustomerEntity> findByEmailAndPassword(String email, String password) throws Exception;
    public Optional<CustomerEntity> findByEmail(String email) throws Exception;  
    public Optional<CustomerEntity> findByDocumentTypeAndDocumentNum(String documentType, String documentNum) throws Exception;
    public Optional<CustomerEntity> findById(Integer id)throws Exception;
}
