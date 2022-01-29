package com.proyecto.backend.Service;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.AccountEntity;
import com.proyecto.backend.Entity.CustomerEntity;


public interface IAccountService {
    public List<AccountEntity>get() throws Exception;
    public AccountEntity save(AccountEntity c) throws Exception;
    public boolean delete(String number) throws Exception;
    public Optional<AccountEntity> findByAccountNum(int accountNum) throws Exception;
    public Optional<AccountEntity> findByAccountTypeAndCustomer(String accountType, CustomerEntity customer) throws Exception;
}