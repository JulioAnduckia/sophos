package com.proyecto.backend.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.proyecto.backend.Entity.AccountEntity;
import com.proyecto.backend.Entity.CustomerEntity;
import com.proyecto.backend.Repository.IAccountRepository;
import com.proyecto.backend.Service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository data;

    @PersistenceContext
	EntityManager entityManager;

    @Override
    public List<AccountEntity> get() {
        return (List<AccountEntity>) data.findAll();
    }

    @Override
    public AccountEntity save(AccountEntity c) throws Exception{
            return data.save(c);      
    }

    @Override
    public boolean delete(Integer accountNum) throws Exception {
        data.deleteById(accountNum);
        return true;
    }


    /*@Override
    public Optional<AccountEntity> findByDocumentNum(int documentNum) {
        return data.findByDocumentNum(documentNum);
    }
*/
    @Override
    public Optional<AccountEntity> findByAccountNum(int accountNum) {
        return data.findByAccountNum(accountNum);
    }

    /*@Override
    public List<AccountEntity> getByCustomerId(Integer customerId) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }*/

    @Override
    public Optional<AccountEntity> findByAccountTypeAndCustomer(String accountType, CustomerEntity customer) {
        return data.findByAccountTypeAndCustomer(accountType, customer);
    }

    @Override
    public List<AccountEntity> findByCustomerId(int id) throws Exception {
        return data.findByCustomerId(id);
    }

    
     

    

}
