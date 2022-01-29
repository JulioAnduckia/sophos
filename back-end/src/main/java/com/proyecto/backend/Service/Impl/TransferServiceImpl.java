package com.proyecto.backend.Service.Impl;

import java.util.List;

import com.proyecto.backend.Entity.TransferEntity;
import com.proyecto.backend.Repository.ITransferRepository;
import com.proyecto.backend.Service.ITransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements ITransferService{

    @Autowired
    ITransferRepository data;

    @Override
    public List<TransferEntity> get() {
        return (List<TransferEntity>) data.findAll();
    }

    @Override
    public void save(TransferEntity c) {
        data.save(new TransferEntity(c.getId(), c.getTransferDate(), c.getMovementType(),
         c.getTransferAccount(), c.getToTransfer(), c.getBalance(), c.getDocumentNum()));
    }

    @Override
    public void delete(TransferEntity c) {
        data.delete(c);
    }

    @Override
    public List<TransferEntity> findByDocumentNum(int documentNum) {
        return data.findByDocumentNum(documentNum);
    }


    
}
