package com.proyecto.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "userName")
    
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "jwt")
	private String jwt;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "firtsName")
	private String firstName;
	
	public UserEntity() {
	}

	public UserEntity(String userName, String jwt) {
		this.userName = userName;
		this.jwt = jwt;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
}
