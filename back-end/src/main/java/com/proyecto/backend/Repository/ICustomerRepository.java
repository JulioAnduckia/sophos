package com.proyecto.backend.Repository;

import java.util.Optional;

import com.proyecto.backend.Entity.CustomerEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    public Optional<CustomerEntity> findByEmailAndPassword(String email, String password); 
    public Optional<CustomerEntity> findByEmail(String email);
    public Optional<CustomerEntity> findByDocumentTypeAndDocumentNum(String documentType, String documentNum);
}
