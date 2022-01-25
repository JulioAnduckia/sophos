package com.proyecto.backend.Service;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.CustomerEntity;


public interface ICustomerService {
    public List<CustomerEntity>get();
    public void save(CustomerEntity c);
    public void delete(CustomerEntity c);
    public Optional<CustomerEntity> findByEmailAndPassword(String email, String password);
    
    
}
