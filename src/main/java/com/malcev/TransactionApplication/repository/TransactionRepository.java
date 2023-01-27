package com.malcev.TransactionApplication.repository;

import com.malcev.TransactionApplication.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public List<Transaction> findAllByTrCustomerIdOrderByTrDatetime(Long trCustomerId);
}

