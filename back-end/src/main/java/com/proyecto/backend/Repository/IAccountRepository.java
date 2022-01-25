package com.proyecto.backend.Repository;

import java.util.Optional;

import com.proyecto.backend.Entity.AccountEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IAccountRepository extends CrudRepository<AccountEntity, Integer> {

    public Optional<AccountEntity> findByDocumentNum(int documentNum);
    public Optional<AccountEntity> findByAccountNum(int accountNum);
    
}
