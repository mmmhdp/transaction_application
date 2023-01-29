package com.malcev.TransactionApplication.config;

import com.malcev.TransactionApplication.models.TransactionType;
import com.malcev.TransactionApplication.repository.TransactionTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TransactionTypeConfig {
    private static final Logger transactionTypeDatabaseInitLogger = LoggerFactory.getLogger(TransactionTypeConfig.class);
//    @Bean
    public CommandLineRunner initTransactionTypeDatabase(TransactionTypeRepository transactionTypeRepository){

        return args -> {
            transactionTypeDatabaseInitLogger.info("Preload customer:" +
                    transactionTypeRepository
                            .save(
                                    TransactionType.builder()
                                            .type(1000L)
                                            .typeDescription("оплата по дебетовой карте")
                                            .build()
                            ));
            transactionTypeDatabaseInitLogger.info("Preload customer:" +
                    transactionTypeRepository
                            .save(
                                    TransactionType.builder()
                                            .type(1111L)
                                            .typeDescription("оплата по кредитной карте")
                                            .build()
                            ));
        } ;
    }
}
