package com.proyecto.backend.Entity;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "documentType")
    private String documentType;
    @Column(name = "documentNum")
    private int documentNum;
    @Column(name = "birthDate")
    private Date birthDate;
    @Column(name = "email")
    private String email;
    @Column(name = "initDate")
    private Date initDate = new Date();
    @Column(name = "password")
    private String password;

    public CustomerEntity(){}

    public CustomerEntity(int id, String name, String lastName, String documentType, int documentNum, Date birthDate,
            String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNum = documentNum;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public int getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(int documentNum) {
        this.documentNum = documentNum;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
    

}
