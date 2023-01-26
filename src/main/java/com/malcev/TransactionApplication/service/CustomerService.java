package com.malcev.TransactionApplication.service;

import com.malcev.TransactionApplication.models.Customer;
import com.malcev.TransactionApplication.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer createNewCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
        return newCustomer;
    }
    public Customer customerValidation(Customer customerToValidate){
            return customerRepository
                    .findCustomerByNameAndSurnameAndPassword(
                            customerToValidate.getName(),
                            customerToValidate.getSurname(),
                            customerToValidate.getPassword()
                    );
    }
}
