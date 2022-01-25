package com.proyecto.backend.Repository;

import java.util.List;

import com.proyecto.backend.Entity.TransferEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ITransferRepository extends CrudRepository<TransferEntity, Integer>  {
    public List<TransferEntity> findByDocumentNum(int documentNum);
}
