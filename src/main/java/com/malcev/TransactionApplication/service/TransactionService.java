package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.Transaction;
import com.malcev.TransactionApplication.models.TransactionAvgDayResultsDto;
import com.malcev.TransactionApplication.repository.AvgRepo;
import com.malcev.TransactionApplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AvgRepo avgRepo;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AvgRepo avgRepo) {
        this.transactionRepository = transactionRepository;
        this.avgRepo = avgRepo;
    }
    public Transaction saveTransactionToCustomersTransactionsList(Transaction transactionToSave, String customerId){
        Transaction trToSave = Transaction.builder()
//                .trCustomerId(Long.valueOf(customerId))
                .trCustomerId(transactionToSave.getTrCustomerId())
                .trDatetime(transactionToSave.getTrDatetime())
                .trMssCodeType(transactionToSave.getTrMssCodeType())
                .trType(transactionToSave.getTrType())
                .trAmount(transactionToSave.getTrAmount())
                .trTerminalId(transactionToSave.getTrTerminalId())
                .build();
        transactionRepository.save(trToSave);
        return transactionToSave;
    }

    public List<Transaction> getAllTransactionsForCustomerByCustomerId(String customerId) {
        long customerIdLong = Long.parseLong(customerId);
        List<Transaction> transactionList = transactionRepository.findAllByTrCustomerIdOrderByTrDatetime(customerIdLong);
        return transactionList;
    }
    public List<TransactionAvgDayResultsDto> print(){
//        return transactionRepository.findAllByTest();
        return avgRepo.findAll();
    }
}
