package com.proyecto.backend.Repository;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.AccountEntity;
import com.proyecto.backend.Entity.CustomerEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IAccountRepository extends CrudRepository<AccountEntity, Integer> {
    public Optional<AccountEntity> findByAccountNum(int accountNum);
    public List<AccountEntity> findByCustomerId(int id);
    public Optional<AccountEntity> findByAccountTypeAndCustomer(String accountType, CustomerEntity customer);
    
    
}
