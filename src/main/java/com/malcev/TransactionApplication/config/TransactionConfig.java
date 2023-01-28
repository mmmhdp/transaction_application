package com.malcev.TransactionApplication.config;

import com.malcev.TransactionApplication.models.Transaction;
import com.malcev.TransactionApplication.repository.TransactionRepository;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TransactionConfig {
    private static final Logger transactionDatabaseInitLogger = LoggerFactory.getLogger(TransactionConfig.class);

    @Bean
    CommandLineRunner initDatabase(TransactionRepository transactionRepository){
        return args -> {
            transactionDatabaseInitLogger.info("Preloading"
                    + transactionRepository
                    .save(new Transaction(
                            1L,
                            "15 01:40:52",
                            1111L,
                            1000L,
                            -5224L,
                            111111L)));
            transactionDatabaseInitLogger.info("Preloading"
                    + transactionRepository
                    .save(new Transaction(
                            2L,
                            "15 02:40:52",
                            1111L,
                            1000L,
                            +1231L,
                            111111L)));

            transactionDatabaseInitLogger.info("Preloading"
                    + transactionRepository
                    .save(new Transaction(
                            3L,
                            "15 15:18:32",
                            3333L,
                            2000L,
                            -100L,
                            11122233L)));
        };
    }
}

