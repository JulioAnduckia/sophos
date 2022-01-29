package com.proyecto.backend.Entity;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "transfers")
public class TransferEntity implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "transferDate")
    private Date transferDate= new Date();
    @Column(name = "movementType")
    private String movementType;
    @Column(name = "trasferAccount")
    private int transferAccount;
    @Column(name = "toTransfer")
    private double toTransfer;
    @Column(name = "balance")
    private double balance;
    @Column(name = "documentNum")
    private int documentNum;
    
    public TransferEntity(){}

    public TransferEntity(int id, Date transferDate, String movementType, int transferAccount, double toTransfer,
            double balance, int documentNum) {
        this.id = id;
        this.transferDate = transferDate;
        this.movementType = movementType;
        this.transferAccount = transferAccount;
        this.toTransfer = toTransfer;
        this.balance = balance;
        this.documentNum = documentNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public int getTransferAccount() {
        return transferAccount;
    }

    public void setTransferAccount(int transferAccount) {
        this.transferAccount = transferAccount;
    }

    public double getToTransfer() {
        return toTransfer;
    }

    public void setToTransfer(double toTransfer) {
        this.toTransfer = toTransfer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(int documentNum) {
        this.documentNum = documentNum;
    }

    

    
    
    
}
