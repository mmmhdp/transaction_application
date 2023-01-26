package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.Transaction;
import com.malcev.TransactionApplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Optional<Transaction> getAllTransactionsForCustomerByCustomerId(String customerId) {
        long customerIdLong = Long.parseLong(customerId);
        //тут метод, который производит select запрос и находит транзакации с индексом данного покупателя
        return null;
    }
}
