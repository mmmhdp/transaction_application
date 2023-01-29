package com.malcev.TransactionApplication.config;

import com.malcev.TransactionApplication.models.TransactionMccCode;
import com.malcev.TransactionApplication.repository.TransactionMccCodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TransactionMccCodeConfig {
    private static final Logger transactionMccCodeDatabaseInitLogger = LoggerFactory.getLogger(TransactionMccCodeConfig.class);
//    @Bean
    public CommandLineRunner initMccCodeDatabase(TransactionMccCodeRepository transactionMccCodeRepository){

        return args -> {
            transactionMccCodeDatabaseInitLogger.info("Preload customer:" +
                    transactionMccCodeRepository
                            .save(TransactionMccCode.builder()
                                    .mccCode(1000L)
                                    .mccCodeDescription("интернет магазин")
                                    .build()));
            transactionMccCodeDatabaseInitLogger.info("Preload customer:" +
                    transactionMccCodeRepository
                            .save(TransactionMccCode.builder()
                                    .mccCode(2000L)
                                    .mccCodeDescription("банк")
                                    .build()));
        } ;
    }
}
