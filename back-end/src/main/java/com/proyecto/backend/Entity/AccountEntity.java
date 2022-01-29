package com.proyecto.backend.Entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class AccountEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountNum")
    private int accountNum;
    @Column(name = "accountType")
    private String accountType;
    @Column(name = "state")
    private String state;
    @Column(name = "balance")
    private double balance;
    @Column(name = "openDate")
    private Date openDate= new Date();

    @JoinColumn(name="id")
    @ManyToOne
    private CustomerEntity customer;


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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
    
    

}
