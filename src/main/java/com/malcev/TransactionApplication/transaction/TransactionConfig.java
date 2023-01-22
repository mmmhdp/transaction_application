package com.malcev.TransactionApplication.transaction;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TransactionConfig {
    private static final Logger log = LoggerFactory.getLogger(TransactionConfig.class);

    @Bean
    CommandLineRunner initDatabase(TransactionRepository transactionRepository){
        return args -> {
            log.info("Preloading"
                    + transactionRepository
                    .save(new Transaction(
                            111111L,
                            "15 01:40:52",
                            1111L,
                            1000L,
                            -5224L,
                            111111L)));
            log.info("Preloading"
                    + transactionRepository
                    .save(new Transaction(
                            111111L,
                            "15 02:40:52",
                            1111L,
                            1000L,
                            +1231L,
                            111111L)));

            log.info("Preloading"
                    + transactionRepository
                    .save(new Transaction(
                            111112L,
                            "15 15:18:32",
                            3333L,
                            2000L,
                            -100L,
                            11122233L)));
        };
    }
}

