package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.Transaction;
import com.malcev.TransactionApplication.models.DTO.TransactionAvgDayResultsDto;
import com.malcev.TransactionApplication.repository.DTO.TransactionAvgDayResultsDtoRepository;
import com.malcev.TransactionApplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionAvgDayResultsDtoRepository transactionAvgDayResultsDtoRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, TransactionAvgDayResultsDtoRepository transactionAvgDayResultsDtoRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionAvgDayResultsDtoRepository = transactionAvgDayResultsDtoRepository;
    }
    public Transaction saveTransactionToCustomersTransactionsList(Transaction transactionToSave, String customerId){
        Transaction trToSave = Transaction.builder()
//                .trCustomerId(Long.valueOf(customerId))
                // возможен переход на внесение транзакций под id текущего пользователяGender
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
    public List<TransactionAvgDayResultsDto> getAvgResultsWithSpecificParameters(){
        return transactionAvgDayResultsDtoRepository.findAll();
    }
}
