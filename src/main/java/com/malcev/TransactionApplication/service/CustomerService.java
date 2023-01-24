package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.Customer;
import com.malcev.TransactionApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer createNewCustomer(Customer newCustomer){
        return customerRepository.save(newCustomer);
    }
    public Customer findCustomerByNameAndSurnameAndPassword(String customerName, String surname, String password){
        return null;
    }
    public Customer customerValidation(Customer customerToValidate){
        return null;
    }
}
