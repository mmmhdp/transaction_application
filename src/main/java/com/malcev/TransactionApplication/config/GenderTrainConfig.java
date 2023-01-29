package com.malcev.TransactionApplication.config;

import com.malcev.TransactionApplication.models.GenderTrain;
import com.malcev.TransactionApplication.repository.GenderTrainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GenderTrainConfig {
    private static final Logger customerDatabaseInitLogger = LoggerFactory.getLogger(GenderTrainConfig.class);
//    @Bean
    public CommandLineRunner initGenderDatabase(GenderTrainRepository genderTrainRepository){

        return args -> {
            customerDatabaseInitLogger.info("Preload customer:" +
                    genderTrainRepository
                            .save(
                                    GenderTrain.builder()
                                            .CustomerId(1L)
                                            .gender("male")
                                            .build()
                            ));
            customerDatabaseInitLogger.info("Preload customer:" +
                    genderTrainRepository
                            .save(
                                    GenderTrain.builder()
                                            .CustomerId(2L)
                                            .gender("female")
                                            .build()
                            ));
            customerDatabaseInitLogger.info("Preload customer:" +
                    genderTrainRepository
                            .save(
                                    GenderTrain.builder()
                                            .CustomerId(3L)
                                            .build()
                            ));
        } ;
    }
}
