package com.proyecto.backend.Service;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.AccountEntity;


public interface IAccountService {
    public List<AccountEntity>get();
    public void save(AccountEntity c);
    public void delete(AccountEntity c);
    public Optional<AccountEntity> findByDocumentNum(int documentNum);
    public Optional<AccountEntity> findByAccountNum(int accountNum);
    
}