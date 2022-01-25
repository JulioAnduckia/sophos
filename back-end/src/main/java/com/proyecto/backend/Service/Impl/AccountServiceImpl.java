package com.proyecto.backend.Service.Impl;

import java.util.List;
import java.util.Optional;

import com.proyecto.backend.Entity.AccountEntity;
import com.proyecto.backend.Repository.IAccountRepository;
import com.proyecto.backend.Service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository data;

    @Override
    public List<AccountEntity> get() {
        return (List<AccountEntity>) data.findAll();
    }

    @Override
    public void save(AccountEntity c) {
            data.save(new AccountEntity(c.getId(), c.getDocumentNum(), c.getAccountType(), 
            c.getAccountNum(), c.getState(), c.getBalance()));      
    }

    @Override
    public void delete(AccountEntity c) {
        data.delete(c);
        
    }

    @Override
    public Optional<AccountEntity> findByDocumentNum(int documentNum) {
        return data.findByDocumentNum(documentNum);
    }

    @Override
    public Optional<AccountEntity> findByAccountNum(int accountNum) {
        return data.findByAccountNum(accountNum);
    }

     

    

}
