package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.TransactionMccCode;
import com.malcev.TransactionApplication.repository.TransactionMccCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionMccCodeService {
    private final TransactionMccCodeRepository transactionMccCodeRepository;

    public TransactionMccCodeService(TransactionMccCodeRepository transactionMccCodeRepository) {
        this.transactionMccCodeRepository = transactionMccCodeRepository;
    }

    public TransactionMccCode saveMccCode(TransactionMccCode mccCode) {
        transactionMccCodeRepository.save(mccCode);
        return mccCode;
    }
}
