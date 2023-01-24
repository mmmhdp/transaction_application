package com.malcev.TransactionApplication.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {

    private GenderTrainRepository genderTrainRepository;
    @Autowired
    public CustomerRepositoryTest(GenderTrainRepository genderTrainRepository) {
        this.genderTrainRepository = genderTrainRepository;
    }
    @Test
    public void Test() {
    }
}