package com.malcev.TransactionApplication.repository;

import com.malcev.TransactionApplication.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public List<Transaction> findAllByTrCustomerIdOrderByTrDatetime(Long trCustomerId);
}
