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
        Customer validCustomer = customerService.customerValidation(existedCustomer);
        if (validCustomer==null){
            return "redirect:/session/exceptions/sing-in-problem";
        }
        Long customerId = validCustomer.getCustomerId();
        return "redirect:/session/" + customerId;
    }
    @GetMapping("/exceptions/sing-in-problem")
    public String singInException(){
        return "exceptions/sign-in-can-not-find-user";
    }


    @GetMapping("/sign-up")
    public String showSignUpPage(@ModelAttribute("newCustomer") Customer newCustomer){
    return "customer/sign-up";
    }
    @PostMapping("/sign-up")
    public String openSessionForNewCustomer(@ModelAttribute("newCustomer") Customer newCustomer){
        if (customerService.customerValidation(newCustomer)!=null){
            return "redirect:/session";
        }
        Customer existedCustomer = customerService.createNewCustomer(newCustomer);
        Long customerId = existedCustomer.getCustomerId();
        return "redirect:/session/"+customerId;
    }


    @GetMapping("/{customerId}")
    public String showCustomerPage(@PathVariable String customerId, Model model){
    model.addAttribute("customerId", customerId);
    return "customer/customer-page";
    }
}
