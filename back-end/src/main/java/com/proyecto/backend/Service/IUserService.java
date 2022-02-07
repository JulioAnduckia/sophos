package com.proyecto.backend.Service;

import java.util.List;

import com.proyecto.backend.Entity.UserEntity;

public interface IUserService {
    
    public List<UserEntity> get() throws Exception;
	
	public UserEntity save(UserEntity users) throws Exception;
	
	public boolean delete(String userName) throws Exception;
}
