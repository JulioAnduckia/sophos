package com.proyecto.backend.Entity;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class AccountEntity implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "documentNum")
    private int documentNum;
    @Column(name = "accountType")
    private String accountType;
    @Column(name = "accountNum")
    private int accountNum;
    @Column(name = "state")
    private String state;
    @Column(name = "balance")
    private double balance;
    @Column(name = "openDate")
    private Date openDate= new Date();
    
    public AccountEntity(){}

    public AccountEntity(int id, int documentNum, String accountType, int accountNum, String state, double balance) {
        this.id = id;
        this.documentNum = documentNum;
        this.accountType = accountType;
        this.state = state;
        this.balance = balance;
        if(accountNum != 0){ this.accountNum = accountNum;}
        else{this.accountNum= (int) (Math.random() * 99999 ) + 10000;}
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(int documentNum) {
        this.documentNum = documentNum;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    
    

}
