package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.Transaction;
import com.malcev.TransactionApplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactionsByUserId(Long userId){
        return null;
    }

    public List<Transaction> getAllTr(){
        return transactionRepository.findAll();
    }

    public void saveNewTr(Transaction newTransaction){
        transactionRepository.save(newTransaction);
    }
}
