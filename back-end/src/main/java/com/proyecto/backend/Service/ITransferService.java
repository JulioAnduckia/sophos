package com.proyecto.backend.Service;

import java.util.List;

import com.proyecto.backend.Entity.TransferEntity;

public interface ITransferService {
    public List<TransferEntity>get();
    public void save(TransferEntity c);
    public void delete(TransferEntity c);
    public List<TransferEntity> findByDocumentNum(int documentNum);
}
