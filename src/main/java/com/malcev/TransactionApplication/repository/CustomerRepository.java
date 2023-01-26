package com.malcev.TransactionApplication.repository;

import com.malcev.TransactionApplication.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findCustomerByNameAndSurnameAndPassword(String name, String surname, String password);
}