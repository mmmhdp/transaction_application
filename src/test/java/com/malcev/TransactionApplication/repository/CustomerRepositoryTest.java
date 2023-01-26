package com.malcev.TransactionApplication.repository;

import com.malcev.TransactionApplication.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CustomerRepositoryTest {

    private final CustomerRepository customerRepository;

    CustomerRepositoryTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Test
    public void saveNewCustomer(){

    }
}