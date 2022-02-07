package com.proyecto.backend.Repository;

import com.proyecto.backend.Entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUserName(String userName);
    
}
