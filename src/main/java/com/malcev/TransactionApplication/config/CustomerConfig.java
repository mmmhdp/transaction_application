package com.malcev.TransactionApplication.config;

import com.malcev.TransactionApplication.models.Customer;
import com.malcev.TransactionApplication.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    private static final Logger customerDatabaseInitLogger = LoggerFactory.getLogger(CustomerConfig.class);
    @Bean
    public CommandLineRunner initCustomerDatabase(CustomerRepository customerRepository){

        return args -> {
           customerDatabaseInitLogger.info("Preload customer:" +
                   customerRepository
                           .save(new Customer("nikita","malcev","1234")));
            customerDatabaseInitLogger.info("Preload customer:" +
                    customerRepository
                            .save(new Customer("danil","tarasov","5432")));
            customerDatabaseInitLogger.info("Preload customer:" +
                    customerRepository
                            .save(new Customer("vova","pumpkinov","0020")));
        } ;
    }
}
