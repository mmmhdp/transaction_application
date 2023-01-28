package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.TransactionType;
import com.malcev.TransactionApplication.repository.TransactionTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeService {
    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    public TransactionType saveTransactionType(TransactionType transactionType) {
        transactionTypeRepository.save(transactionType);
        return transactionType;
    }
}
