package com.malcev.TransactionApplication.repository;

import com.malcev.TransactionApplication.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
