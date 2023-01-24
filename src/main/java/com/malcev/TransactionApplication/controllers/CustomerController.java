package com.malcev.TransactionApplication.controllers;

import com.malcev.TransactionApplication.models.Customer;
import com.malcev.TransactionApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/session")
public class CustomerController {
    private final CustomerService customerService;
@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String showInitPage(){
    return "/customer/init-page";
    }

    @GetMapping("/sign-in")
    public String showSingInPage(@ModelAttribute("existedCustomer") Customer existedCustomer){
    return "customer/sign-in";
    }
    @PostMapping("/sign-in")
    public String openSessionForExistedCustomer(@ModelAttribute("existedCustomer") Customer existedCustomer){
        customerService.createNewCustomer(existedCustomer);
        Long customerId = existedCustomer.getCustomerId();
        return "redirect:/session/"+customerId;
    }
    @GetMapping("/sign-up")
    public String showSignUpPage(@ModelAttribute("newCustomer") Customer newCustomer){
    return "customer/sign-up";
    }
    @PostMapping("/sign-up")
    public String openSessionForNewCustomer(@ModelAttribute("newCustomer") Customer newCustomer){
        customerService.createNewCustomer(newCustomer);
        Long customerId = newCustomer.getCustomerId();
        return "redirect:/session/"+customerId;
    }
    @GetMapping("/{customerId}")
    public String showCustomerPage(@PathVariable String customerId, Model model){
    model.addAttribute("customerId", customerId);
    return "customer/customer-page";
    }
}
