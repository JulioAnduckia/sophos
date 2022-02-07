package com.proyecto.backend.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.backend.Entity.UserEntity;
import com.proyecto.backend.Repository.IUserRepository;
import com.proyecto.backend.Service.IUserService;


@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	IUserRepository userRepository;

	@Override
	public List<UserEntity> get() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public UserEntity save(UserEntity user) throws Exception {
		
		return userRepository.save(user) ;
	}

	@Override
	public boolean delete(String userName) throws Exception {
		userRepository.deleteById(userName);
		return true;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity userVO = userRepository.findByUserName(userName);
		UserDetails userDetails = new User(userVO.getUserName(), userVO.getPassword(), new ArrayList<>());
		
		return userDetails;
	}
	


}