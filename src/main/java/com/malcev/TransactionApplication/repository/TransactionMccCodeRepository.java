package com.malcev.TransactionApplication.repository;

import com.malcev.TransactionApplication.models.TransactionMccCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMccCodeRepository extends JpaRepository<TransactionMccCode, Long> {
}